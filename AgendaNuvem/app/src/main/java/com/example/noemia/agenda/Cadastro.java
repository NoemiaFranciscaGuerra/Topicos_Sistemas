package com.example.noemia.agenda;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.firebase.client.Firebase;

import java.io.File;

public class Cadastro extends AppCompatActivity {
    Button cadastro, escolher;
    BancoHelper bh;
    private final int SELECT_PHOTO = 1;
    private ImageView imageView;
    Firebase BancoFirabse ;
    ImageView imagem;
    Button foto;

    private Contato contato;
    private String localFoto;
    private static final int FOTO =1;
    private boolean fotoResource = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        BancoFirabse = new Firebase("https://aulanoemia.firebaseio.com/contatos");
        setContentView(R.layout.activity_cadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        cadastro = (Button) findViewById(R.id.bt_cad);
        imagem = (ImageView) findViewById(R.id.imageView);
        foto = (Button) findViewById(R.id.btImagem);
        bh = new BancoHelper(getBaseContext());
        FloatingActionButton cont = (FloatingActionButton) findViewById(R.id.fab);
        setSupportActionBar(toolbar);

        FloatingActionButton f = (FloatingActionButton) findViewById(R.id.fab);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
        });

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contato c = new Contato();
                c.setNome(((EditText) findViewById(R.id.edtNome)).getText().toString());
                c.setNumero(((EditText) findViewById(R.id.edtNumero)).getText().toString());
                //c.setImagem((String) imagem.getTag());
                //bh.addContato(c);
                BancoFirabse.push().setValue(c);
                ((EditText) findViewById(R.id.edtNome)).setText("");
                ((EditText) findViewById(R.id.edtNumero)).setText("");
                //imagem.setTag("");

            }
        });

        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaFoto();

            }
        });

    }
        public void carregaFoto() {
            fotoResource = true;
            localFoto = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";

            Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(localFoto)));

            startActivityForResult(intentCamera, 1);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == FOTO) {
                if (resultCode == Activity.RESULT_OK) {
                    setFoto(localFoto);
                } else {
                    this.localFoto = null;
                }
            }
        }

        private void setFoto(String url) {
            if (url != null) {
                Bitmap imagemFoto = BitmapFactory.decodeFile(url);
                imagem.setImageBitmap(imagemFoto);
                imagem.setTag(url);
            }
        }


    }


