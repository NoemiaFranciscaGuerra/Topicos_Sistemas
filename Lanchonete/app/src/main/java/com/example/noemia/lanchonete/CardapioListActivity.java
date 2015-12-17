package com.example.noemia.lanchonete;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;


public class CardapioListActivity extends Activity implements AdapterView.OnItemClickListener {

    ListView listView;
    EditText sanduiche, preco;
    TextView selecionado;

    static Lanche[] lanches = {
            new Lanche("X.BACON", "pao hambúrguer , queijo, bacon",8.0),
            new Lanche("X.SALADA", "pao hambúrguer, queijo, alface, maionese, tomate",10.0),
            new Lanche("X.BURGER", "pão hambúrguer,  hambúrguer, queijo",7.5),
            new Lanche("X - EGG", " pão hamburguer, hamburguer, queijo, ovo, alface, maionese, tomate",10.0),
            new Lanche("X.SALADA TENDER ",  " pão hambúrguer, hambúrguer, tender, queijo, alface, maionese, tomate",13.0),
            new Lanche("AMERICANO","pao de forma , queijo, presunto, manteiga, alface, tomate, ovo",12.0),
            new Lanche("FRANGAO", "pão hambúrguer, peito de frango, provolone, tomate,  maionese",9.0),
            new Lanche("BIG FRANGO", "pao hambúrguer, peito de frango, creme de milho, queijo, bacon, maionese",13.0),
            new Lanche("CHURRASCO ",  " pao francês, bife, queijo, tomate",10.0),
            new Lanche("MISTO QUENTE ", " pão francês, presunto, queijo ",12.0),
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);
        ArrayList<String> lista = new ArrayList<>();

        for (int i = 0; i < lanches.length; i++) {
            lista.add(lanches[i].nome);
        }


        preco = (EditText) findViewById(R.id.preco);
        listView = (ListView) findViewById(R.id.listView);

        //listView.setAdapter(new ListViewAdapter(this,android.R.layout.simple_list_item_1,lista));
        ArrayAdapter adpt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);

        listView.setAdapter(adpt);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Lanche lancheSelecionado = lanches[position];

        Bundle b = new Bundle();
        b.putSerializable("lanche", lancheSelecionado);
        Intent i = new Intent(getBaseContext(), LanchesListActivity.class);
        i.putExtras(b);
        startActivity(i);
    }
}





