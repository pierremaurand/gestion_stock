package com.pierremaurand.backend.commandeClient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class CommandeClientValidator {

    public static List<String> validate(CommandeClientDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null) {
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("Veuillez renseigner la date de la commande");
            errors.add("Veuillez selectionner un client");
            errors.add("Veuillez insérer au moins un article à commander");
        } else {
            if(!StringUtils.hasLength(dto.getCode())) {
                errors.add("Veuillez renseigner le code de la commande");
            }

            if(dto.getDateCommande() == null) {
                errors.add("Veuillez renseigner la date de la commande");
            }

            if(dto.getClient() == null) {
                errors.add("Veuillez selectionner un client");
            } else {
                if(dto.getClient().getId() == null) {
                    errors.add("Veuillez selectionner un client valid");
                }
            }

            if(dto.getLigneCommandeClients() == null) {
                errors.add("Veuillez insérer au moins un article à commander");
            } else {
                dto.getLigneCommandeClients().forEach(ligne -> {
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
