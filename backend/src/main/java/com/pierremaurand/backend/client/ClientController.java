package com.pierremaurand.backend.client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("clients")
@Tag(name = "Client")
public class ClientController implements ClientApi{
    
    private final ClientService service;

    @Override
    public ResponseEntity<ClientDto> save(ClientDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Override
    public ResponseEntity<ClientDto> findById(Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<List<ClientDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }

}
