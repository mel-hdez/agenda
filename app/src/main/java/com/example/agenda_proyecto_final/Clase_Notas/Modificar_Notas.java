package com.example.agenda_proyecto_final.Clase_Notas;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda_proyecto_final.R;

public class Modificar_Notas extends AppCompatActivity {

    Button bton_actu;
    EditText titulon, texton;
    int posicion;
    NotasItem notasItem;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar__notas);
        bton_actu = findViewById(R.id.bton_guarda_notas_mod);
        titulon = findViewById(R.id.et_titulo_mod);
        texton = findViewById(R.id.et_text_mod);

        bton_actu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick_activity_modificar__notas();
            }
        });
        posicion = 0;
        if (Globales.lista.size()>0){
            notasItem = Globales.lista.get (0);
            imprime (notasItem);
        }

    }

    private void imprime(NotasItem x) {

            titulon.setText(x.getntitulo());
            texton.setText(x.getntexto());
    }


    private void onClick_activity_modificar__notas() {
        if (Globales.lista.size()>0){
            notasItem.setNtitulo(titulon.getText().toString());
            notasItem.ntexto(texton.getText().toString());
                        Toast.makeText(this,"Se Actualizo correctamente",Toast.LENGTH_SHORT).show();

        }
    }
}
