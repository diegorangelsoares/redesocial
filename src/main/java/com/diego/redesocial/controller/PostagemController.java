package com.diego.redesocial.controller;

import com.diego.redesocial.models.Postagem;
import com.diego.redesocial.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Controller de postagem
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
//@RequestMapping ("/admin")
@RestController
@RequestMapping("/")
public class PostagemController {

	@Autowired
	PostagemService postagemService;

	//End point
	@RequestMapping(method = RequestMethod.POST, value="/Postagens",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Postagem> cadastrarPostagem(@RequestBody Postagem postagem) {
		
//		if (postagem.getStatusProposta() == null) {
//			postagem.setStatusProposta("pendente");
//		}
//		if (postagem.getStatusDocumentos() == null) {
//			postagem.setStatusDocumentos("pendente");
//		}
//		if (postagem.getStatusSPC() == null) {
//			postagem.setStatusSPC("pendente");
//		}
		Postagem postagemCadastrado = postagemService.salvar(postagem);
		return new ResponseEntity<Postagem>(postagemCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/Postagens",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Postagem>> buscarTodosPropostas() {
		Collection< Postagem> PropostasBuscados= postagemService.buscarTodos();
		return new ResponseEntity<>(PropostasBuscados, HttpStatus.OK);
	}

	/*
	@RequestMapping(method = RequestMethod.GET, value="/CountPropostas",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Collection< long>> retornaQuantidadeDePropostas() {
		Collection <long> quant = PropostaService.retornaQuantidadeDePropostasCadastradas();
		return new ResponseEntity<>(quant, HttpStatus.OK);
	}
	*/
	
	@RequestMapping(method = RequestMethod.DELETE, value="/Postagens/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Postagem>> excluirPostagem(@PathVariable long id) {
		Postagem PropostaEncontrado = postagemService.buscarPorId(id);
		if (PropostaEncontrado == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			postagemService.excluir(PropostaEncontrado);
			return new ResponseEntity<>( HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/Postagens/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Postagem> buscarPropostaPorId(@PathVariable Integer id) {
		Postagem Proposta = postagemService.buscarPorId(id);
		if (Proposta == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>( Proposta, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/Postagens",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Postagem> alterarProposta(@RequestBody Postagem postagem) {
		Postagem PostagemAlterado = postagemService.alterar(postagem);
		return new ResponseEntity<Postagem>(PostagemAlterado, HttpStatus.OK);
	}
	
	/**
	//End point TESTE
	@RequestMapping(method = RequestMethod.GET, value="/Postagens")
	public void busca() {
		System.out.println("Deu certo");
	}
	*/
	
}
