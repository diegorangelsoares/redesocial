package com.diego.redesocial.controller;

import com.diego.redesocial.models.PessoaUsuario;

/**
 * Response responável pelo login
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
public class loginResponse {

	//public String token;
	
	public PessoaUsuario pessoaUsuario;
	
	public loginResponse(PessoaUsuario pessoaUsuario) {
		this.pessoaUsuario = pessoaUsuario;
	}
	
	/**
	public loginResponse(String token) {
		this.token = token;
	}
	
	public loginResponse(String token, Usuario usuario) {
		this.token = token;
		this.usuario = usuario;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	*/

	public PessoaUsuario getUsuario() {
		return pessoaUsuario;
	}

	public void setUsuario(PessoaUsuario usuario) {
		this.pessoaUsuario = pessoaUsuario;
	}
	
}
