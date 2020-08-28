package com.diego.redesocial.controller;


import com.diego.redesocial.models.PessoaUsuario;
import com.diego.redesocial.service.PessoaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

/**
 * Controller autenticador
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@RestController
public class LoginController {


	@Autowired
    PessoaUsuarioService pessoaUsuarioService;
	
	ConvertPasswordToMD5 convertPasswordToMD5 = new ConvertPasswordToMD5();
		
	//End point
	@RequestMapping(method = RequestMethod.POST, value="/autenticar",consumes = MediaType.APPLICATION_JSON_VALUE)
	public loginResponse autenticar(@RequestBody PessoaUsuario pessoaUsuario) throws ServletException {

		System.out.println("Login: "+pessoaUsuario.getLogin());
		if ( pessoaUsuario.getLogin() == null) {
			throw new ServletException("Login e senha obrigatório.");
		}

        PessoaUsuario usuarioAutenticado = pessoaUsuarioService.buscarPorLogin(pessoaUsuario.getLogin());

		//Usuário não pode ser null
		if (usuarioAutenticado == null) {
			throw new ServletException("Usuário ou senha inválido.");
		}

		if (!usuarioAutenticado.getSenha().equals(convertPasswordToMD5.encripta(pessoaUsuario.getSenha()))) {
			throw new ServletException("Usuário ou senha inválido.");
		}

		//String token = Jwts.builder().setSubject(usuarioAutenticado.getNome()).signWith(SignatureAlgorithm.HS256, "diegorangeldoareasdlskmadlkdmsalsdlskmadlkdmsal").setExpiration(new Date(System.currentTimeMillis() + 500 * 60 * 1000)).compact();
		//return new loginResponse(token);
		//return new loginResponse(token, usuario);
		
		//Usuario usu = usuarioService.buscarPorNome(usuario.getNome());
		return new loginResponse(usuarioAutenticado);
		//return usuario;
	}


}
