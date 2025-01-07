package com.pierremaurand.backend.mouvementDeStock;

import java.time.LocalDate;

import com.pierremaurand.backend.article.Article;
import com.pierremaurand.backend.common.BaseEntity;

import jakarta.persistence.Column;
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
@Table(name = "mouvement_de_stock")
public class MouvementDeStock extends BaseEntity{

    @Column(name = "date_mouvement")
    private LocalDate dateMouvement;

    private double quantite;

    @Column(name = "type_mouvement")
    private TypeMouvement typeMouvement;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
}
