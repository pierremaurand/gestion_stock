package com.pierremaurand.backend.ligneVente;

import com.pierremaurand.backend.article.ArticleDto;
import com.pierremaurand.backend.vente.VenteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LigneVenteDto {

    private Integer id;

    private ArticleDto article;

    private double quantite;

    private double prixUnitaire;

    private VenteDto vente;

    private Integer entrepriseId;

    public static LigneVenteDto fromEntity(LigneVente obj) {
        if(obj == null) {
            return null;
        }

        return LigneVenteDto.builder()
                .id(obj.getId())
                .article(ArticleDto.fromEntity(obj.getArticle()))
                .quantite(obj.getQuantite())
                .prixUnitaire(obj.getPrixUnitaire())
                .vente(VenteDto.fromEntity(obj.getVente()))
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto obj) {
        if(obj == null) {
            return null;
        }

        return LigneVente.builder()
                .id(obj.getId())
                .article(ArticleDto.toEntity(obj.getArticle()))
                .quantite(obj.getQuantite())
                .prixUnitaire(obj.getPrixUnitaire())
                .vente(VenteDto.toEntity(obj.getVente()))
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }
}
