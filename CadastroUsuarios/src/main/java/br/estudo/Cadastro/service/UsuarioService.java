package br.estudo.Cadastro.service;

import br.estudo.Cadastro.Model.Login;
import br.estudo.Cadastro.Model.Usuario;
import br.estudo.Cadastro.repository.IUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private IUsuario repository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuario repository){
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listasUsuarios(){
        return this.repository.findAll();
    }

    public Usuario inserirUsuario(Usuario novoUsuario){
        this.criptografarSenha(novoUsuario);
        return this.repository.save(novoUsuario);
    }

    public Usuario atualizarUsuario(Usuario usuarioAtualizado){
        this.criptografarSenha(usuarioAtualizado);
        return this.repository.save(usuarioAtualizado);
    }

    public void deletarUsuario(Integer idUsuario){
        this.repository.deleteById(idUsuario);
    }

    public boolean validarLogin(Login usuarioLogando){
        Optional<Usuario> usuario = this.repository.findByEmail(usuarioLogando.getEmail());
        if(usuario.isPresent()){
            return this.passwordEncoder.matches(usuarioLogando.getSenha(), usuario.get().getSenha());
        }

        return false;
    }

    private void criptografarSenha(Usuario usuario){
        String senhaCriptografada = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
    }
}
