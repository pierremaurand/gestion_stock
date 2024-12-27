package com.pierremaurand.backend.client;

import java.util.List;

import com.pierremaurand.backend.commandeClient.CommandeClientDto;
import com.pierremaurand.backend.common.Adresse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Integer id;

    private String nom; 

    private String prenom;

    private Adresse adresse;

    private String photo; 

    private String email;

    private String telephone;

    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client obj) {
        if(obj == null) {
            return null;
        }

        return ClientDto.builder()
            .id(obj.getId())
            .nom(obj.getNom())
            .prenom(obj.getPrenom())
            .adresse(obj.getAdresse())
            .photo(obj.getPhoto())
            .email(obj.getEmail())
            .telephone(obj.getTelephone())
            .build();
    }

    public static Client toEntity(ClientDto obj) {
        if(obj == null) {
            return null;
        }

        return Client.builder()
            .id(obj.getId())
            .nom(obj.getNom())
            .prenom(obj.getPrenom())
            .adresse(obj.getAdresse())
            .photo(obj.getPhoto())
            .email(obj.getEmail())
            .telephone(obj.getTelephone())
            .build();
    }
}
