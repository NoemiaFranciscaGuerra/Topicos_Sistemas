package com.example.noemia.agenda;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BancoHelper b;
    private ListView listView;
    private ArrayList<Contato> itens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = new BancoHelper(getBaseContext(), "contato", null, 1);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        listView = (ListView) findViewById(R.id.listView);
        itens = new ArrayList<Contato>();

        CustonAdapter custonAdapter = new CustonAdapter(itens, getApplicationContext());
        listView.setAdapter(custonAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Contato contato = new Contato();
                contato.setNome("contato" + itens.size());
                contato.setNumero("");
                itens.add(contato);
                consultaAgenda();
                CustonAdapter custonAdapter = new CustonAdapter(itens, getApplicationContext());
                listView.setAdapter(custonAdapter);
                Intent i = new Intent(getBaseContext(), Cadastro.class);
                startActivity(i);

            }
        });
    }

    private void consultaAgenda() {
        String sql = "SELECT  nome,numero FROM contato";
        itens = new ArrayList<Contato>();
        Cursor cursor = b.mostrar(sql);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                Contato l = new Contato();
                l.setNome(cursor.getString(0));
                l.setNumero(cursor.getString(1));
                itens.add(l);
                cursor.moveToNext();

            }
        }

    }

    private void Insere(Contato contato) {
        SQLiteDatabase base = b.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", contato.getNome());
        values.put("numero", contato.getNumero());

    }

}
