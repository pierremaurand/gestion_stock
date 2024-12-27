package com.pierremaurand.backend.article;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class ArticleValidator {

    public static List<String> validate(ArticleDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null) {
            errors.add("Veuillez renseigner le code de l'article");
            errors.add("Veuillez renseigner le prix unitaire HT de l'article");
            errors.add("Veuillez renseigner le taux TVA de l'article");
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
            errors.add("Veuillez selectionner une catégorie");
        } else {
            if(!StringUtils.hasLength(dto.getCode())) {
                errors.add("Veuillez renseigner le code de l'article");
            }

            if(dto.getPrixUnitaireHt() == 0) {
                errors.add("Veuillez renseigner le prix unitaire HT de l'article");
            }

            if(dto.getTauxTva() == 0) {
                errors.add("Veuillez renseigner le taux TVA de l'article");
            }

            if(dto.getPrixUnitaireTtc() == 0) {
                errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
            }

            if(dto.getCategorie() == null) {
                errors.add("Veuillez selectionner une catégorie");
            }
        }

        return errors;
    }
}
