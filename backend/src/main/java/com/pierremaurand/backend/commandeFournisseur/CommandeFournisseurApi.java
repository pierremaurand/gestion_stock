package com.pierremaurand.backend.commandeFournisseur;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommandeFournisseurApi {

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeFournisseurDto> save(@RequestBody CommandeFournisseurDto dto);

    @GetMapping(value = "/{id}/id", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeFournisseurDto> findById(@PathVariable Integer id);

    @GetMapping(value = "/{code}/code", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeFournisseurDto> findByCode(@PathVariable String code);

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CommandeFournisseurDto>> findAll();

    @DeleteMapping(value = "/{id}/delete")
    void delete(@PathVariable Integer id);

}
