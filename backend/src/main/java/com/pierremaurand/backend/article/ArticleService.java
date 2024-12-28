package com.pierremaurand.backend.article;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByCode(String code);

    List<ArticleDto> findAll();

    void delete(Integer id);
}
