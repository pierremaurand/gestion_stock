package com.pierremaurand.backend.commandeFournisseur;

import java.time.LocalDate;
import java.util.List;

import com.pierremaurand.backend.common.BaseEntity;
import com.pierremaurand.backend.fournisseur.Fournisseur;
import com.pierremaurand.backend.ligneCommandeFournisseur.LigneCommandeFournisseur;

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
@Table(name = "commande_fournisseur")
public class CommandeFournisseur extends BaseEntity{

    @Column(unique = true)
    private String code; 

    @Column(name = "date_commande")
    private LocalDate dateCommande; 

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    @Column(name = "entreprise_id")
    private Integer entrepriseId;

    @OneToMany(mappedBy = "commandeFournisseur")
    @Column(name = "ligne_commande_fournisseurs")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
}
