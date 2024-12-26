package com.pierremaurand.backend.article;

import java.beans.Transient;

import com.pierremaurand.backend.categorie.Categorie;
import com.pierremaurand.backend.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Article extends BaseEntity{
    @Column(unique = true)
    private String code;

    private String designation;

    @Column(name = "prix_unitaire")
    private double prixUnitaire;

    @Column(name = "taux_txa")
    private double tauxTva; 

    private String photo;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @Transient
    public double getPrixTtc() {
        return Math.round(prixUnitaire * (1 + tauxTva/100.00));
    }

    
}
