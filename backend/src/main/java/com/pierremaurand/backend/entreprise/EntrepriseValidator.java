package com.pierremaurand.backend.entreprise;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null) {
            errors.add("Veuillez renseigner le nom de l'entreprise");
            errors.add("Veuillez renseigner le code fiscale de l'entreprise");
            errors.add("Veuillez renseigner l'email de l'entreprise");
            errors.add("Veuillez renseigner le contact téléphonique de l'entreprise");
            errors.add("Veuillez renseigner l'adresse de l'utiisateur");
        } else {
            if(!StringUtils.hasLength(dto.getNom())) {
                errors.add("Veuillez renseigner le nom de l'entreprise");
            }

            if(!StringUtils.hasLength(dto.getCodeFiscale())) {
                errors.add("Veuillez renseigner le code fiscale de l'entreprise");
            }

            if(!StringUtils.hasLength(dto.getEmail())) {
                errors.add("Veuillez renseigner l'email de l'entreprise");
            }

            if(!StringUtils.hasLength(dto.getTelephone())) {
                errors.add("Veuillez renseigner le contact téléphonique de l'entreprise");
            }

            if(dto.getAdresse() == null) {
                errors.add("Veuillez renseigner l'adresse de l'entreprise");
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
