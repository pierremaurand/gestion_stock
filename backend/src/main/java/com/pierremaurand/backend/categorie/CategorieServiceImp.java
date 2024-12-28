package com.pierremaurand.backend.categorie;

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
public class CategorieServiceImp implements CategorieService{

    private final CategorieRepository repository;

    @Override
    public CategorieDto save(CategorieDto dto) {
        List<String> errors = CategorieValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Category is not valid {}", dto);
            throw new InvalidEntityException("La catégorie n'est pas valide", ErrorCode.CATEGORY_NOT_VALID,errors);
        }

        return CategorieDto.fromEntity(
            repository.save(
                CategorieDto.toEntity(dto)
            )
        );
    }

    @Override
    public CategorieDto findById(Integer id) {
        if(id == null) {
            log.error("Category Id is null");
            return null;
        }

        Optional<Categorie> categorie = repository.findById(id);

        return Optional.of(CategorieDto.fromEntity(categorie.get())).orElseThrow(() -> 
            new EntityNotFoundException(
                "Aucune catégorie avec l'ID = " + id + " n'a été trouvé dans la BDD",
                ErrorCode.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public CategorieDto findByCode(String code) {
        if(!StringUtils.hasLength(code)) {
            log.error("Category code is null");
            return null;
        }

        Optional<Categorie> categorie = repository.findByCode(code);

        return Optional.of(CategorieDto.fromEntity(categorie.get())).orElseThrow(() -> 
            new EntityNotFoundException(
                "Aucune catégorie avec le CODE = " + code + " n'a été trouvé dans la BDD",
                ErrorCode.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public List<CategorieDto> findAll() {
        return repository.findAll().stream()
            .map(CategorieDto::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null) {
            log.error("Category Id is null");
            return;
        }

        repository.deleteById(id);
    }

}
