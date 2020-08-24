package com.diego.redesocial.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**Classe do objeto Pessoa
 * @author Diego Rangel
 * @return -
 */
public class Pessoa {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
