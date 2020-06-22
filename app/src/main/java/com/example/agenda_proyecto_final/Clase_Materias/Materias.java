package com.example.agenda_proyecto_final.Clase_Materias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda_proyecto_final.R;

public class Materias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);
    }

    public void bton_agregar_asignaturas(View view) {
        Intent sig = new Intent(Materias.this, Registrar_asignatura.class);
        startActivity(sig);
    }
}