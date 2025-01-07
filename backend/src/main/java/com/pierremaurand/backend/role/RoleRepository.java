package com.pierremaurand.backend.role;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>{

    Optional<Role> findByNom(String nom);

    Optional<Role> findByNomAndUtilisateurId(String nom, Integer id);

    List<Role> findByUtilisateurId(Integer id);
}
