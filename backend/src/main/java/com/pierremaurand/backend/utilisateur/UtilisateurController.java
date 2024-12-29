package com.pierremaurand.backend.utilisateur;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("utilisateurs")
@Tag(name = "Utilisateur")
public class UtilisateurController implements UtilisateurApi {
    
    private final UtilisateurService service;
    
    @Override
    public ResponseEntity<UtilisateurDto> save(UtilisateurDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Override
    public ResponseEntity<UtilisateurDto> findById(Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<List<UtilisateurDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }



}
