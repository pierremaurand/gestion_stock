package com.pierremaurand.backend.categorie;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import static com.pierremaurand.backend.utils.Constantes.APP_ROOT;

public interface CategorieApi {

    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto save(@RequestBody CategorieDto dto);

    @GetMapping(value = APP_ROOT + "/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/categories/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategorieDto findByCode(String code);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategorieDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/categories/{id}")
    void delete(@PathVariable Integer id);
}
