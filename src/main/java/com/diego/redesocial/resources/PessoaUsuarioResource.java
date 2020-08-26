package com.diego.redesocial.resources;

import com.diego.redesocial.models.PessoaUsuario;
import com.diego.redesocial.repository.PessoaUsuarioRepository;
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

    @Autowired
    private PessoaUsuarioRepository pessoaUsuarioRepository;

    @GetMapping(path="PessoasUsuarios")
    public ResponseEntity<?> listAll(Pageable pageable){
        return new ResponseEntity<>(pessoaUsuarioRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping( path="PessoasUsuarios/{id}")
    public ResponseEntity<?> getUsersById(@PathVariable("id") long id){
        //verifyIfUsersExists(id);
        PessoaUsuario user = pessoaUsuarioRepository.findById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping(path="CountPessoasUsuarios")
    public ResponseEntity<?> countUsuarios (Pageable pageable){
        long quant = 0;
        List<PessoaUsuario> Usuarios = pessoaUsuarioRepository.findAll();
        for (int i = 0; i < Usuarios.size(); i++) {
            quant++;
        }
        return new ResponseEntity<>(quant,HttpStatus.OK);
    }

    @PostMapping(path="PessoasUsuarios")
    public ResponseEntity<?> save(@Validated @RequestBody PessoaUsuario user){
        pessoaUsuarioRepository.save(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
