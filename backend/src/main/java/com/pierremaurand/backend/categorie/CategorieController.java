package com.pierremaurand.backend.categorie;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("categories")
@Tag(name = "Categorie")
public class CategorieController implements CategorieApi{

    private final CategorieService service;

    @Override
    public ResponseEntity<CategorieDto> save(CategorieDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Override
    public ResponseEntity<CategorieDto> findById(Integer id) {
       return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<CategorieDto> findByCode(String code) {
        return ResponseEntity.ok(service.findByCode(code));
    }

    @Override
    public ResponseEntity<List<CategorieDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }

}
