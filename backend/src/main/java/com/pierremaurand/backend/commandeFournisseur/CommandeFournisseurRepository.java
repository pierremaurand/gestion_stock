package com.pierremaurand.backend.commandeFournisseur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer>{

    Optional<CommandeFournisseur> findByCode(String code);
}
