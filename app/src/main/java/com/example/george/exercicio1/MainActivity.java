package com.example.george.exercicio1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        EditText etNome = (EditText)findViewById(R.id.etNome);
        EditText etNota1 = (EditText)findViewById(R.id.etNota1);
        EditText etNota2 = (EditText)findViewById(R.id.etNota2);
        EditText etFreq = (EditText)findViewById(R.id.etFreq);

        String nome = etNome.getText().toString();
        Float nota1 = Float.parseFloat(etNota1.getText().toString());
        Float nota2 = Float.parseFloat(etNota2.getText().toString());
        Integer freq = Integer.parseInt(etFreq.getText().toString());

        Intent it = new Intent (this, Tela2.class);
        Bundle params = new Bundle();
        params.putString("nome", nome);
        params.putFloat("nota1", nota1);
        params.putFloat("nota2", nota2);
        params.putInt("freq", freq);
        it.putExtras(params);
        startActivity(it);
    }
}
