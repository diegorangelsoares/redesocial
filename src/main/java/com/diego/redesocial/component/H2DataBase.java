package com.diego.redesocial.component;


import com.diego.redesocial.models.Pessoausuario;
import com.diego.redesocial.repository.PessoaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class H2DataBase {
	@Autowired
	private PessoaUsuarioRepository pessoaUsuarioRepository;
	
	@EventListener
    public void appReady(ApplicationReadyEvent event) {

        insertDUMP();

    }


	/**Código abaixo insere um dump inicial
	* @author Diego Rangel
	* @return 
	*/
	public void insertDUMP() {

		List <Pessoausuario> pessoas = new ArrayList<>();

		Pessoausuario pessoa1 = new Pessoausuario();
		pessoa1.setNome("Diego");
		pessoa1.setTelefone("99554455");
        pessoas.add(pessoa1);

        Pessoausuario pessoa2 = new Pessoausuario();
        pessoa2.setNome("Joao");
        pessoa2.setTelefone("39554455");
        pessoas.add(pessoa2);

		//Inserir no banco
		try {
		    for (Pessoausuario p: pessoas){
                pessoaUsuarioRepository.save(p);
            }
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
