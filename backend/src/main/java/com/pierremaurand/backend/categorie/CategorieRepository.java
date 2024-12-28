package com.pierremaurand.backend.categorie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Integer>{
    
    Optional<Categorie> findByCode(String code);
}
