package com.diego.redesocial.resources;

import com.diego.redesocial.models.PessoaUsuario;
import com.diego.redesocial.repository.PessoaUsuarioRepository;
import com.diego.redesocial.service.PessoaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**Classe de tratamentos do PessoaUsuario
 * @author Diego Rangel
 */
@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class PessoaUsuarioResource {

    @Autowired
    private PessoaUsuarioService pessoaUsuarioService;

    @GetMapping(path="PessoasUsuarios")
    public ResponseEntity<?> listAll(Pageable pageable){
        return new ResponseEntity<>(pessoaUsuarioService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping( path="PessoasUsuarios/{id}")
    public ResponseEntity<?> getUsersById(@PathVariable("id") long id){
        //verifyIfUsersExists(id);
        PessoaUsuario user = pessoaUsuarioService.buscarPorId(id);
        if (user != null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path="CountPessoasUsuarios")
    public ResponseEntity<?> countUsuarios (Pageable pageable){
        List<PessoaUsuario> Usuarios = pessoaUsuarioService.buscarTodos();
        return new ResponseEntity<>(Usuarios.size(),HttpStatus.OK);
    }

    @PostMapping(path="PessoasUsuarios")
    public ResponseEntity<?> save(@Validated @RequestBody PessoaUsuario user){
        PessoaUsuario pessoa = pessoaUsuarioService.salvar(user);
        if (pessoa != null){
            return new ResponseEntity<>(pessoa,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path="PessoasUsuarios")
    public ResponseEntity<?> alterarPessoa (@Validated @RequestBody PessoaUsuario user){
        PessoaUsuario pessoa = pessoaUsuarioService.alterar(user);
        if (pessoa != null){
            return new ResponseEntity<>(pessoa,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

//    @DeleteMapping(path="PessoasUsuarios")
//    public ResponseEntity<?> delete (@Validated @RequestBody PessoaUsuario user){
//        PessoaUsuario pessoaUsuario = pessoaUsuarioService.buscarPorId(user.getId());
//        pessoaUsuarioService.excluir(pessoaUsuario);
//        return new ResponseEntity<>(pessoaUsuario,HttpStatus.OK);
//    }

    @DeleteMapping(path="PessoasUsuarios")
    public ResponseEntity<?> deleteById (@Validated @RequestBody long idPessoa){
        PessoaUsuario pessoaUsuario = pessoaUsuarioService.buscarPorId(idPessoa);
        if (pessoaUsuario != null){
            pessoaUsuarioService.excluir(pessoaUsuario);
            return new ResponseEntity<>(pessoaUsuario,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }

}
