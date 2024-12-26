package com.pierremaurand.backend.mouvementDeStock;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TypeMouvement {
    ENTREE("entrée"),
    SORTIE("sortie");

    @Getter
    private final String typeMouvement;
}
