package adapter.noemia.ufms.cpcx.agenda1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import adapter.noemia.ufms.cpcx.agenda1.cpcx.ufms.noemia.adapter.adapter.Contato;
import adapter.noemia.ufms.cpcx.agenda1.cpcx.ufms.noemia.adapter.adapter.CustonAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import cpcx.ufms.adapter.helper.BancoHelper;


public class MainActivity extends AppCompatActivity {

    private BancoHelper bh;

    @Bind(R.id.fab)
    ListView listView;

    private List<Contato> contatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bh = new BancoHelper(getBaseContext());


       contatos = bh.getAllContatos();


        CustonAdapter custonAdapter = new CustonAdapter(contatos, getApplicationContext());
        listView.setAdapter(custonAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),contatos.getClass());
                startActivity(i);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getBaseContext(), contatos.getClass());
                i.putExtra("contato", contatos.get(position));
                startActivity(i);
            }
        });


    }

    private void atualizaLista() {
       contatos = bh.getAllContatos();

        CustonAdapter custonAdapter = new CustonAdapter(contatos, getApplicationContext());
        listView.setAdapter(custonAdapter);
    }
}