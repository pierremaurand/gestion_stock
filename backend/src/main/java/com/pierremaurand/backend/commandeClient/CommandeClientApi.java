package com.pierremaurand.backend.commandeClient;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommandeClientApi {

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);

    @GetMapping(value = "/{id}/id", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDto> findById(@PathVariable Integer id);

    @GetMapping(value = "/{code}/code", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable String code);

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CommandeClientDto>> findAll();

    @DeleteMapping(value = "/{id}/delete")
    void delete(@PathVariable Integer id);
}
