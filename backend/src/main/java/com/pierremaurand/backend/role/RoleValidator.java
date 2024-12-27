package com.pierremaurand.backend.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class RoleValidator {

    public static List<String> validate(RoleDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null || !StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le nom du role");
        }

        return errors;
    }
}
