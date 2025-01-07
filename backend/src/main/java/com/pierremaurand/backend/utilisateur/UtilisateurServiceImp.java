package com.pierremaurand.backend.utilisateur;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pierremaurand.backend.exception.EntityNotFoundException;
import com.pierremaurand.backend.exception.ErrorCode;
import com.pierremaurand.backend.exception.InvalidEntityException;
import com.pierremaurand.backend.role.RoleDto;
import com.pierremaurand.backend.role.RoleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UtilisateurServiceImp implements UtilisateurService{

    private final UtilisateurRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Utilisateur is not valid {}", dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCode.UTILISATEUR_NOT_VALID,errors);
        }

        if(dto.getId() == null && userAlreadyExists(dto.getEmail())) {
            log.error("Utilisateur Email exists");
            throw new InvalidEntityException(
                "Un autre utilisateur avec le meme email existe deja", 
                ErrorCode.UTILISATEUR_ALREADY_EXISTS,
                Collections.singletonList("Un autre utilisateur avec le meme email existe deja dans la BDD"));
        }

        dto.setMotDePasse(passwordEncoder.encode(dto.getMotDePasse()));

        Utilisateur utilisateur = repository.save(UtilisateurDto.toEntity(dto));

        if(dto.getRoles() == null) {
            roleService.save(RoleDto.builder()
                .nom("USER")
                .utilisateur(UtilisateurDto.fromEntity(utilisateur))
                .build());
        } else {
            dto.getRoles().forEach(roleDto -> {
                roleDto.setUtilisateur(UtilisateurDto.fromEntity(utilisateur));
                roleService.save(roleDto);
            });
        }

        return UtilisateurDto.fromEntity(utilisateur);
    }

    private boolean userAlreadyExists(String email) {
        Optional<Utilisateur> utilisateur = repository.findByEmail(email);
        return utilisateur.isPresent();
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if(id == null) {
            log.error("Utilisateur Id is null");
            return null;
        }

        return repository.findById(id)
            .map(UtilisateurDto::fromEntity)
            .orElseThrow(() -> 
                new EntityNotFoundException(
                    "Aucun utilisateur avec l'ID = " + id + " n'a été trouvé dans la BDD",
                    ErrorCode.UTILISATEUR_NOT_FOUND)
            );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return repository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null) {
            log.error("Utilisateur ID is null");
            return;
        }
        repository.deleteById(id);
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        if(!StringUtils.hasLength(email)) {
            log.error("Utilisateur Email is null");
            return null;
        }

        return repository.findByEmail(email)
            .map(UtilisateurDto::fromEntity)
            .orElseThrow(() -> 
                new EntityNotFoundException(
                    "Aucun utilisateur avec l'Email = " + email + " n'a été trouvé dans la BDD",
                    ErrorCode.UTILISATEUR_NOT_FOUND)
            );
    }

}
