package com.pierremaurand.backend.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class ClientValidator {

    
    public static List<String> validate(ClientDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null) {
            errors.add("Veuillez renseigner le nom du client");
            errors.add("Veuillez renseigner le prénom du client");
            errors.add("Veuillez renseigner l'email du client");
            errors.add("Veuillez renseigner le contact téléphonique du client");
            errors.add("Veuillez renseigner l'adresse du client");
        } else {
            if(!StringUtils.hasLength(dto.getNom())) {
                errors.add("Veuillez renseigner le nom du client");
            }

            if(!StringUtils.hasLength(dto.getPrenom())) {
                errors.add("Veuillez renseigner le prénom du client");
            }

            if(!StringUtils.hasLength(dto.getEmail())) {
                errors.add("Veuillez renseigner l'email du client");
            }

            if(!StringUtils.hasLength(dto.getTelephone())) {
                errors.add("Veuillez renseigner le contact téléphonique du client");
            }

            if(dto.getAdresse() == null) {
                errors.add("Veuillez renseigner l'adresse du client");
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
