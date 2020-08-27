package com.diego.redesocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedesocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedesocialApplication.class, args);
		System.out.println("\n <<<<< APLICAÇÃO ESTÁ EM EXECUÇÃO >>>>>\n" +
				"\n" +
				"Link de acesso ao Swagger http://localhost:8080/swagger-ui.html\n" +
				"\n" +
				"\n"+
				"Link de acesso a interface Angular http://localhost:8080/#/\n" +
				"\n" +
				"\n");


	}

}
