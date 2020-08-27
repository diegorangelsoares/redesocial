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
 * Controller do objeto Usuário
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
//@RequestMapping ("/admin")
@RestController
@RequestMapping("/")
public class UsuarioController {
	
	@Autowired
	PessoaUsuarioService pessoaUsuarioService;

	//End point
	@RequestMapping(method = RequestMethod.POST, value="/Usuarios",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaUsuario> cadastrarUsuario(@RequestBody PessoaUsuario usuario) {
		PessoaUsuario TemUsuarioComMesmoNome = pessoaUsuarioService.buscarPorNome(usuario.getNome());
		PessoaUsuario TemUsuarioComMesmoLogin = pessoaUsuarioService.buscarPorLogin(usuario.getLogin());
		if (TemUsuarioComMesmoNome != null || TemUsuarioComMesmoNome != null){
			//Não existe ninguem com esse nome
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}else {
			//Existe usuario com esse nome
			PessoaUsuario usuarioCadastrado = pessoaUsuarioService.salvar(usuario);
			return new ResponseEntity<PessoaUsuario>(usuarioCadastrado, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/Usuarios",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< PessoaUsuario>> buscarTodosUsuarios() {
		Collection< PessoaUsuario> UsuariosBuscados= pessoaUsuarioService.buscarTodos();
		return new ResponseEntity<>(UsuariosBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/Usuarios/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< PessoaUsuario>> excluirUsuario(@PathVariable Integer id) {
		PessoaUsuario UsuarioEncontrado = pessoaUsuarioService.buscarPorId(id);
		if (UsuarioEncontrado == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			pessoaUsuarioService.excluir(UsuarioEncontrado);
			return new ResponseEntity<>( HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/Usuarios/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaUsuario> buscarUsuarioPorId(@PathVariable Integer id) {
		PessoaUsuario Usuario = pessoaUsuarioService.buscarPorId(id);
		if (Usuario == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>( Usuario, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/Usuarios",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaUsuario> alterarUsuario(@RequestBody PessoaUsuario pessoaUsuario) {
		PessoaUsuario UsuarioAlterado = pessoaUsuarioService.alterar(pessoaUsuario);
		return new ResponseEntity<PessoaUsuario>(UsuarioAlterado, HttpStatus.OK);
	}

}
