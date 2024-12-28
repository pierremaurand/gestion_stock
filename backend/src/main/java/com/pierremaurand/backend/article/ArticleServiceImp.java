package com.pierremaurand.backend.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pierremaurand.backend.exception.EntityNotFoundException;
import com.pierremaurand.backend.exception.ErrorCode;
import com.pierremaurand.backend.exception.InvalidEntityException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleServiceImp implements ArticleService{

    private final ArticleRepository repository;

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if(!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("L'article n'a été pas valide", ErrorCode.ARTICLE_NOT_VALID,errors);
        }

        return ArticleDto.fromEntity(
            repository.save(
                ArticleDto.toEntity(dto)
            )
        );
    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id == null) {
            log.error("Article Id is null");
            return null;
        }

        Optional<Article> article = repository.findById(id);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() -> 
            new EntityNotFoundException(
                "Aucun article avec l'ID = " + id + " n'est trouvé dans la BDD",
                ErrorCode.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ArticleDto findByCode(String code) {
        if(!StringUtils.hasLength(code)) {
            log.error("Article code is empty");
            return null;
        }

        Optional<Article> article = repository.findByCode(code);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() -> 
            new EntityNotFoundException(
                "Aucun article avec le CODE = " + code + " n'est trouvé dans la BDD",
                ErrorCode.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return repository.findAll().stream()
            .map(ArticleDto::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null) {
            log.error("Article Id is null");
            return;
        }

        repository.deleteById(id);
    }

}
