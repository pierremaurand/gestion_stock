package com.pierremaurand.backend.commandeFournisseur;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pierremaurand.backend.article.Article;
import com.pierremaurand.backend.article.ArticleRepository;
import com.pierremaurand.backend.exception.EntityNotFoundException;
import com.pierremaurand.backend.exception.ErrorCode;
import com.pierremaurand.backend.exception.InvalidEntityException;
import com.pierremaurand.backend.fournisseur.Fournisseur;
import com.pierremaurand.backend.fournisseur.FournisseurRepository;
import com.pierremaurand.backend.ligneCommandeFournisseur.LigneCommandeFournisseur;
import com.pierremaurand.backend.ligneCommandeFournisseur.LigneCommandeFournisseurDto;
import com.pierremaurand.backend.ligneCommandeFournisseur.LigneCommandeFournisseurRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommandeFournisseurServiceImp implements CommandeFournisseurService{
    
    private final CommandeFournisseurRepository commandeFournisseurRepository;
    private final FournisseurRepository fournisseurRepository;
    private final ArticleRepository articleRepository;
    private final LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
    
    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto);

        if(!errors.isEmpty()) {
            log.error("Commande fournisseur is not valid {}", dto);
            throw new InvalidEntityException("La commande fournisseur est invalid", ErrorCode.COMMANDE_FOURNISSEUR_NOT_VALID, errors);
        }

        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());

        if(!fournisseur.isPresent()) {
            log.error("Fournisseur ID {} not found", dto.getFournisseur().getId());
            throw new EntityNotFoundException("Le fournisseur avec l'ID = " + dto.getFournisseur().getId() + " n'a pas &té trouvé dans la BDD", ErrorCode.CLIENT_NOT_FOUND);
        } 

        List<String> articleErrors = new ArrayList<>();

        dto.getLigneCommandeFournisseurs().forEach(ligneCommandeFournisseurDto -> {
            Optional<Article> article = articleRepository.findById(ligneCommandeFournisseurDto.getArticle().getId());
            if(article.isEmpty()) {
                articleErrors.add("Aucun article avec l'ID = " + ligneCommandeFournisseurDto.getArticle().getId() + " n'a été trouvé dans la BDD");
            }
        });

        if(!articleErrors.isEmpty()) {
            throw new InvalidEntityException("Un ou plusieurs articles n'ont pas été trouvé dans la BDD", ErrorCode.COMMANDE_FOURNISSEUR_NOT_VALID, articleErrors);
        }

        CommandeFournisseur savedCommandeFournisseur = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));

        if(dto.getLigneCommandeFournisseurs() != null) {
            dto.getLigneCommandeFournisseurs().forEach(ligneCommandeFournisseurDto -> {
                LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligneCommandeFournisseurDto);
                ligneCommandeFournisseur.setCommandeFournisseur(savedCommandeFournisseur);
                ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
            });
        }

        return CommandeFournisseurDto.fromEntity(savedCommandeFournisseur);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if(id == null) {
            log.error("Commande fournisseur ID is NULL");
            return null;
        }

        return commandeFournisseurRepository.findById(id)
            .map(CommandeFournisseurDto::fromEntity)
            .orElseThrow(() -> 
                new EntityNotFoundException("Aucune commade fournisseur n'a été trouvé avec l'ID = " + id + " dans la BDD", ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND)
            );
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if(!StringUtils.hasLength(code)) {
            log.error("Commande fournisseur CODE is NULL");
            return null;
        }

        return commandeFournisseurRepository.findByCode(code)
            .map(CommandeFournisseurDto::fromEntity)
            .orElseThrow(() -> 
                new EntityNotFoundException("Aucune commade fournisseur n'a été trouvé avec le CODE = " + code + " dans la BDD", ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND)
            );
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null) {
            log.error("Commande fournisseur ID is NULL");
            return; 
        }

        commandeFournisseurRepository.deleteById(id);
    }

}
