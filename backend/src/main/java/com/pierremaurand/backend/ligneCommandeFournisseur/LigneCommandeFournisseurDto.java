package com.pierremaurand.backend.ligneCommandeFournisseur;

import com.pierremaurand.backend.article.Article;
import com.pierremaurand.backend.commandeFournisseur.CommandeFournisseurDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommandeFournisseurDto {

    private Integer id;

    private Article article;

    private double quantite;

    private double prixUnitaire;

    private Integer entrepriseId;

    private CommandeFournisseurDto commandeFournisseur;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur obj) {
        if(obj == null) {
            return null;
        }

        return LigneCommandeFournisseurDto.builder()
                .id(obj.getId())
                .quantite(obj.getQuantite())
                .prixUnitaire(obj.getPrixUnitaire())
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto obj) {
        if(obj == null) {
            return null;
        }

        return LigneCommandeFournisseur.builder()
                .id(obj.getId())
                .quantite(obj.getQuantite())
                .prixUnitaire(obj.getPrixUnitaire())
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }
}
