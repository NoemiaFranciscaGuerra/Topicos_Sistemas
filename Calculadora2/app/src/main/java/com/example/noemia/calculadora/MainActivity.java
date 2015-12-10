package com.example.noemia.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText v1,v2;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v1=(EditText)findViewById(R.id.edtV1);
        v2=(EditText)findViewById(R.id.edtV2);
        t=(TextView)findViewById(R.id.tvValor);
    }
    public void mais(View v){
        int vl1= Integer.parseInt(v1.getText().toString());
        int vl2= Integer.parseInt(v2.getText().toString());
      t.setText("a soma e : " +(vl1 + vl2));
    }
    public void menos(View v){
        int vl1= Integer.parseInt(v1.getText().toString());
        int vl2= Integer.parseInt(v2.getText().toString());
        t.setText("a subtração e : " +(vl1- vl2));
    }
    public void dividir(View v){
        int vl1= Integer.parseInt(v1.getText().toString());
        int vl2= Integer.parseInt(v2.getText().toString());
        t.setText("a Divisão e : " +(vl1/ vl2));
    }
    public void multiplicar(View v){
        int vl1= Integer.parseInt(v1.getText().toString());
        int vl2= Integer.parseInt(v2.getText().toString());
        t.setText("a multiplicação e : " +(vl1* vl2));
    }

}
