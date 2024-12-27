package com.pierremaurand.backend.role;

import com.pierremaurand.backend.utilisateur.UtilisateurDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {

    private Integer id;

    private String nom; 

    private UtilisateurDto utilisateur;

    public static RoleDto fromEntity(Role obj) {
        if(obj == null) {
            return null;
        }

        return RoleDto.builder()
                .id(obj.getId())
                .nom(obj.getNom())
                .build();
    }

    public static Role toEntity(RoleDto obj) {
        if(obj == null) {
            return null;
        }

        return Role.builder()
                .id(obj.getId())
                .nom(obj.getNom())
                .build();
    }
}
