package com.pierremaurand.backend.vente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class VenteValidator {

    public static List<String> validate(VenteDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null) {
            errors.add("Veuillez renseigner le code de la vente");
            errors.add("Veuillez renseigner la date de la vente");
            errors.add("Veuillez insérer au moins un article à vendre");
        } else {
            if(!StringUtils.hasLength(dto.getCode())) {
                errors.add("Veuillez renseigner le code de la vente");
            }

            if(dto.getDateVente() == null) {
                errors.add("Veuillez renseigner la date de la vente");
            }

            if(dto.getLigneVentes() == null) {
                errors.add("Veuillez insérer au moins un article à vendre");
            } else {
                dto.getLigneVentes().forEach(ligne -> {
                    if(ligne.getArticle() == null) {
                        errors.add("Veuillez selectionner un article");
                    } else {
                        if(ligne.getArticle().getId() == null) {
                            errors.add("Veuillez selectionner un article valide");
                        }
                    }
                });
            }
        }

        return errors;
    }
}
