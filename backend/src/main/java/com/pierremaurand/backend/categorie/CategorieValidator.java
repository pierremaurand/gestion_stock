package com.pierremaurand.backend.categorie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class CategorieValidator {

    public static List<String> validate(CategorieDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null || !StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseigner le code de la catégorie");
        }

        return errors;
    }
}
