package com.pierremaurand.backend.ligneCommandeClient;

import com.pierremaurand.backend.article.ArticleDto;
import com.pierremaurand.backend.commandeClient.CommandeClientDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LigneCommandeClientDto {

    private Integer id;

    private ArticleDto article;

    private double quantite;

    private double prixUnitaire;

    private Integer entrepriseId;

    private CommandeClientDto commandeClient;

    public static LigneCommandeClientDto fromEntity(LigneCommandeClient obj) {
        if(obj == null) {
            return null;
        }

        return LigneCommandeClientDto.builder()
                .id(obj.getId())
                .quantite(obj.getQuantite())
                .prixUnitaire(obj.getPrixUnitaire())
                .commandeClient(CommandeClientDto.fromEntity(obj.getCommandeClient()))
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto obj) {
        if(obj == null) {
            return null;
        }

        return LigneCommandeClient.builder()
                .id(obj.getId())
                .quantite(obj.getQuantite())
                .prixUnitaire(obj.getPrixUnitaire())
                .commandeClient(CommandeClientDto.toEntity(obj.getCommandeClient()))
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }

}
