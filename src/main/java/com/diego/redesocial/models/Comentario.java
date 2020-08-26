package com.diego.redesocial.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**Classe do objeto Comentario
 * @author Diego Rangel
 */
@Entity
@Table(name="TAB_COMENTARIO")
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;
    public String texto;
    public Date data;

    @OneToOne
    public PessoaUsuario pessoaUsuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public PessoaUsuario getPessoaUsuario() {
        return pessoaUsuario;
    }

    public void setPessoaUsuario(PessoaUsuario pessoaUsuario) {
        this.pessoaUsuario = pessoaUsuario;
    }
}
