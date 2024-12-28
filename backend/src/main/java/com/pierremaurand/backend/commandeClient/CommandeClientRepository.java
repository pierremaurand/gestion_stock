package com.pierremaurand.backend.commandeClient;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer>{

    Optional<CommandeClient> findByCode(String code);
}
