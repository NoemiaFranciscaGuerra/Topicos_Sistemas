package com.example.noemia.senha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText senha, user;
    TextView boasVindas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        senha = (EditText)findViewById(R.id.senha);
        user = (EditText)findViewById(R.id.user);

    }
    public void senha(View v){
    }

    public void logar(View view) {
        Bundle b = new Bundle();
        b.putString("user" ,user.getText().toString());
        b.putString("senha " , senha.getText().toString());
        boasVindas= (TextView)findViewById(R.id.tvboasVindas );
        Intent i= new Intent(getBaseContext(),Tela2Activity.class);
        i.putExtras(b);
        startActivity(i);
    }
}


