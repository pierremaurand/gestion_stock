package com.pierremaurand.backend.utilisateur;

import java.time.LocalDate;
import java.util.List;

import com.pierremaurand.backend.common.Adresse;
import com.pierremaurand.backend.entreprise.Entreprise;
import com.pierremaurand.backend.role.RoleDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurDto {

    private Integer id;

    private String nom; 

    private String prenom; 

    private String email;

    private LocalDate dateDeNaissance; 

    private String motDePasse; 

    private Adresse adresse;

    private String photo;

    private Entreprise entreprise;

    private List<RoleDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur obj) {
        if(obj == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .id(obj.getId())
                .nom(obj.getNom())
                .prenom(obj.getPrenom())
                .email(obj.getEmail())
                .dateDeNaissance(obj.getDateDeNaissance())
                .motDePasse(obj.getMotDePasse())
                .adresse(obj.getAdresse())
                .photo(obj.getPhoto())
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto obj) {
        if(obj == null) {
            return null;
        }

        return Utilisateur.builder()
                .id(obj.getId())
                .nom(obj.getNom())
                .prenom(obj.getPrenom())
                .email(obj.getEmail())
                .dateDeNaissance(obj.getDateDeNaissance())
                .motDePasse(obj.getMotDePasse())
                .adresse(obj.getAdresse())
                .photo(obj.getPhoto())
                .build();
    }
}
