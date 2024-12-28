package com.pierremaurand.backend.article;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ArticleController implements ArticleApi{

    private final ArticleService service;

    @Override
    public ArticleDto save(ArticleDto dto) {
        return service.save(dto);
    }

    @Override
    public ArticleDto findById(Integer id) {
       return service.findById(id);
    }

    @Override
    public ArticleDto findByCode(String code) {
        return service.findByCode(code);
    }

    @Override
    public List<ArticleDto> findAll() {
        return service.findAll();
    }

    @Override
    public void delete(Integer id) {
        service.delete(id);
    }

}
