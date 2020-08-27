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

    @Autowired
    PessoaUsuarioRepository pessoaUsuarioRepository;

    public List<Comentario> buscarTodos(){
        return comentarioRepository.findAll();
    }

    public int QuantidadeComentariosPorPessoa(long id){
        PessoaUsuario pesssoa = pessoaUsuarioRepository.findById(id);
        List<Comentario> comentarios = comentarioRepository.findByPessoaUsuario(pesssoa);
        if (comentarios != null){
            return comentarios.size();
        }else {
            return 0;
        }
    }

    public void excluir (Comentario comentario) {
        //verificaSeTemHistorico(comentario.getId());
        comentarioRepository.delete(comentario);
    }

    public List<Comentario> buscarComentariosPorIdPessoa(long id) {
        PessoaUsuario pesssoa = pessoaUsuarioRepository.findById(id);
        List<Comentario> comentarios = comentarioRepository.findByPessoaUsuario(pesssoa);
        return comentarios;
    }

    public Comentario salvar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

}
