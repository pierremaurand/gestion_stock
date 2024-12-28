package com.pierremaurand.backend.fournisseur;

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
public class FournisseurServiceImp implements FournisseurService{

    private final FournisseurRepository repository;

    @Override
    public FournisseurDto save(FournisseurDto dto) {
       List<String> errors = FournisseurValidator.validate(dto);

       if(!errors.isEmpty()) {
            log.error("Fournisseur is not valid {}", dto);
            throw new InvalidEntityException(
                "Le fournisseur n'est pas valide",
                ErrorCode.FOURNISSEUR_NOT_VALID,
                errors
            );
       }

       return FournisseurDto.fromEntity(
            repository.save(FournisseurDto.toEntity(dto))
       );
    }

    @Override
    public FournisseurDto findById(Integer id) {
       if(id == null) {
            log.error("Fournisseur Id is null");
            return null;
        }

        return Optional.of(FournisseurDto.fromEntity(repository.findById(id).get())).orElseThrow(() -> 
            new EntityNotFoundException(
                "Aucun fournisseur avec l'ID = " + id + " n'a été trouvé dans la BDD",
                ErrorCode.FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public List<FournisseurDto> findAll() {
        return repository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null) {
            log.error("Fournisseur ID is null");
            return;
        }
        repository.deleteById(id);
    }

}
