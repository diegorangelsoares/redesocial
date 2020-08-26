package com.diego.redesocial.service;

import com.diego.redesocial.erro.ResourceNotFoundException;
import com.diego.redesocial.models.PessoaUsuario;
import com.diego.redesocial.repository.PessoaUsuarioRepository;
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

    //Negocio
    public PessoaUsuario cadastrar(PessoaUsuario pessoaUsuario) {
        return pessoaUsuarioRepository.save(pessoaUsuario);
    }

    public Collection< PessoaUsuario> buscarTodos(){
        return pessoaUsuarioRepository.findAll();
    }

    public void excluir (PessoaUsuario pessoaUsuario) {
        //System.out.println("Chamou funcao excluir cliente");
        verificaSeTemHistorico(pessoaUsuario.getId());
        pessoaUsuarioRepository.delete(pessoaUsuario);
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
        return pessoaUsuarioRepository.save(cliente);
    }

    public PessoaUsuario buscarHistoricoPorIdPessoa(long id) {
       /*
        List<PessoaUsuario> pessoas = pessoaUsuarioRepository.findAll();
        PessoaUsuario pro = null;
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getCliente().getId() == id) {
                pro = pessoas.get(i);
            }
        }
        return pro;

        */
        return null;
    }

    public void verificaSeTemHistorico(long idPessoa){
        PessoaUsuario pro = buscarHistoricoPorIdPessoa(idPessoa);
        if(pro == null) {
            //System.out.println("Cliente não possui contrato");
        }else {
            //System.out.println("Cliente possui contrato e não pode ser excluido. Contrato: " + pro.getId());
            throw new ResourceNotFoundException("Pessoa possui histórico e não pode ser excluido.");

        }
    }

}
