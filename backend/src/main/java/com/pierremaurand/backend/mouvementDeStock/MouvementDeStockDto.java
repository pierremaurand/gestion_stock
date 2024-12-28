package com.pierremaurand.backend.mouvementDeStock;

import java.time.LocalDate;

import com.pierremaurand.backend.article.ArticleDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MouvementDeStockDto {

    private Integer id;

    private LocalDate dateMouvement;

    private double quantite;

    private TypeMouvement typeMouvement;

    private ArticleDto article;

    private Integer entrepriseId;

    public static MouvementDeStockDto fromEntity(MouvementDeStock obj) {
        if(obj == null) {
            return null;
        }

        return MouvementDeStockDto.builder()
                .id(obj.getId())
                .dateMouvement(obj.getDateMouvement())
                .quantite(obj.getQuantite())
                .typeMouvement(obj.getTypeMouvement())
                .article(ArticleDto.fromEntity(obj.getArticle()))
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }

    public static MouvementDeStock toEntity(MouvementDeStockDto obj) {
        if(obj == null) {
            return null;
        }

        return MouvementDeStock.builder()
                .id(obj.getId())
                .dateMouvement(obj.getDateMouvement())
                .quantite(obj.getQuantite())
                .typeMouvement(obj.getTypeMouvement())
                .article(ArticleDto.toEntity(obj.getArticle()))
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }
}
