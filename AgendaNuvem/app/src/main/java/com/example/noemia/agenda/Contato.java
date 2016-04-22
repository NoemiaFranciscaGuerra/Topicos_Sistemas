package com.example.noemia.agenda;

import java.io.Serializable;

/**
 * Created by Noemia on 21/01/2016.
 */

public class Contato implements Serializable {


    private String nome;
    private String numero;
    private String imagem;
    private String _id;


    public Contato(String _id, String nome, String numero, String imagem) {
        this.nome = nome;
        this.numero = numero;
        this.imagem = imagem;
        this._id= _id;
    }

    public Contato() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getId() {
        return _id;
    }
}