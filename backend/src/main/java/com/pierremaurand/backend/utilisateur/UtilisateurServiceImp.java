package com.pierremaurand.backend.utilisateur;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pierremaurand.backend.exception.EntityNotFoundException;
import com.pierremaurand.backend.exception.ErrorCode;
import com.pierremaurand.backend.exception.InvalidEntityException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UtilisateurServiceImp implements UtilisateurService{

    private final UtilisateurRepository repository;

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Utilisateur is not valid {}", dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCode.UTILISATEUR_NOT_VALID,errors);
        }

        return UtilisateurDto.fromEntity(
            repository.save(UtilisateurDto.toEntity(dto))
        );
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if(id == null) {
            log.error("Utilisateur Id is null");
            return null;
        }

        return Optional.of(UtilisateurDto.fromEntity(repository.findById(id).get())).orElseThrow(() -> 
            new EntityNotFoundException(
                "Aucun utilisateur avec l'ID = " + id + " n'a été trouvé dans la BDD",
                ErrorCode.ENTREPRISE_NOT_FOUND)
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

}
