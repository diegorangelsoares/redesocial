package com.diego.redesocial.service;

import com.diego.redesocial.erro.ResourceNotFoundException;
import com.diego.redesocial.models.Comentario;
import com.diego.redesocial.models.PessoaUsuario;
import com.diego.redesocial.models.Postagem;
import com.diego.redesocial.repository.ComentarioRepository;
import com.diego.redesocial.repository.PessoaUsuarioRepository;
import com.diego.redesocial.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
/**
 * Service de PessoaUsuario
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Service
public class PessoaUsuarioService {

    @Autowired
    PessoaUsuarioRepository pessoaUsuarioRepository;

    @Autowired
    ComentarioService comentarioService;

    @Autowired
    PostagemService postagemService;

    public List< PessoaUsuario> buscarTodos(){
        return pessoaUsuarioRepository.findAll();
    }

    public void excluir (PessoaUsuario pessoaUsuario) {
        if (verificaSeTemHistorico(pessoaUsuario.getId()) != false){
            pessoaUsuarioRepository.delete(pessoaUsuario);
        } else{
            throw new ResourceNotFoundException("Pessoa possui histórico e não pode ser excluido.");
        }
    }

    public PessoaUsuario buscarPorId(long id) {
        List<PessoaUsuario> pessoas = pessoaUsuarioRepository.findAll();
        PessoaUsuario cli = null;
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == id) {
                cli = pessoas.get(i);
            }
        }
        return cli;
    }

    public PessoaUsuario alterar(PessoaUsuario cliente) {
        PessoaUsuario pessoa = pessoaUsuarioRepository.findById(cliente.getId());
        if (pessoa != null){
            return pessoaUsuarioRepository.save(cliente);
        }else{
            return null;
        }

    }

    public PessoaUsuario salvar(PessoaUsuario cliente) {
        PessoaUsuario pessoa = pessoaUsuarioRepository.findByNome(cliente.getNome());
        //Cliente novo?
        if (pessoa ==null){
            return pessoaUsuarioRepository.save(cliente);
        }else {
            //Se for mesmo id é pq está alterando
            if (pessoa.getId() == cliente.getId()){
                return pessoaUsuarioRepository.save(cliente);
            }else{
                throw new ResourceNotFoundException("Já existe usuário com esse nome!");
            }

        }
    }

    public boolean verificaSeTemHistorico(long idPessoa){
        List<Comentario> comentario = comentarioService.buscarComentariosPorIdPessoa(idPessoa);
        List<Postagem> postagem = postagemService.buscarPostagensPorIdPessoa(idPessoa);
        if (comentario != null || postagem != null){
            return true;
        }else{
            return false;
        }
    }

}
