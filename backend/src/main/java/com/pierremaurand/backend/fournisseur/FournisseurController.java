package com.pierremaurand.backend.fournisseur;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FournisseurController implements FournisseurApi{
    
    private final FournisseurService service;
    
    @Override
    public FournisseurDto save(FournisseurDto dto) {
        return service.save(dto);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return service.findById(id);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }

}
