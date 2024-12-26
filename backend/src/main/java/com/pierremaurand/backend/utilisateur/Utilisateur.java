package com.pierremaurand.backend.utilisateur;

import java.time.LocalDate;
import java.util.List;

import com.pierremaurand.backend.common.Adresse;
import com.pierremaurand.backend.common.BaseEntity;
import com.pierremaurand.backend.entreprise.Entreprise;
import com.pierremaurand.backend.role.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Utilisateur extends BaseEntity{

    private String nom; 

    private String prenom; 

    @Column(unique = true)
    private String email;

    @Column(name = "date_de_naissance")
    private LocalDate dateDeNaissance; 

    @Column(name = "mot_de_passe")
    private String motDePasse; 

    @Embedded
    private Adresse adresse;

    private String photo;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;

    @OneToMany(mappedBy = "utilisateur")
    private List<Role> roles;

}
