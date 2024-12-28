package com.pierremaurand.backend.fournisseur;

import java.util.List;

import com.pierremaurand.backend.commandeFournisseur.CommandeFournisseurDto;
import com.pierremaurand.backend.common.Adresse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FournisseurDto {

    private Integer id;

    private String nom; 

    private String prenom;

    private Adresse adresse;

    private String photo; 

    private String email;

    private String telephone;

    private Integer entrepriseId;

    private List<CommandeFournisseurDto> commandeFournisseurs;

    public static FournisseurDto fromEntity(Fournisseur obj) {
        if(obj == null) {
            return null;
        }

        return FournisseurDto.builder()
                .id(obj.getId())
                .nom(obj.getNom())
                .prenom(obj.getPrenom())
                .adresse(obj.getAdresse())
                .email(obj.getEmail())
                .telephone(obj.getTelephone())
                .photo(obj.getPhoto())
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto obj) {
        if(obj == null) {
            return null;
        }

        return Fournisseur.builder()
                .id(obj.getId())
                .nom(obj.getNom())
                .prenom(obj.getPrenom())
                .adresse(obj.getAdresse())
                .email(obj.getEmail())
                .telephone(obj.getTelephone())
                .photo(obj.getPhoto())
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }
}
