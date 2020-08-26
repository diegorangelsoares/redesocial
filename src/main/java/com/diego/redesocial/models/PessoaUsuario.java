package com.diego.redesocial.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**Classe do objeto Pessoausuario
 * @author Diego Rangel
 */
@Entity
@Table(name="TAB_PESSOAUSUARIO")
public class PessoaUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long id;

    public String nome;
    public String telefone;
    public String email;

    @OneToMany
    private List<PessoaUsuario> amigos = new ArrayList<>();

    @OneToMany
    private List<Postagem> postagens = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PessoaUsuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<PessoaUsuario> amigos) {
        this.amigos = amigos;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }
}
