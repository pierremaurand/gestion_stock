package com.pierremaurand.backend.fournisseur;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface FournisseurApi {

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FournisseurDto> save(@RequestBody FournisseurDto dto);

    @GetMapping(value = "/{id}/id", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FournisseurDto> findById(@PathVariable Integer id);

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<FournisseurDto>> findAll();

    @DeleteMapping(value = "/{id}/delete")
    void delete(@PathVariable Integer id);

}
