package com.pierremaurand.backend.entreprise;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("entreprises")
@Tag(name = "Entreprise")
public class EntrepriseController implements EntrepriseApi{
    
    private final EntrepriseService service;
    
    @Override
    public ResponseEntity<EntrepriseDto> save(EntrepriseDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Override
    public ResponseEntity<EntrepriseDto> findById(Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<List<EntrepriseDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }

}
