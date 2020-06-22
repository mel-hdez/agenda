package com.example.agenda_proyecto_final.Clase_Maestro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda_proyecto_final.R;

public class Maestros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maestros);
    }


    public void bton_agregar_maestros(View view) {
        Intent sig = new Intent(Maestros.this, Registrar_maestros.class);
        startActivity(sig);
    }
}