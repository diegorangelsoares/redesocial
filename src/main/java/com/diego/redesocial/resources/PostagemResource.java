package com.diego.redesocial.resources;

import com.diego.redesocial.models.Postagem;
import com.diego.redesocial.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**Classe de tratamentos de Postagens
 * @author Diego Rangel
 */
@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class PostagemResource {

    @Autowired
    private PostagemService postagemService;

    @GetMapping(path="Postagens")
    public ResponseEntity<?> listAll(Pageable pageable){
        return new ResponseEntity<>(postagemService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping( path="Postagens/{idPessoa}")
    public ResponseEntity<?> getUsersById(@PathVariable("idPessoa") long idPessoa){
        //verifyIfUsersExists(id);
        List<Postagem> postagem = postagemService.buscarPostagensPorIdPessoa(idPessoa);
        return new ResponseEntity<>(postagem,HttpStatus.OK);
    }

    @GetMapping(path="CountPostagens")
    public ResponseEntity<?> countPostagens (Pageable pageable){
        List<Postagem> postagem = postagemService.buscarTodos();
        return new ResponseEntity<>(postagem.size(),HttpStatus.OK);
    }

    @PostMapping(path="Postagens")
    public ResponseEntity<?> save(@Validated @RequestBody Postagem postagem){
        postagemService.salvar(postagem);
        return new ResponseEntity<>(postagem,HttpStatus.OK);
    }

    @DeleteMapping(path="Postagens")
    public ResponseEntity<?> delete (@Validated @RequestBody Postagem postagem){
        postagemService.excluir(postagem);
        return new ResponseEntity<>(postagem,HttpStatus.OK);
    }

}
