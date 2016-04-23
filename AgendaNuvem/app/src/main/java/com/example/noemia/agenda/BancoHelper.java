package com.example.noemia.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Noemia on 28/01/2016.
 */
public class BancoHelper extends SQLiteOpenHelper {


    // Versao do Banco
    private static final int DATABASE_VERSION = 1;

    // Nome da Base de dados
    private static final String DATABASE_NAME = "agenda1";

    // Nome da tabela
    private static final String TABLE_NAME = "contato";



    public BancoHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Criando tabela
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE contato(_id TEXT PRIMARY KEY ,nome TEXT, numero TEXT, imagem TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Deletando tabela existente
        db.execSQL("DROP TABLE IF EXISTS contato" );
        // Criando nova tabela
        onCreate(db);
    }

    /**
     *  CRUD(Create, Read, Update, Delete)
     */

    // Adicionando novo contato
    public void addContato(Contato contato) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("_id", contato.getId());
        values.put("nome", contato.getNome());
        values.put("numero", contato.getNumero());
        values.put("imagem", contato.getImagem());

        // Inserindo valor
        db.insert(TABLE_NAME, null, values);
        //Fechando conexao
        db.close();
    }

    // Retorna um unico contato
    public Contato getContato(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT _id,  nome,valor,imagem FROM lanche where _id = ?";

        Cursor cursor = db.rawQuery(sql,new String[]{ String.valueOf(id)});

        if (cursor != null){
            cursor.moveToFirst();

            Contato contato = new Contato();
            //contato.setId(cursor.getInt(0));
            contato.setNome(cursor.getString(1));
            contato.setNumero(cursor.getString(2));
            contato.setImagem(cursor.getString(3));

            return contato;

        }
        return  null;

    }

    // Obtendo todos os contatos
    public List<Contato> getAllContatos() {
        List<Contato> contatos = new ArrayList<Contato>();
        // Sql da consulta da base de dados
        String sql = "SELECT _id,  nome,numero,imagem FROM contato";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        // looping Povoando a lista de contatos
        if (cursor.moveToFirst()) {
            do {
                Contato contato = new Contato();
                //contato.setId(cursor.getInt(0));
                contato.setNome(cursor.getString(1));
                contato.setNumero(cursor.getString(2));
                contato.setImagem(cursor.getString(3));
                // Adicionando elemento a lista
                contatos.add(contato);
            } while (cursor.moveToNext());
        }
        return contatos;
    }

    // Updating um unico contato
    public int updateContato(Contato contato) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", contato.getNome());
        values.put("numero", contato.getNumero());
        values.put("imagem",contato.getImagem());

        // updating row
        return db.update(TABLE_NAME, values,  "_id = ?",
                new String[] { contato.getId() });
    }

    // Deletando um contato
    public void deleteContato(Contato contato) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, " _id= ?",
                new String[]{contato.getId()});
        db.close();
    }

    // Obter quantidade de contatos
    public int getContatosCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        // return count
        return cursor.getCount();
    }
}