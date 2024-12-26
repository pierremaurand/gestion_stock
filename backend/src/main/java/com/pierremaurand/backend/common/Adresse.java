package com.pierremaurand.backend.common;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adresse {

    private String adresse1;

    private String adresse2; 

    private String ville; 

    @Column(name = "code_postal")
    private String codePostal; 

    private String pays; 

}
