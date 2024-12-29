package com.pierremaurand.backend.article;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("articles")
@Tag(name = "Article")
public class ArticleController implements ArticleApi{

    private final ArticleService service;

    @Override
    public ResponseEntity<ArticleDto> save(ArticleDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Override
    public ResponseEntity<ArticleDto> findById(Integer id) {
       return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<ArticleDto> findByCode(String code) {
        return ResponseEntity.ok(service.findByCode(code));
    }

    @Override
    public ResponseEntity<List<ArticleDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }

}
