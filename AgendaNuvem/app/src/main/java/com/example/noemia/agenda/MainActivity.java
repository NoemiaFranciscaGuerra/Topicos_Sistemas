package com.example.noemia.agenda;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   /* Banco b = new Banco(getBaseContext(), "contato", null, 1);**/

    private ListView listView;
    private List<Contato> contatos;
    Firebase BancoFirabse;

Button cad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        BancoFirabse= new Firebase("https://aulanoemia.firebaseio.com/contatos");
        contatos= new ArrayList<Contato>();
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        atualizaLista();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizaLista();

                Intent i = new Intent(getBaseContext(), Cadastro.class);

                startActivity(i);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Funcao de delete
                BancoFirabse.child(contatos.get(position).getId()).removeValue();
                //usando funcao de update

                atualizaLista();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });


    }

    private void atualizaLista() {

        BancoFirabse.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot d:dataSnapshot.getChildren()){
                    Contato c= d.getValue(Contato.class);
            c.setId(d.getKey());
                    contatos.add(c);

                }
               // if(listView.getAdapter()!= null )
                //((CustonAdapter)listView.getAdapter()).Clear();

                CustonAdapter custonAdapter = new CustonAdapter(contatos, getApplicationContext());
                listView.setAdapter(custonAdapter);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


      //
    }
}