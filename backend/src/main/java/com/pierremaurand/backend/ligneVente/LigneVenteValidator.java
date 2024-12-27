package com.pierremaurand.backend.ligneVente;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {

    public static List<String> validate(LigneVenteDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null) {
            errors.add("Veuillez selectionner un article");
            errors.add("Veuillez renseigner la quantité d'article vendu");
            errors.add("Veuillez renseigner le prix unitaire d'article vendu");
            errors.add("Veuillez selectionner une vente");
        } else {
            if(dto.getArticle() == null){
                errors.add("Veuillez selectionner un article");
             }

            if(dto.getQuantite() == 0) {
                errors.add("Veuillez renseigner la quantité d'article vendu");
            }
                
            if(dto.getPrixUnitaire() == 0) {
                errors.add("Veuillez renseigner le prix unitaire d'article vendu");
            } 

            if(dto.getVente() == null) {
                errors.add("Veuillez selectionner une vente");
            }
        }

        return errors;
    }
}
