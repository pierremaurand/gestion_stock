package com.pierremaurand.backend.fournisseur;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("fournisseurs")
@Tag(name = "Fournisseur")
public class FournisseurController implements FournisseurApi{
    
    private final FournisseurService service;
    
    @Override
    public ResponseEntity<FournisseurDto> save(FournisseurDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Override
    public ResponseEntity<FournisseurDto> findById(Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<List<FournisseurDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }

}
