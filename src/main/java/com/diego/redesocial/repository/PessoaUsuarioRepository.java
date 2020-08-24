package com.diego.redesocial.repository;

import com.diego.redesocial.models.Pessoausuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**Repositorio PessoaUsuario
 * @author Diego Rangel
 */
public interface PessoaUsuarioRepository  extends JpaRepository<Pessoausuario, Long> {

    Pessoausuario findById(long id);

    @Query(value = "select * from TB_PESSOAUSUARIO order by NOME limit 200", nativeQuery = true)
    List<Pessoausuario> ReturnPorNome();




}
