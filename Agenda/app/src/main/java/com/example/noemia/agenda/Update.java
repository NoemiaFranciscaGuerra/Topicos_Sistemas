package com.example.noemia.agenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Noemia on 28/02/2016.
 */
public class Update extends AppCompatActivity {
    @Bind(R.id.imageView)ImageView imagem;
    @Bind(R.id.edtNumero)EditText numero;
    @Bind(R.id.edtNome)EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar();

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        if(b!=null){
           Contato l = (Contato) b.get("contato");
            updateUI(l);
        }

    }

    private void setSupportActionBar() {
    }

    public void updateUI(Contato contato){
        if(contato==null){
            nome.setText(null);
            imagem.setImageResource(R.drawable.esperanca);
            numero.setText(null);
        }else{
            nome.setText(contato.getNome());
            imagem.setImageResource(contato.getImagem());
            numero.setText(contato.getNumero());
        }
    }
}