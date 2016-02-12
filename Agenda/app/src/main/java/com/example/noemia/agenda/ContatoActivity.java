package com.example.noemia.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContatoActivity extends AppCompatActivity {
    TextView contato, nome, numero;
    Button btVoltar;
    TextView nom;
    TextView num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        Intent i = getIntent();
        ContatoActivity l = (ContatoActivity)i.getSerializableExtra("contato");
        if(l != null){

            nom = l.nome;
            num =l.numero;

        }
        contato = (TextView) findViewById(R.id.tvNumero2);
        nome= (TextView)findViewById(R.id.tvNome);
        numero=(TextView)findViewById((R.id.tvNumero));
        btVoltar= (Button)findViewById(R.id.fab);

        nome.setText((CharSequence) nom);
        numero.setText((CharSequence) num);

    }
    public void voltar(View view){
        Intent i= new Intent(getBaseContext(), MainActivity.class);
        startActivity(i);
    }

    public void AgendaList(View view){
        Intent i = new Intent (getBaseContext(),MainActivity.class);
        startActivity(i);




    }
}
