package com.example.noemia.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;

public class ContatoActivity extends AppCompatActivity {
    @Bind(R.id.tvContato)TextView contato;
    @Bind(R.id.tvNome)TextView nome;
    @Bind(R.id.tvNumero2)TextView numero;
    @Bind(R.id.fab) Button btVoltar;
    @Bind(R.id.imageView) ImageView imagem;


    TextView nom;
    TextView num;
    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        setContentView(R.layout.activity_contato);

        Intent i = getIntent();
        nome.setText((CharSequence) nom);
        numero.setText((CharSequence) num);
        imagem.setTag((CharSequence) foto);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);

            }
        });

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
