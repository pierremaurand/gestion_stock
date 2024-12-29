package com.pierremaurand.backend.vente;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("ventes")
@Tag(name = "Vente")
public class VenteController implements VenteApi{

    private final VenteService venteService;

    @Override
    public ResponseEntity<VenteDto> save(VenteDto dto) {
       return ResponseEntity.ok(venteService.save(dto));
    }

    @Override
    public ResponseEntity<VenteDto> findById(Integer id) {
        return ResponseEntity.ok(venteService.findById(id));
    }

    @Override
    public ResponseEntity<VenteDto> findByCode(String code) {
       return ResponseEntity.ok(venteService.findByCode(code));
    }

    @Override
    public ResponseEntity<List<VenteDto>> findAll() {
        return ResponseEntity.ok(venteService.findAll());
    }

    @Override
    public void delete(Integer id) {
        venteService.delete(id);
    }

}
