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

/**Classe de tratamentos do usuario
 * @author Diego Rangel
 */
@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class PessoaUsuarioResource {

//    @Autowired
//    private PessoaUsuarioRepository pessoaUsuarioRepository;

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
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping(path="CountPessoasUsuarios")
    public ResponseEntity<?> countUsuarios (Pageable pageable){
        long quant = 0;
        List<PessoaUsuario> Usuarios = pessoaUsuarioService.buscarTodos();
        return new ResponseEntity<>(Usuarios.size(),HttpStatus.OK);
    }

    @PostMapping(path="PessoasUsuarios")
    public ResponseEntity<?> save(@Validated @RequestBody PessoaUsuario user){
        pessoaUsuarioService.salvar(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping(path="PessoasUsuarios")
    public ResponseEntity<?> delete (@Validated @RequestBody PessoaUsuario user){
        PessoaUsuario pessoaUsuario = pessoaUsuarioService.buscarPorId(user.getId());
        pessoaUsuarioService.excluir(pessoaUsuario);
        return new ResponseEntity<>(pessoaUsuario,HttpStatus.OK);
    }

}
