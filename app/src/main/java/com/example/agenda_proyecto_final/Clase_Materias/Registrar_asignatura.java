package com.example.agenda_proyecto_final.Clase_Materias;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda_proyecto_final.R;

import java.util.ArrayList;
import java.util.List;

public class Registrar_asignatura extends AppCompatActivity {

    EditText titulo, nom_class;
    Spinner spin_maestros;
    List<String> spinnerArrayMaestro = new ArrayList<String>();
    /*private RequestQueue mRequestQueue;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_asignatura);



    }
}
