package com.example.noemia.lanchonete;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Noemia on 11/12/2015.
 */
public class LanchesListActivity extends Activity {
    TextView lanche, nome, ingridiente,preco;
    Button btVoltar;
    String nom,ingr,prec;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanches);

        Intent i = getIntent();
        Lanche l = (Lanche)i.getSerializableExtra("lanche");
        if(l != null){
            nom = (String) l.nome;
            ingr =l.ingredientes;
            prec=l.preco+"";
        }
       lanche = (TextView) findViewById(R.id.tvselecionado);
        nome= (TextView)findViewById(R.id.tvNome);
        ingridiente=(TextView)findViewById((R.id.tvIngridientes));
        preco=(TextView)findViewById(R.id.tvPreco);
        btVoltar= (Button)findViewById(R.id.buttonVoltar);

        nome.setText(nom);
        ingridiente.setText(ingr);
        preco.setText(prec);
    }
    public void voltar(View view){
        Intent i= new Intent(getBaseContext(), CardapioListActivity.class);
        startActivity(i);
    }

    public void LanchesList(View view){
        Intent i = new Intent (getBaseContext(),CardapioListActivity.class);
        startActivity(i);

}
}