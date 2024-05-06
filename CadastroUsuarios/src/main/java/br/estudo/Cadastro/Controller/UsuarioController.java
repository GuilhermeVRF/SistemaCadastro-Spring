package br.estudo.Cadastro.Controller;

import br.estudo.Cadastro.Model.Login;
import br.estudo.Cadastro.Model.Usuario;
import br.estudo.Cadastro.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return ResponseEntity.status(200).body(this.usuarioService.listasUsuarios());
    }

    @PostMapping
    public ResponseEntity<Usuario> inserirUsuario(@Valid @RequestBody Usuario novoUsuario){
        return ResponseEntity.status(201).body(this.usuarioService.inserirUsuario(novoUsuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizarUsuario(@Valid @RequestBody Usuario usuarioAtualizado){
        return ResponseEntity.status(201).body(this.usuarioService.atualizarUsuario(usuarioAtualizado));
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Integer idUsuario){
        this.usuarioService.deletarUsuario(idUsuario);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> validarLogin(@Valid @RequestBody Login usuarioLogando){
        if(!this.usuarioService.validarLogin(usuarioLogando)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }else{
            return ResponseEntity.status(201).body(true);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> validarCampos(MethodArgumentNotValidException ex){
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((erro) -> {
            String nomeErro = ((FieldError) erro).getField();
            String mensagemErro = erro.getDefaultMessage();

            erros.put(nomeErro, mensagemErro);
        });

        return erros;
    }
}
