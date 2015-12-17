package com.example.noemia.lanchonete;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noemia on 11/12/2015.
 */
public class Lanche implements Serializable {

    String nome;
    String ingredientes;
    double preco;

    public Lanche(String nome, String ingredientes, double preco) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.preco= preco;

    }
}
