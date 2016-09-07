package com.example.mdominguez.laburoencasa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.listaOfertas);
        OfertaAdapter ofertaAdapter = new OfertaAdapter(this,Arrays.asList(Trabajo.TRABAJOS_MOCK));
        lista.setAdapter(ofertaAdapter);

    }





}
