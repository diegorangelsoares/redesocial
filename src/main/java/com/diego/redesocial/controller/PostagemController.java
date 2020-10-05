package com.diego.redesocial.controller;

import com.diego.redesocial.models.Postagem;
import com.diego.redesocial.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

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

		//postagem.setData(new Date());
		Postagem postagemCadastrado = postagemService.salvar(postagem);
		return new ResponseEntity<>(postagemCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/Postagens",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Postagem>> buscarTodosPostagens() {
		Collection< Postagem> PostagensBuscados= postagemService.buscarTodos();
		return new ResponseEntity<>(PostagensBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/Postagens/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Postagem>> excluirPostagem(@PathVariable long id) {
		Postagem PostagemEncontrado = postagemService.buscarPorId(id);
		if (PostagemEncontrado == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			postagemService.excluir(PostagemEncontrado);
			return new ResponseEntity<>( HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/Postagens/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Postagem> buscarPostagemPorId(@PathVariable Integer id) {
		Postagem postagem = postagemService.buscarPorId(id);
		if (postagem == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>( postagem, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/Postagens",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Postagem> alterarPostagem(@RequestBody Postagem postagem) {
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
