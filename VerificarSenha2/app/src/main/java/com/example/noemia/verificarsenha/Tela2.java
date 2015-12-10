package com.example.noemia.verificarsenha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class Tela2 extends AppCompatActivity {
    TextView boasVindas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Intent i= getIntent();
        Bundle b= i.getExtras();
        boasVindas= (TextView)findViewById(R.id.tvboasVindas);
        if(b!=null ){
            String nome = b.getString("user");
            boasVindas.setText("Bem vindo: " + nome);
        }
    }
    public void Tela(View view){
        Intent i = new Intent (getBaseContext(),MainActivity.class);
        startActivity(i);
    }
}
