package br.estudo.Cadastro.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

@Entity
@Table(name = "usuario", schema="Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer idUsuario;

    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3,message = "O nome deve ter pelo menos 3 caracteres!")
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @NotBlank(message = "O e-mail é obrigatório!")
    @Email(message = "Insiar um e-mail válido!")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @NotBlank(message = "O telefone é obrigatório!")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @NotBlank(message = "O endereço é obrigatório!")
    @Column(name = "endereco", length = 40, nullable = false)
    private String endereco;

    @NotBlank(message = "A senha é obrigatória!")
    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

}
