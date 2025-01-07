package com.pierremaurand.backend.role;

import java.util.List;

public interface RoleService {

    RoleDto save(RoleDto dto);

    RoleDto findById(Integer id);

    RoleDto findByNom(String nom);

    List<RoleDto> findByUtilisateurId(Integer id);

    List<RoleDto> findAll();

    void delete(Integer id);
}
