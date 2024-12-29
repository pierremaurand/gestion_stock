package com.pierremaurand.backend.categorie;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CategorieApi {

    @PostMapping(value = "/save",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategorieDto> save(@RequestBody CategorieDto dto);

    @GetMapping(value = "/{id}/id", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategorieDto> findById(@PathVariable Integer id);

    @GetMapping(value = "/{code}/code", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CategorieDto> findByCode(@PathVariable String code);

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CategorieDto>> findAll();

    @DeleteMapping(value = "/{id}/delete")
    void delete(@PathVariable Integer id);
}
