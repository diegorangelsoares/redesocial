package com.diego.redesocial.service;

import com.diego.redesocial.models.Comentario;
import com.diego.redesocial.models.PessoaUsuario;
import com.diego.redesocial.repository.ComentarioRepository;
import com.diego.redesocial.repository.PessoaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service de Comentario
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Service
public class ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;

    public List<Comentario> buscarTodos(){
        return comentarioRepository.findAll();
    }

    public void excluir (Comentario comentario) {
        //verificaSeTemHistorico(comentario.getId());
        comentarioRepository.delete(comentario);
    }

    public List<Comentario> buscarComentariosPorIdPessoa(long id) {
        List<Comentario> comentarios = comentarioRepository.findAll();
        List<Comentario> comentario = null;
        for (int i = 0; i < comentarios.size(); i++) {
            if (comentarios.get(i).getPessoaUsuario().getId() == id) {
                comentario.add(comentarios.get(i));
            }
        }
        return comentario;
    }

    public Comentario salvar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

}
