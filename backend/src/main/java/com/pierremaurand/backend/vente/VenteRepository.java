package com.pierremaurand.backend.vente;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepository extends JpaRepository<Vente, Integer>{

    Optional<Vente> findByCode(String code);
}
