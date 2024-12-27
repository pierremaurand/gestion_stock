package com.pierremaurand.backend.handlers;

import java.util.List;

import com.pierremaurand.backend.exception.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

    private Integer httpCode;
    private ErrorCode code; 
    private String message; 
    private List<String> errors;
}
