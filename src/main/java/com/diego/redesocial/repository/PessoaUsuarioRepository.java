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

//    @Query(value = "select * from TB_PESSOAUSUARIO where upper(nome) like upper(?)", nativeQuery = true)
//    List<PessoaUsuario> ReturnPorNome(String nome);

    @Query("SELECT u FROM TAB_PESSOAUSUARIO u WHERE upper(u.nome) = ?1")
    List<PessoaUsuario> ReturnPorNome(String nome);





}
