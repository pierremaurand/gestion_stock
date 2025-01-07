package com.pierremaurand.backend.auth;

import java.util.HashMap;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.pierremaurand.backend.security.JwtService;
import com.pierremaurand.backend.utilisateur.Utilisateur;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImp implements AuthenticationService{

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    // private final EntrepriseService entrepriseService;

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );

        var claims = new HashMap<String, Object>();
        var utilisateur = ((Utilisateur) auth.getPrincipal());
        claims.put("nom", utilisateur.getName());

        var jwtToken = jwtService.generateToken(claims, (Utilisateur) auth.getPrincipal());
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    @Override
    public void register(RegisterRequest request) {
       return;
    }

}
