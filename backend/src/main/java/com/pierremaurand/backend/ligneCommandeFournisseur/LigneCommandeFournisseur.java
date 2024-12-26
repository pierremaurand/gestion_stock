package com.pierremaurand.backend.ligneCommandeFournisseur;

import com.pierremaurand.backend.article.Article;
import com.pierremaurand.backend.commandeFournisseur.CommandeFournisseur;
import com.pierremaurand.backend.common.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "ligne_commande_fournisseur")
public class LigneCommandeFournisseur extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private double quantite;

    @ManyToOne
    @JoinColumn(name = "commande_fournisseur_id")
    private CommandeFournisseur commandeFournisseur;
}
