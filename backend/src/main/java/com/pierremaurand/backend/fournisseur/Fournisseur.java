package com.pierremaurand.backend.fournisseur;

import java.util.List;

import com.pierremaurand.backend.commandeFournisseur.CommandeFournisseur;
import com.pierremaurand.backend.common.Adresse;
import com.pierremaurand.backend.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
public class Fournisseur extends BaseEntity{

    private String nom; 

    private String prenom;

    @Embedded
    private Adresse adresse;

    private String photo; 

    private String email;

    private String telephone;

    @Column(name = "entreprise_id")
    private Integer entrepriseId;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
}
