package com.example.agenda_proyecto_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda_proyecto_final.Clases_Menu_Principal.Maestros;
import com.example.agenda_proyecto_final.Clases_Menu_Principal.Materias;
import com.example.agenda_proyecto_final.Clases_Menu_Principal.Notas;
import com.example.agenda_proyecto_final.Clase_Tareas_General.Tareas;

public class Menu_Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);




    }

    public void bton_tareas_mp(View view) {
        Intent sig = new Intent(Menu_Principal.this, Tareas.class);
        startActivity(sig);
    }

    public void bton_notas_mp(View view) {
        Intent sig = new Intent(Menu_Principal.this, Notas.class);
        startActivity(sig);
    }

    public void bton_maestros_mp(View view) {
        Intent sig = new Intent(Menu_Principal.this, Maestros.class);
        startActivity(sig);
    }

    public void bton_materias_mp(View view) {
        Intent sig = new Intent(Menu_Principal.this, Materias.class);
        startActivity(sig);
    }
}