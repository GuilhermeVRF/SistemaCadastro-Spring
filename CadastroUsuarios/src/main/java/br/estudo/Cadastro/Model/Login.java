package br.estudo.Cadastro.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Login {

    @Email(message = "Esse e-mail não existe!")
    @NotBlank(message = "O e-mail é obrigatório!")
    private final String email;

    @NotBlank(message = "A senha é obrigatória!")
    private final String senha;

    public Login(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public String getEmail(){
        return this.email;
    }

    public String getSenha(){
        return this.senha;
    }
}
