package adapter.noemia.ufms.cpcx.agenda1.cpcx.ufms.noemia.adapter.adapter;

import java.io.Serializable;

/**
 * Created by Noemia on 29/02/2016.
 */
public class Contato implements Serializable {
    private String nome;
    private String numero;
    private int imagem;
    private int _id;


    public Contato(int _id, String nome, String numero, int imagem) {
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

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public void setId(int id) {
        this._id = _id;
    }

    public int getId() {
        return _id;
    }
}