package com.example.noemia.agenda;

import java.io.Serializable;

/**
 * Created by Noemia on 21/01/2016.
 */

public class Contato implements Serializable {
    private String nome;
    private String numero;
    private int imagem;
    private int id;


    public Contato(int id, String nome, String numero, int imagem) {
        this.nome = nome;
        this.numero = numero;
        this.imagem = imagem;
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

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }
}