package com.pierremaurand.backend.categorie;

import java.util.List;

import com.pierremaurand.backend.article.Article;
import com.pierremaurand.backend.common.BaseEntity;

import jakarta.persistence.Column;
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
public class Categorie extends BaseEntity{

    @Column(unique = true)
    private String code;

    private String designation;

    @Column(name = "entreprise_id")
    private Integer entrepriseId;

    @OneToMany(mappedBy = "categorie")
    private List<Article> articles;

}
