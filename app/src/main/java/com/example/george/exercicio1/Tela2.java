package com.example.george.exercicio1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        String nome ="";
        Float nota1 =0f;
        Float nota2 =0f;
        Integer freq = 0;

        TextView tvNome = (TextView)findViewById(R.id.tvNome);
        TextView tvMedia = (TextView)findViewById(R.id.tvMedia);
        TextView tvFreq = (TextView)findViewById(R.id.tvFreq);
        TextView tvResultado = (TextView)findViewById(R.id.tvResultado);

        Intent it = getIntent();
        if (it != null){
            Bundle params = it.getExtras();
            if(params != null){
                nome = params.getString("nome");
                nota1 = params.getFloat("nota1");
                nota2 = params.getFloat("nota2");
                freq = params.getInt("freq");
            }
        }

        tvNome.setText(nome);

        float notafinal = calcMedia(nota1, nota2);

        tvMedia.setText(String.valueOf(String.format("%.02f",notafinal)));

        tvFreq.setText(String.valueOf(freq));

        if(notafinal >= 7.0 && freq >= 75){
            tvResultado.setText("Aprovado");
        } else if (notafinal <= 6.9 && notafinal >=4 && freq >= 75){
            tvResultado.setText("Final");
        } else if (freq < 75){
            tvResultado.setText("Reprovado por falta");
        } else if (notafinal < 4.0){
            tvResultado.setText("Reprovado por nota");
        }
    }

    private float calcMedia(float nota1, float nota2){
        float media = (nota1 + nota2) /2;
        return media;
    }
}
