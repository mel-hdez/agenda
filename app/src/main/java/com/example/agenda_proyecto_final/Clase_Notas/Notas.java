package com.example.agenda_proyecto_final.Clase_Notas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.example.agenda_proyecto_final.R;

public class Notas extends AppCompatActivity {

    private RecyclerView notRecyclerView;

    private RequestQueue mRequestQueue;
    String id;


    public static final String EXTRA_TITULO = "titulo";
    public static final String EXTRA_AGRE_TEX = "agregar texo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);


    }

    public void bton_agregar_notas(View view) {
        Intent sig = new Intent(Notas.this, Registrar_notas.class);
        startActivity(sig);
    }

    private void ingresoNotas() {
    }


}

