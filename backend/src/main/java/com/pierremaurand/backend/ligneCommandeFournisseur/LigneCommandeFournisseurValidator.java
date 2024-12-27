package com.pierremaurand.backend.ligneCommandeFournisseur;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {

    public static List<String> validate(LigneCommandeFournisseurDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null) {
            errors.add("Veuillez selectionner un article");
            errors.add("Veuillez renseigner la quantité d'article commandé");
            errors.add("Veuillez renseigner le prix unitaire d'article commandé");
            errors.add("Veuillez selectionner une commande fournisseur");
        } else {
            if(dto.getArticle() == null){
                errors.add("Veuillez selectionner un article");
             }

            if(dto.getQuantite() == 0) {
                errors.add("Veuillez renseigner la quantité d'article commandé");
            }
                
            if(dto.getPrixUnitaire() == 0) {
                errors.add("Veuillez renseigner le prix unitaire d'article commandé");
            } 

            if(dto.getCommandeFournisseur() == null) {
                errors.add("Veuillez selectionner une commande fournisseur");
            }
        }

        return errors;
    }
}
