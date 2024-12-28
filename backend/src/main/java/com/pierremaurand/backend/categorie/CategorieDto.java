package com.pierremaurand.backend.categorie;

import java.util.List;

import com.pierremaurand.backend.article.ArticleDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategorieDto {

    private Integer id;

    private String code;

    private String designation;

    private List<ArticleDto> articles;

    private Integer entrepriseId;

    public static CategorieDto fromEntity(Categorie entity) {
        if(entity == null) {
            return null;
        }

        return CategorieDto.builder()
            .id(entity.getId())
            .code(entity.getCode())
            .designation(entity.getDesignation())
            .entrepriseId(entity.getEntrepriseId())
            .build();
    }

    public static Categorie toEntity(CategorieDto dto) {
        if(dto == null) {
            return null;
        }

        return Categorie.builder()
            .id(dto.getId())
            .code(dto.getCode())
            .designation(dto.getDesignation())
            .entrepriseId(dto.getEntrepriseId())
            .build();
    }
}
