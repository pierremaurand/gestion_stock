package com.pierremaurand.backend.entreprise;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface EntrepriseApi {

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntrepriseDto> save(@RequestBody EntrepriseDto dto);

    @GetMapping(value = "/{id}/id", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<EntrepriseDto> findById(@PathVariable Integer id);

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<EntrepriseDto>> findAll();

    @DeleteMapping(value = "/{id}/delete")
    void delete(@PathVariable Integer id);

}
