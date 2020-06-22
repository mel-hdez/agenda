package com.example.agenda_proyecto_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda_proyecto_final.Clase_Maestro.Maestros;
import com.example.agenda_proyecto_final.Clase_Materias.Materias;
import com.example.agenda_proyecto_final.Clase_Notas.Notas;
import com.example.agenda_proyecto_final.Clase_Tarea.Tareas;

public class Menu_Principal extends AppCompatActivity {

    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        Intent intent = getIntent();
        Bundle b = intent.getBundleExtra("user");
        id = b.getString("id");



    }

    public void bton_tareas_mp(View view) {
        Intent sig = new Intent(Menu_Principal.this, Tareas.class);
        startActivity(sig);
    }

    public void bton_notas_mp(View view) {
        Intent sig = new Intent(Menu_Principal.this, Notas.class);
        Bundle b = new Bundle();
        b.putString("id", id);
        sig.putExtra("user", b);
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