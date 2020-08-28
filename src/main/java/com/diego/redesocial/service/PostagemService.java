package com.diego.redesocial.service;

import com.diego.redesocial.models.PessoaUsuario;
import com.diego.redesocial.models.Postagem;
import com.diego.redesocial.repository.ComentarioRepository;
import com.diego.redesocial.repository.PessoaUsuarioRepository;
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

    @Autowired
    PessoaUsuarioRepository pessoaUsuarioRepository;

    public List<Postagem> buscarTodos(){
        return postagemRepository.findAll();
    }

    public void excluir (Postagem postagem) {
        //verificaSeTemHistorico(comentario.getId());
        postagemRepository.delete(postagem);
    }

    public List<Postagem> buscarPostagensPorIdPessoa(long id) {
        PessoaUsuario pessoa = pessoaUsuarioRepository.findById(id);
        List<Postagem> postagems = postagemRepository.findByPessoaUsuario(pessoa);
        return postagems;
    }

    public Postagem buscarPorId (long id){
        Postagem postagem = postagemRepository.findById(id);
        return postagem;
    }

    public Postagem salvar(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public Postagem alterar(Postagem postagem) {
        return postagemRepository.save(postagem);
    }


}
