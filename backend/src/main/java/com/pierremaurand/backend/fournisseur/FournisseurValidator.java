package com.pierremaurand.backend.fournisseur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null) {
            errors.add("Veuillez renseigner le nom du fournisseur");
            errors.add("Veuillez renseigner le prénom du fournisseur");
            errors.add("Veuillez renseigner l'email du fournisseur");
            errors.add("Veuillez renseigner le contact téléphonique du fournisseur");
            errors.add("Veuillez renseigner l'adresse du fournisseur");
        } else {
            if(!StringUtils.hasLength(dto.getNom())) {
                errors.add("Veuillez renseigner le nom du fournisseur");
            }

            if(!StringUtils.hasLength(dto.getPrenom())) {
                errors.add("Veuillez renseigner le prénom du fournisseur");
            }

            if(!StringUtils.hasLength(dto.getEmail())) {
                errors.add("Veuillez renseigner l'email du fournisseur");
            }

            if(!StringUtils.hasLength(dto.getTelephone())) {
                errors.add("Veuillez renseigner le contact téléphonique du fournisseur");
            }

            if(dto.getAdresse() == null) {
                errors.add("Veuillez renseigner l'adresse du fournisseur");
            } else {
                if(!StringUtils.hasLength(dto.getAdresse().getAdresse1())) {
                    errors.add("Le champs 'Adresse 1' est obligatoire");
                }

                if(!StringUtils.hasLength(dto.getAdresse().getCodePostal())) {
                    errors.add("Le champs 'Code Postal' est obligatoire");
                }

                if(!StringUtils.hasLength(dto.getAdresse().getVille())) {
                    errors.add("Le champs 'Ville' est obligatoire");
                }

                if(!StringUtils.hasLength(dto.getAdresse().getPays())) {
                    errors.add("Le champs 'pays' est obligatoire");
                }
            }
        }

        return errors;
    }
}
