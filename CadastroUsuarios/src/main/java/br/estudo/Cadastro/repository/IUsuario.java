package br.estudo.Cadastro.repository;

import br.estudo.Cadastro.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuario  extends JpaRepository<Usuario, Integer> {
    public Optional<Usuario> findByEmail(String email);
}
