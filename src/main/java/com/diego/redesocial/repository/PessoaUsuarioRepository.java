package com.diego.redesocial.repository;

import com.diego.redesocial.models.PessoaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**Repositorio PessoaUsuario
 * @author Diego Rangel
 */
public interface PessoaUsuarioRepository  extends JpaRepository<PessoaUsuario, Long> {

    PessoaUsuario findById(long id);

    @Query(value = "select * from TB_PESSOAUSUARIO order by NOME limit 200", nativeQuery = true)
    List<PessoaUsuario> ReturnPorNome();




}
