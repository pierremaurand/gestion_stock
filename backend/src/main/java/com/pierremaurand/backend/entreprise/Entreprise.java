package com.pierremaurand.backend.entreprise;

import java.util.List;

import com.pierremaurand.backend.common.Adresse;
import com.pierremaurand.backend.common.BaseEntity;
import com.pierremaurand.backend.utilisateur.Utilisateur;

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
public class Entreprise extends BaseEntity{

    private String nom;

    private String description;

    @Embedded
    private Adresse adresse;

    @Column(name = "code_fiscale")
    private String codeFiscale;

    private String email;

    private String photo; 

    @Column(name = "site_web")
    private String siteWeb;

    private String telephone;

    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;
}
