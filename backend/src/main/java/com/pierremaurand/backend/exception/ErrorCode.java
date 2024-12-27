package com.pierremaurand.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ErrorCode {
    ARTICLE_NOT_FOUND(1000),
    CATEGORY_NOT_FOUND(2000)
    ;

    @Getter
    private int code;
}
