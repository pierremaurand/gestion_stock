package com.pierremaurand.backend.article;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import static com.pierremaurand.backend.utils.Constantes.APP_ROOT;

public interface ArticleApi {

    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = APP_ROOT + "/articles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable Integer id);

    @GetMapping(value = APP_ROOT + "/articles/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCode(String code);

    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/articles/{id}")
    void delete(@PathVariable Integer id);
}
