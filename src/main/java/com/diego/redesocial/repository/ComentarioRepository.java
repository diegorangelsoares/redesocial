package com.diego.redesocial.repository;

import com.diego.redesocial.models.Comentario;
import com.diego.redesocial.models.PessoaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    Comentario findById(long id);

    List<Comentario> findByPessoaUsuario(PessoaUsuario pessoaUsuario);

//    @Query(value = "select * from TB_COMENTARIO where upper(texto) like '%"+texto+"%' order by NOME limit 200", nativeQuery = true)
//    List<Comentario> ReturnPorTexto(String texto);





}
