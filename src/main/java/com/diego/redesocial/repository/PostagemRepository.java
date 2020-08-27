package com.diego.redesocial.repository;

import com.diego.redesocial.models.PessoaUsuario;
import com.diego.redesocial.models.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostagemRepository  extends JpaRepository<Postagem, Long> {

    Postagem findById(long id);

    List<Postagem> findByPessoaUsuario(PessoaUsuario pessoa);

//    @Query(value = "select * from TB_COMENTARIO where upper(texto) like '%"+texto+"%' order by NOME limit 200", nativeQuery = true)
//    List<Comentario> ReturnPorTexto(String texto);


}
