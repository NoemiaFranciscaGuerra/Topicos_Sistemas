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

    // Nome da tabela
    private static final String TABLE_NAME = "contato";


    public BancoHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


   public void onCreate(SQLiteDatabase db) {
       String sql = "CREATE TABLE contato(_id INTEGER PRIMARY KEY  AUTOINCREMENT,nome TEXT,numero TEXT, imagem integer)";
       db.execSQL(sql);
       sql = "INSERT INTO contato VALUES(1,'Oncinha da Silva','329122222',"+R.drawable.oncinha+")";
       db.execSQL(sql);
       sql = "INSERT INTO contato VALUES(2,'Fred Rocha','32921345',"+R.drawable.oncinha+")";
       db.execSQL(sql);
       sql = "INSERT INTO contato VALUES(3,'Gatinha Milindrosa','32923434',"+R.drawable.oncinha+")";
       db.execSQL(sql);
       sql = "INSERT INTO contato VALUES(4,'Querido da Rua','32912323',"+R.drawable.oncinha+")";
       db.execSQL(sql);

   }



       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                // Deletando tabela existente
                db.execSQL("DROP TABLE IF EXISTS contato");
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
                values.put("nome", contato.getNome());
                values.put("numero", contato.getNumero());
                values.put("imagem", contato.getImagem());

                // Inserindo valor
                db.insert(TABLE_NAME, null, values);
                //Fechando conexao
                db.close();
            }


    public Cursor mostrar(String sql) {
        return getWritableDatabase().rawQuery(sql, null);
    }

    public int updateContato(Contato contato) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", contato.getNome());
        values.put("numero", contato.getNumero());
        values.put("imagem", contato.getImagem());
        db.insert(TABLE_NAME, null, values);
        db.close();
        return db.update("contato", values, "_id = ?", new String[]{String.valueOf(contato.getId())});
    }
    public Contato getContato(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT _id,  nome,numero,imagem FROM contato where _id = ?";
        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(id)});
        if (cursor != null) {
            cursor.moveToFirst();
            Contato contato = new Contato();
            contato.setId(cursor.getInt(0));
            contato.setNome(cursor.getString(1));
            contato.setNumero(cursor.getString(2));
            contato.setImagem(cursor.getInt(3));
            return contato;

        }
        return null;
    }
    public void deleteContato(Contato contato) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("contato", "_id = ?", new String[]{String.valueOf(contato.getNome())});
        db.close();
    }
    public void getAllContato() {
        List<Contato> contatos = new ArrayList<Contato>();
        String sql = "SELECT _id,  nome,numero,imagem FROM contato";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                Contato contato = new Contato();
                contato.setId(cursor.getInt(0));
                contato.setNome(cursor.getString(1));
                contato.setNumero(cursor.getString(2));
                contato.setImagem(cursor.getInt(3));
                contatos.add(contato);
            } while (cursor.moveToNext());
        }
        return;
    }

}









