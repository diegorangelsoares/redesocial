package com.diego.redesocial.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**Classe do objeto Pessoausuario
 * @author Diego Rangel
 * @return -
 */
@Entity
@Table(name="TAB_PESSOAUSUARIO")
public class Pessoausuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long id;

    public String nome;
    public String telefone;

    //List<Pessoa> amigos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
