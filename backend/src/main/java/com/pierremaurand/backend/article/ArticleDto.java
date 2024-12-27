package com.pierremaurand.backend.article;

import com.pierremaurand.backend.categorie.CategorieDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    private Integer id;

    private String code;

    private String designation;

    private double prixUnitaireHt;

    private double tauxTva; 

    private double prixUnitaireTtc;

    private String photo;

    private CategorieDto categorie;

    public static ArticleDto fromEntity(Article entity) {
        if(entity == null) {
            return null;
        }

        return ArticleDto.builder()
            .id(entity.getId())
            .code(entity.getCode())
            .photo(entity.getPhoto())
            .designation(entity.getDesignation())
            .prixUnitaireHt(entity.getPrixUnitaireHt())
            .tauxTva(entity.getTauxTva())
            .prixUnitaireTtc(entity.getPrixUnitaireTtc())
            .categorie(CategorieDto.fromEntity(entity.getCategorie()))
            .build();
    }

    public static Article toEntity(ArticleDto dto) {
        if(dto == null) {
            return null;
        }

        return Article.builder()
            .id(dto.getId())
            .code(dto.getCode())
            .photo(dto.getPhoto())
            .designation(dto.getDesignation())
            .prixUnitaireHt(dto.getPrixUnitaireHt())
            .tauxTva(dto.getTauxTva())
            .prixUnitaireTtc(dto.getPrixUnitaireTtc())
            .categorie(CategorieDto.toEntity(dto.getCategorie()))
            .build();
    }
}
