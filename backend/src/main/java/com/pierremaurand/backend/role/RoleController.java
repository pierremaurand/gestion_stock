package com.pierremaurand.backend.role;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("roles")
@Tag(name = "Role")
public class RoleController implements RoleApi{

    private final RoleService roleService;

	@Override
	public ResponseEntity<RoleDto> save(RoleDto dto) {
		return ResponseEntity.ok(roleService.save(dto));
	}

	@Override
	public ResponseEntity<RoleDto> findById(Integer id) {
		 return ResponseEntity.ok(roleService.findById(id));
	}

	@Override
	public ResponseEntity<List<RoleDto>> findAll() {
		return ResponseEntity.ok(roleService.findAll());
	}

	@Override
	public void delete(Integer id) {
		roleService.delete(id);
	}

	@Override
	public ResponseEntity<List<RoleDto>> findByUtilisateur(Integer id) {
		return ResponseEntity.ok(roleService.findByUtilisateurId(id));
	}

}
