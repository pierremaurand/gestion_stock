package com.pierremaurand.backend.utilisateur;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    UtilisateurDto findByEmail(String email);

    List<UtilisateurDto> findAll();

    void delete(Integer id);

}
