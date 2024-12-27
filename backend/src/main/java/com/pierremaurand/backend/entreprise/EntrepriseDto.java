package com.pierremaurand.backend.entreprise;

import java.util.List;

import com.pierremaurand.backend.common.Adresse;
import com.pierremaurand.backend.utilisateur.UtilisateurDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntrepriseDto {

    private Integer id;

    private String nom;

    private String description;

    private Adresse adresse;

    private String codeFiscale;

    private String email;

    private String photo;  

    private String siteWeb;

    private String telephone;

    private List<UtilisateurDto> utilisateurs;

    public static EntrepriseDto fromEntity(Entreprise obj) {
        if(obj == null) {
            return null;
        }

        return EntrepriseDto.builder() 
                .id(obj.getId())
                .nom(obj.getNom())
                .description(obj.getDescription())
                .adresse(obj.getAdresse())
                .codeFiscale(obj.getCodeFiscale())
                .email(obj.getEmail())
                .photo(obj.getPhoto())
                .siteWeb(obj.getSiteWeb())
                .telephone(obj.getTelephone())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto obj) {
        if(obj == null) {
            return null;
        }

        return Entreprise.builder() 
                .id(obj.getId())
                .nom(obj.getNom())
                .description(obj.getDescription())
                .adresse(obj.getAdresse())
                .codeFiscale(obj.getCodeFiscale())
                .email(obj.getEmail())
                .photo(obj.getPhoto())
                .siteWeb(obj.getSiteWeb())
                .telephone(obj.getTelephone())
                .build();
    }
}
