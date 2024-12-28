package com.pierremaurand.backend.entreprise;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EntrepriseController implements EntrepriseApi{
    
    private final EntrepriseService service;
    
    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return service.save(dto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return service.findById(id);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }

}
