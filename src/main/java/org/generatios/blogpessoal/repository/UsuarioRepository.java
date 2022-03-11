package org.generatios.blogpessoal.repository;

import java.util.Optional;

import org.generatios.blogpessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByUsuario(String Usuario);

}
