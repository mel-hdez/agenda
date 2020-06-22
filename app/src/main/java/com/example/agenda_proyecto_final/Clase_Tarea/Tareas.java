package com.example.agenda_proyecto_final.Clase_Tarea;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda_proyecto_final.Clase_Materias.Registrar_asignatura;
import com.example.agenda_proyecto_final.R;

public class Tareas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);

    }

    public void bton_agregar_tareas(View view) {
        Intent sig = new Intent(Tareas.this, Registrar_asignatura.class);
        startActivity(sig);
    }
}