package com.pierremaurand.backend.utilisateur;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UtilisateurController implements UtilisateurApi {
    
    private final UtilisateurService service;
    
    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return service.save(dto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return service.findById(id);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }



}
