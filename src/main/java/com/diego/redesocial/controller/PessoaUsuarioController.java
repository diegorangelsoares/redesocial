package com.diego.redesocial.controller;

import com.diego.redesocial.models.PessoaUsuario;
import com.diego.redesocial.service.PessoaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Controller de PessoaUsuario
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
//@RequestMapping ("/admin")
@RestController
@RequestMapping("/")
public class PessoaUsuarioController {
	
	@Autowired
	PessoaUsuarioService pessoaUsuarioService;

	//End point
	@RequestMapping(method = RequestMethod.POST, value="/PessoasUsuarios",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaUsuario> cadastrarCliente(@RequestBody PessoaUsuario pessoaUsuario) {
		PessoaUsuario pessoaUsuarioCadastrado = pessoaUsuarioService.salvar(pessoaUsuario);
		return new ResponseEntity<PessoaUsuario>(pessoaUsuarioCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/PessoasUsuarios",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< PessoaUsuario>> buscarTodosPessoasUsuarios() {
		Collection< PessoaUsuario> pessoaUsuarioBuscados= pessoaUsuarioService.buscarTodos();
		return new ResponseEntity<>(pessoaUsuarioBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/PessoasUsuarios/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< PessoaUsuario>> excluirPessoaUsuario(@PathVariable Integer id) {
		PessoaUsuario pessoaUsuarioEncontrado = pessoaUsuarioService.buscarPorId(id);
		if (pessoaUsuarioEncontrado == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			pessoaUsuarioService.excluir(pessoaUsuarioEncontrado);
			return new ResponseEntity<>( HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/PessoasUsuarios/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaUsuario> buscarPessoaUsuarioPorId(@PathVariable Integer id) {
		PessoaUsuario pessoaUsuario = pessoaUsuarioService.buscarPorId(id);
		if (pessoaUsuario == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>( pessoaUsuario, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/PessoasUsuarios",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaUsuario> alterarCliente(@RequestBody PessoaUsuario pessoaUsuario) {
		PessoaUsuario pessoaUsuarioAlterado = pessoaUsuarioService.alterar(pessoaUsuario);
		return new ResponseEntity<PessoaUsuario>(pessoaUsuarioAlterado, HttpStatus.OK);
	}
	
	/**
	//End point TESTE
	@RequestMapping(method = RequestMethod.GET, value="/PessoasUsuarios")
	public void busca() {
		System.out.println("Deu certo");
	}
	*/

}
