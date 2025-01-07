package com.pierremaurand.backend.auth;

public interface AuthenticationService {

    AuthenticationResponse authentication(AuthenticationRequest request);

    void register(RegisterRequest request);
}
