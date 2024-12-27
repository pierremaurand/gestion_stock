package com.pierremaurand.backend.mouvementDeStock;

import java.util.ArrayList;
import java.util.List;

public class MouvementDeStockValidator {

    public static List<String> validate(MouvementDeStockDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null) {
            errors.add("Veuillez selectionner un article");
            errors.add("Veuillez renseigner la date du mouvement");
            errors.add("Veuillez renseigner la quantité d'article mouvementé");
            errors.add("Veuillez selectionner le type de mouvement");
        } else {
            if(dto.getArticle() == null){
                errors.add("Veuillez selectionner un article");
            }

            if(dto.getDateMouvement() == null){
                errors.add("Veuillez renseigner la date du mouvement");
             }


            if(dto.getQuantite() == 0) {
                errors.add("Veuillez renseigner la quantité d'article mouvementé");
            }

            if(dto.getTypeMouvement() == null) {
                errors.add("Veuillez selectionner le type de mouvement");
            }
        }

        return errors;
    }
}
