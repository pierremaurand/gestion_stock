package com.pierremaurand.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import com.pierremaurand.backend.common.Adresse;
import com.pierremaurand.backend.role.RoleDto;
import com.pierremaurand.backend.utilisateur.UtilisateurDto;
import com.pierremaurand.backend.utilisateur.UtilisateurService;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(UtilisateurService utilisateurService) {
		return args -> {
			UtilisateurDto utilisateur = UtilisateurDto.builder()
				.id(1)
				.nom("OVASSA")
				.prenom("Pierre Maurand")
				.adresse(Adresse.builder()
					.adresse1("Ndjamena Abena")
					.codePostal("1002")
					.ville("Ndjamena")
					.pays("Tchad")
					.build())
				.email("pierremaurand@gmail.com")
				.motDePasse("patricia")
				.dateDeNaissance(LocalDate.of(1982,10,4))
				.build();

				List<RoleDto> roles = new ArrayList<RoleDto>();
				roles.add(RoleDto.builder()
					.nom("ADMIN")
					.build());

				roles.add(RoleDto.builder()
				.nom("USER")
				.build());

				utilisateur.setRoles(roles);

				if(utilisateurService.findAll().isEmpty()) {
					utilisateur.setId(null);
				}

				utilisateurService.save(utilisateur);
		};
	}

}
