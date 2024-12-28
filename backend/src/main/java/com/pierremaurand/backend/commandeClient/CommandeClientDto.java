package com.pierremaurand.backend.commandeClient;

import java.time.LocalDate;
import java.util.List;

import com.pierremaurand.backend.client.ClientDto;
import com.pierremaurand.backend.ligneCommandeClient.LigneCommandeClientDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommandeClientDto {

    private Integer id;

    private String code; 

    private LocalDate dateCommande; 

    private ClientDto client;

    private Integer entrepriseId;

    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient obj) {
        if(obj == null) {
            return null;
        }

        return CommandeClientDto.builder()
                .id(obj.getId())
                .code(obj.getCode())
                .dateCommande(obj.getDateCommande())
                .client(ClientDto.fromEntity(obj.getClient()))
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto obj) {
        if(obj == null) {
            return null;
        }

        return CommandeClient.builder()
                .id(obj.getId())
                .code(obj.getCode())
                .dateCommande(obj.getDateCommande())
                .client(ClientDto.toEntity(obj.getClient()))
                .entrepriseId(obj.getEntrepriseId())
                .build();
    }

}
