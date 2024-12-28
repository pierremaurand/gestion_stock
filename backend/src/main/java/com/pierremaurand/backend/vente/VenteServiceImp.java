package com.pierremaurand.backend.vente;

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
import com.pierremaurand.backend.ligneVente.LigneVente;
import com.pierremaurand.backend.ligneVente.LigneVenteDto;
import com.pierremaurand.backend.ligneVente.LigneVenteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class VenteServiceImp implements VenteService{

     private final VenteRepository venteRepository;
    private final ArticleRepository articleRepository;
    private final LigneVenteRepository ligneVenteRepository;
    
    @Override
    public VenteDto save(VenteDto dto) {
        List<String> errors = VenteValidator.validate(dto);

        if(!errors.isEmpty()) {
            log.error("Vente is not valid {}", dto);
            throw new InvalidEntityException("La vente est invalid", ErrorCode.VENTE_NOT_VALID, errors);
        } 

        List<String> articleErrors = new ArrayList<>();

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            if(article.isEmpty()) {
                articleErrors.add("Aucun article avec l'ID = " + ligneVenteDto.getArticle().getId() + " n'a été trouvé dans la BDD");
            }
        });

        if(!articleErrors.isEmpty()) {
            throw new InvalidEntityException("Un ou plusieurs articles n'ont pas été trouvé dans la BDD", ErrorCode.VENTE_NOT_VALID, articleErrors);
        }

        Vente savedVente = venteRepository.save(VenteDto.toEntity(dto));

        if(dto.getLigneVentes() != null) {
            dto.getLigneVentes().forEach(ligneVenteDto -> {
                LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
                ligneVente.setVente(savedVente);
                ligneVenteRepository.save(ligneVente);
            });
        }

        return VenteDto.fromEntity(savedVente);
    }

    @Override
    public VenteDto findById(Integer id) {
        if(id == null) {
            log.error("Vente ID is NULL");
            return null;
        }

        return venteRepository.findById(id)
            .map(VenteDto::fromEntity)
            .orElseThrow(() -> 
                new EntityNotFoundException("Aucune vente n'a été trouvé avec l'ID = " + id + " dans la BDD", ErrorCode.VENTE_NOT_FOUND)
            );
    }

    @Override
    public VenteDto findByCode(String code) {
        if(!StringUtils.hasLength(code)) {
            log.error("Vente CODE is NULL");
            return null;
        }

        return venteRepository.findByCode(code)
            .map(VenteDto::fromEntity)
            .orElseThrow(() -> 
                new EntityNotFoundException("Aucune vente n'a été trouvé avec le CODE = " + code + " dans la BDD", ErrorCode.VENTE_NOT_FOUND)
            );
    }

    @Override
    public List<VenteDto> findAll() {
        return venteRepository.findAll().stream()
                .map(VenteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null) {
            log.error("Vente ID is NULL");
            return; 
        }

        venteRepository.deleteById(id);
    }

}
