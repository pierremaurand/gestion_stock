package com.pierremaurand.backend.commandeClient;

import java.time.LocalDate;
import java.util.List;

import com.pierremaurand.backend.client.Client;
import com.pierremaurand.backend.common.BaseEntity;
import com.pierremaurand.backend.ligneCommandeClient.LigneCommandeClient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commande_client")
public class CommandeClient extends BaseEntity{

    @Column(unique = true)
    private String code; 

    @Column(name = "date_commande")
    private LocalDate dateCommande; 

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "commandeClient")
    @Column(name = "ligne_commande_clients")
    private List<LigneCommandeClient> ligneCommandeClients;
}
