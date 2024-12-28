package com.pierremaurand.backend.entreprise;

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
public class EntrepriseServiceImp implements EntrepriseService{
    
    private final EntrepriseRepository repository;

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Entreprise is not valid {}", dto);
            throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCode.ENTREPRISE_NOT_VALID,errors);
        }

        return EntrepriseDto.fromEntity(
            repository.save(EntrepriseDto.toEntity(dto))
        );
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if(id == null) {
            log.error("Entreprise Id is null");
            return null;
        }

        return Optional.of(EntrepriseDto.fromEntity(repository.findById(id).get())).orElseThrow(() -> 
            new EntityNotFoundException(
                "Aucune entreprise avec l'ID = " + id + " n'a été trouvé dans la BDD",
                ErrorCode.ENTREPRISE_NOT_FOUND)
        );
    }

    @Override
    public List<EntrepriseDto> findAll() {
       return repository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null) {
            log.error("Entreprise ID is null");
            return;
        }
        repository.deleteById(id);
    }

    

}
