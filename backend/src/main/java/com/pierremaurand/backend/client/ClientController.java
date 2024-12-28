package com.pierremaurand.backend.client;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi{
    
    private final ClientService service;

    @Override
    public ClientDto save(ClientDto dto) {
        return service.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return service.findById(id);
    }

    @Override
    public List<ClientDto> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }

}
