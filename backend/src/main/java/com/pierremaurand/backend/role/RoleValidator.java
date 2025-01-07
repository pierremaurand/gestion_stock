package com.pierremaurand.backend.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class RoleValidator {

    public static List<String> validate(RoleDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null) {
            errors.add("Veuillez renseigner le nom du role");
            errors.add("Veuillez selectionner l'utilisateur du role");
        } else {
            if(!StringUtils.hasLength(dto.getNom())) {
                errors.add("Veuillez renseigner le nom du role");
            }

            if(dto.getUtilisateur() == null) {
                errors.add("Veuillez selectionner l'utilisateur du role");
            } else {
                if(dto.getUtilisateur().getId() == null) {
                    errors.add("Veuillez selectionner un utilisateur valide");
                }
            }
        }

        return errors;
    }
}
