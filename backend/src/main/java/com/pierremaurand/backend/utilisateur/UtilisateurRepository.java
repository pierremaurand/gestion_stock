package com.pierremaurand.backend.utilisateur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{

    Optional<Utilisateur> findByEmail(String email);

    boolean existsByEmail(String email);
}
