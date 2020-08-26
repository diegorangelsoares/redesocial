package com.diego.redesocial.service;

import com.diego.redesocial.models.Postagem;
import com.diego.redesocial.repository.ComentarioRepository;
import com.diego.redesocial.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service de Postagem
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Service
public class PostagemService {

    @Autowired
    PostagemRepository postagemRepository;

    public List<Postagem> buscarTodos(){
        return postagemRepository.findAll();
    }

    public void excluir (Postagem postagem) {
        //verificaSeTemHistorico(comentario.getId());
        postagemRepository.delete(postagem);
    }

    public List<Postagem> buscarPostagensPorIdPessoa(long id) {
        List<Postagem> postagems = postagemRepository.findAll();
        List<Postagem> posts = null;
        for (int i = 0; i < postagems.size(); i++) {
            if (postagems.get(i).getPessoaUsuario().getId() == id) {
                posts.add(postagems.get(i));
            }
        }
        return posts;
    }

    public Postagem salvar(Postagem postagem) {
        return postagemRepository.save(postagem);
    }


}
