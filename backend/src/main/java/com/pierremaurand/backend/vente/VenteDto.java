package com.pierremaurand.backend.vente;

import java.time.LocalDate;
import java.util.List;

import com.pierremaurand.backend.ligneVente.LigneVenteDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VenteDto {

    private Integer id;

    private String code; 

    private LocalDate dateVente; 

    private String commentaire;

    private Integer entrepriseId;

    private List<LigneVenteDto> ligneVentes;

    public static VenteDto fromEntity(Vente obj) {
        if(obj == null) {
            return null;
        }

        return VenteDto.builder()
                .id(obj.getId())
                .code(obj.getCode())
                .commentaire(obj.getCommentaire())
                .dateVente(obj.getDateVente())
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }

    public static Vente toEntity(VenteDto obj) {
        if(obj == null) {
            return null;
        }

        return Vente.builder()
                .id(obj.getId())
                .code(obj.getCode())
                .commentaire(obj.getCommentaire())
                .dateVente(obj.getDateVente())
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }
}
