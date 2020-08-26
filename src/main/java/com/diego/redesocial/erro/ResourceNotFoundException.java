package com.diego.redesocial.erro;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**Classe que trata as exceções
* @author Diego Rangel - diegorangeljpa@gmail.com
*/
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
   /**
     *
     */
private static final long serialVersionUID = 1L;

public ResourceNotFoundException(String mensagem) {
       super(mensagem);
    // TODO Auto-generated constructor stub
}

}