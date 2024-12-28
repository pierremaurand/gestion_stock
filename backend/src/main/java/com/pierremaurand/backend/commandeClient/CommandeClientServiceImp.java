package com.pierremaurand.backend.commandeClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pierremaurand.backend.article.Article;
import com.pierremaurand.backend.article.ArticleRepository;
import com.pierremaurand.backend.client.Client;
import com.pierremaurand.backend.client.ClientRepository;
import com.pierremaurand.backend.exception.EntityNotFoundException;
import com.pierremaurand.backend.exception.ErrorCode;
import com.pierremaurand.backend.exception.InvalidEntityException;
import com.pierremaurand.backend.ligneCommandeClient.LigneCommandeClient;
import com.pierremaurand.backend.ligneCommandeClient.LigneCommandeClientDto;
import com.pierremaurand.backend.ligneCommandeClient.LigneCommandeClientRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommandeClientServiceImp implements CommandeClientService{
    
    private final CommandeClientRepository commandeClientRepository;
    private final ClientRepository clientRepository;
    private final ArticleRepository articleRepository;
    private final LigneCommandeClientRepository ligneCommandeClientRepository;
    
    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);

        if(!errors.isEmpty()) {
            log.error("Commande client is not valide {}", dto);
            throw new InvalidEntityException("La commande client est invalid", ErrorCode.COMMANDE_CLIENT_NOT_VALID, errors);
        }

        Optional<Client> client = clientRepository.findById(dto.getClient().getId());

        if(!client.isPresent()) {
            log.error("Client ID {} not found", dto.getClient().getId());
            throw new EntityNotFoundException("Le client avec l'ID = " + dto.getClient().getId() + " n'a pas &té trouvé dans la BDD", ErrorCode.CLIENT_NOT_FOUND);
        } 

        List<String> articleErrors = new ArrayList<>();

        dto.getLigneCommandeClients().forEach(ligne -> {
            Optional<Article> article = articleRepository.findById(ligne.getArticle().getId());
            if(article.isEmpty()) {
                articleErrors.add("Aucun article avec l'ID = " + ligne.getArticle().getId() + " n'a été trouvé dans la BDD");
            }
        });

        if(!articleErrors.isEmpty()) {
            throw new InvalidEntityException("Un ou plusieurs articles n'ont pas été trouvé dans la BDD", ErrorCode.COMMANDE_CLIENT_NOT_VALID, articleErrors);
        }

        CommandeClient savedCommandeClient = commandeClientRepository.save(CommandeClientDto.toEntity(dto));

        if(dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligneCommandeClientDto -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligneCommandeClientDto);
                ligneCommandeClient.setCommandeClient(savedCommandeClient);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }

        return CommandeClientDto.fromEntity(savedCommandeClient);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if(id == null) {
            log.error("Commande client ID is NULL");
            return null;
        }

        return commandeClientRepository.findById(id)
            .map(CommandeClientDto::fromEntity)
            .orElseThrow(() -> 
                new EntityNotFoundException("Aucune commade client n'a été trouvé avec l'ID = " + id + " dans la BDD", ErrorCode.COMMANDE_CLIENT_NOT_FOUND)
            );
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if(!StringUtils.hasLength(code)) {
            log.error("Commande client CODE is NULL");
            return null;
        }

        return commandeClientRepository.findByCode(code)
            .map(CommandeClientDto::fromEntity)
            .orElseThrow(() -> 
                new EntityNotFoundException("Aucune commade client n'a été trouvé avec le CODE = " + code + " dans la BDD", ErrorCode.COMMANDE_CLIENT_NOT_FOUND)
            );
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null) {
            log.error("Commande client ID is NULL");
            return; 
        }

        commandeClientRepository.deleteById(id);
    }

}
