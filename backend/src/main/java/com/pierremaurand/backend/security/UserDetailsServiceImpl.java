package com.pierremaurand.backend.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.pierremaurand.backend.exception.EntityNotFoundException;
import com.pierremaurand.backend.exception.ErrorCode;
import com.pierremaurand.backend.utilisateur.UtilisateurRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UtilisateurRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws EntityNotFoundException {
        return repository.findByEmail(userEmail)
                .orElseThrow(() -> new EntityNotFoundException("Aucun utilisateur avec l'EMAIL = " + userEmail + " n'a été trouvé dans la BDD", ErrorCode.UTILISATEUR_NOT_FOUND));
    }

}
