package com.diego.redesocial.resources;

import com.diego.redesocial.models.Comentario;
import com.diego.redesocial.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**Classe de tratamentos de comentarios
 * @author Diego Rangel
 */
@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class ComentarioResource {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping(path="Comentarios")
    public ResponseEntity<?> listAll(Pageable pageable){
        return new ResponseEntity<>(comentarioService.buscarTodos(), HttpStatus.OK);
    }

    @GetMapping( path="Comentarios/{idPessoa}")
    public ResponseEntity<?> getUsersById(@PathVariable("idPessoa") long idPessoa){
        //verifyIfUsersExists(id);
        List<Comentario> postagem = comentarioService.buscarComentariosPorIdPessoa(idPessoa);
        return new ResponseEntity<>(postagem,HttpStatus.OK);
    }

    @GetMapping(path="CountComentarios")
    public ResponseEntity<?> countComentarios (Pageable pageable){
        List<Comentario> comentarios = comentarioService.buscarTodos();
        return new ResponseEntity<>(comentarios.size(),HttpStatus.OK);
    }

    @GetMapping(path="CountComentariosPorPessoa/{idPessoa}")
    public ResponseEntity<?> CountComentariosPorPessoa (@PathVariable("idPessoa") long idPessoa){
        int count = comentarioService.QuantidadeComentariosPorPessoa(idPessoa);
        return new ResponseEntity<>(count,HttpStatus.OK);
    }

    @PostMapping(path="Comentarios")
    public ResponseEntity<?> save(@Validated @RequestBody Comentario comentario){
        comentarioService.salvar(comentario);
        return new ResponseEntity<>(comentario,HttpStatus.OK);
    }

    @DeleteMapping(path="Comentarios")
    public ResponseEntity<?> delete (@Validated @RequestBody Comentario comentario){
        comentarioService.excluir(comentario);
        return new ResponseEntity<>(comentario,HttpStatus.OK);
    }
}
