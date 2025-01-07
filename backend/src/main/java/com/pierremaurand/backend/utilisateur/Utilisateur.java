package com.pierremaurand.backend.utilisateur;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pierremaurand.backend.common.Adresse;
import com.pierremaurand.backend.common.BaseEntity;
import com.pierremaurand.backend.role.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utilisateur extends BaseEntity implements UserDetails, Principal{

    private String nom; 

    private String prenom; 

    @Column(unique = true)
    private String email;

    @Column(name = "date_de_naissance")
    private LocalDate dateDeNaissance; 

    @Column(name = "mot_de_passe")
    private String motDePasse; 

    @Embedded
    private Adresse adresse;

    private String photo;

    @OneToMany(mappedBy = "utilisateur")
    private List<Role> roles;

    @Override
    public String getName() {
        return nom + " " + prenom;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority(r.getNom()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return motDePasse;
    }

    @Override
    public String getUsername() {
        return email;
    }

}
