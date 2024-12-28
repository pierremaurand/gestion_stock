package com.pierremaurand.backend.categorie;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategorieController implements CategorieApi{

    private final CategorieService service;

    @Override
    public CategorieDto save(CategorieDto dto) {
        return service.save(dto);
    }

    @Override
    public CategorieDto findById(Integer id) {
       return service.findById(id);
    }

    @Override
    public CategorieDto findByCode(String code) {
        return service.findByCode(code);
    }

    @Override
    public List<CategorieDto> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }

}
