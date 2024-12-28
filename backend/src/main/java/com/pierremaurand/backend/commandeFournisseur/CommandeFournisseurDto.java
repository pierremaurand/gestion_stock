package com.pierremaurand.backend.commandeFournisseur;

import java.time.LocalDate;
import java.util.List;

import com.pierremaurand.backend.fournisseur.FournisseurDto;
import com.pierremaurand.backend.ligneCommandeFournisseur.LigneCommandeFournisseurDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommandeFournisseurDto {

    private Integer id;

    private String code; 

    private LocalDate dateCommande; 

    private FournisseurDto fournisseur;

    private Integer entrepriseId;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur obj) {
        if(obj == null) {
            return null;
        }

        return CommandeFournisseurDto.builder()
                .id(obj.getId())
                .code(obj.getCode())
                .dateCommande(obj.getDateCommande())
                .fournisseur(FournisseurDto.fromEntity(obj.getFournisseur()))
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto obj) {
        if(obj == null) {
            return null;
        }

        return CommandeFournisseur.builder()
                .id(obj.getId())
                .code(obj.getCode())
                .dateCommande(obj.getDateCommande())
                .fournisseur(FournisseurDto.toEntity(obj.getFournisseur()))
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }
}
