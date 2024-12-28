package com.pierremaurand.backend.article;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

    Optional<Article> findByCode(String code);
}
