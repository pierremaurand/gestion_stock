package com.pierremaurand.backend.role;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pierremaurand.backend.exception.EntityNotFoundException;
import com.pierremaurand.backend.exception.ErrorCode;
import com.pierremaurand.backend.exception.InvalidEntityException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImp implements RoleService{
    
    private final RoleRepository roleRepository;
    
    @Override
	public RoleDto save(RoleDto dto) {
		List<String> errors = RoleValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Role is not valid {}", dto);
            throw new InvalidEntityException("Le role n'est pas valide", ErrorCode.ROLE_NOT_VALID,errors);
        }

        Optional<Role> role = roleRepository.findByNomAndUtilisateurId(dto.getNom(), dto.getUtilisateur().getId());

        if(role.isEmpty()) {
            return RoleDto.fromEntity(roleRepository.save(RoleDto.toEntity(dto)));
        }

        return RoleDto.fromEntity(role.get());
	}

	@Override
	public RoleDto findById(Integer id) {
		if(id == null) {
            log.error("Role Id is null");
            return null;
        }

        return roleRepository.findById(id)
            .map(RoleDto::fromEntity)
            .orElseThrow(() -> 
                new EntityNotFoundException(
                    "Aucun role avec l'ID = " + id + " n'a été trouvé dans la BDD",
                    ErrorCode.ROLE_NOT_FOUND)
            );
	}

	@Override
	public RoleDto findByNom(String nom) {
		if(StringUtils.hasLength(nom)) {
            log.error("Role name is null");
            return null;
        }

        return roleRepository.findByNom(nom)
            .map(RoleDto::fromEntity)
            .orElseThrow(() -> 
                new EntityNotFoundException(
                    "Aucun role avec le NOM = " + nom + " n'a été trouvé dans la BDD",
                    ErrorCode.ROLE_NOT_FOUND)
            );
	}

	@Override
	public List<RoleDto> findAll() {
		return roleRepository.findAll().stream()
                .map(RoleDto::fromEntity)
                .collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id == null) {
            log.error("Role Id is null");
            return;
        }

        roleRepository.deleteById(id);
	}

	@Override
	public List<RoleDto> findByUtilisateurId(Integer id) {
		if(id == null) {
            log.error("Utilisateur ID is null");
            return null;
        }

        return roleRepository.findByUtilisateurId(id).stream()
                .map(RoleDto::fromEntity)
                .collect(Collectors.toList());
	}

}
