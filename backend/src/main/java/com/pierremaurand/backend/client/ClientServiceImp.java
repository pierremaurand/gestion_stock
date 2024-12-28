package com.pierremaurand.backend.client;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pierremaurand.backend.exception.EntityNotFoundException;
import com.pierremaurand.backend.exception.ErrorCode;
import com.pierremaurand.backend.exception.InvalidEntityException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImp implements ClientService{

    private final ClientRepository repository;

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Client is not valid {}", dto);
            throw new InvalidEntityException("La client n'est pas valide", ErrorCode.CLIENT_NOT_VALID,errors);
        }

        return ClientDto.fromEntity(
            repository.save(
                ClientDto.toEntity(dto)
            )
        );
    }

    @Override
    public ClientDto findById(Integer id) {
        if(id == null) {
            log.error("Client Id is null");
            return null;
        }

        Optional<Client> client = repository.findById(id);

        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() -> 
            new EntityNotFoundException(
                "Aucun client avec l'ID = " + id + " n'a été trouvé dans la BDD",
                ErrorCode.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return repository.findAll().stream()
            .map(ClientDto::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null) {
            log.error("Client Id is null");
            return;
        }

        repository.deleteById(id);
    }

}
