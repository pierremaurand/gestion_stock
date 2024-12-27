package com.pierremaurand.backend.utilisateur;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null) {
            errors.add("Veuillez renseigner le nom de l'utiisateur");
            errors.add("Veuillez renseigner le prénom de l'utiisateur");
            errors.add("Veuillez renseigner la date de naissance de l'utiisateur");
            errors.add("Veuillez renseigner l'email de l'utiisateur");
            errors.add("Veuillez renseigner le mot de passe de l'utiisateur");
            errors.add("Veuillez renseigner l'adresse de l'utiisateur");
        } else {
            if(!StringUtils.hasLength(dto.getNom())) {
                errors.add("Veuillez renseigner le nom de l'utiisateur");
            }

            if(!StringUtils.hasLength(dto.getPrenom())) {
                errors.add("Veuillez renseigner le prénom de l'utiisateur");
            }

            if(dto.getDateDeNaissance() == null) {
                errors.add("Veuillez renseigner la date de naissance de l'utiisateur");
            }

            if(!StringUtils.hasLength(dto.getEmail())) {
                errors.add("Veuillez renseigner l'email de l'utiisateur");
            }

            if(!StringUtils.hasLength(dto.getMotDePasse())) {
                errors.add("Veuillez renseigner le mot de passe de l'utiisateur");
            }

            if(dto.getAdresse() == null) {
                errors.add("Veuillez renseigner l'adresse de l'utiisateur");
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
