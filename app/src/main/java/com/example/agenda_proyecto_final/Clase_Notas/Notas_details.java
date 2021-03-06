package com.example.agenda_proyecto_final.Clase_Notas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda_proyecto_final.R;

import static com.example.agenda_proyecto_final.Clase_Notas.Notas.EXTRA_FECHA;
import static com.example.agenda_proyecto_final.Clase_Notas.Notas.EXTRA_ID;
import static com.example.agenda_proyecto_final.Clase_Notas.Notas.EXTRA_TEXTO;
import static com.example.agenda_proyecto_final.Clase_Notas.Notas.EXTRA_TITULO;

public class Notas_details extends AppCompatActivity {
    String id, titulo, fecha, texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_details);

        Intent intent = getIntent();
        id = intent.getStringExtra(EXTRA_ID);
        titulo = intent.getStringExtra(EXTRA_TITULO);
        fecha = intent.getStringExtra(EXTRA_FECHA);
        texto = intent.getStringExtra(EXTRA_TEXTO);

        TextView tvtitulo = findViewById(R.id.tv_titulo_details);
        TextView tvfecha = findViewById(R.id.tv_fecha_details);
        TextView tvtexto = findViewById(R.id.tv_texto_details);

        tvtitulo.setText("Titulo:" + titulo);
        tvfecha.setText("Fecha:"+fecha);
        tvtexto.setText("Texto:"+texto);

    }

    public void bton_agregar_nota1(View view) {
        Intent sig = new Intent(Notas_details.this, Modificar_Notas.class);
        Bundle b = new Bundle();
        b.putString("id", id);
        b.putString("titulo", titulo);
        b.putString("texto", texto);
        sig.putExtra("note", b);
        startActivity(sig);
    }
}
