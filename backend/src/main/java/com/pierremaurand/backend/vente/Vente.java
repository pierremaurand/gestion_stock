package com.pierremaurand.backend.vente;

import java.time.LocalDate;
import java.util.List;

import com.pierremaurand.backend.common.BaseEntity;
import com.pierremaurand.backend.ligneVente.LigneVente;

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
public class Vente extends BaseEntity{

    @Column(unique = true)
    private String code; 

    @Column(name = "date_vente")
    private LocalDate dateVente; 

    @Column(name = "entreprise_id")
    private Integer entrepriseId;

    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVentes;
}
