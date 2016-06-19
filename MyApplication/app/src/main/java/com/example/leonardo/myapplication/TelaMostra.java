package com.example.leonardo.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.TextView;

/**
 * Created by leonardo on 21/05/16.
 */
public class TelaMostra extends AppCompatActivity {

    private TextView mostraNumero, mostraNome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_mostra_dados);

        mostraNome = (TextView) findViewById(R.id.mostraNome);


        mostraNumero = (TextView) findViewById(R.id.mostraNumero);

    }
}
