package com.pierremaurand.backend.commandeFournisseur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class CommandeFournisseurValidator {

    public static List<String> validate(CommandeFournisseurDto dto) {
        List<String> errors = new ArrayList<>();

        
        if(dto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez selectionner un fournisseur");
        } else {
            if(!StringUtils.hasLength(dto.getCode())) {
                errors.add("Veuillez renseigner le code de la commande");
            }

            if(dto.getDateCommande() == null) {
                errors.add("Veuillez renseigner la date de la commande");
            }

            if(dto.getFournisseur() == null) {
                errors.add("Veuillez selectionner un fournisseur");
            }
        }

        return errors;
    }
}
