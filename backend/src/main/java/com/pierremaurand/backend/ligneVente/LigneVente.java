package com.pierremaurand.backend.ligneVente;

import com.pierremaurand.backend.article.Article;
import com.pierremaurand.backend.common.BaseEntity;
import com.pierremaurand.backend.vente.Vente;

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
@Table(name = "ligne_vente")
public class LigneVente extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private double quantite;

    @ManyToOne
    @JoinColumn(name = "vente_id")
    private Vente vente;
}
