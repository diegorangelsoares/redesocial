package com.diego.redesocial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller de página principal
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String irParaHome() {
		return "index";
	}

}
