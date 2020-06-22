package com.example.agenda_proyecto_final.Clase_Notas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.agenda_proyecto_final.R;

import java.util.HashMap;
import java.util.Map;

public class Modificar_Notas extends AppCompatActivity {

    Button bton_actu;
    EditText titulon, texton;

    String id, titulo, texto;
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
                ModificarNota();
            }
        });
        agregarDatos();
        titulon.setText(titulo);
        texton.setText(texto);
    }

    private void agregarDatos(){
        Intent intent = getIntent();
        Bundle b = intent.getBundleExtra("note");
        id = b.getString("id");
        titulo = b.getString("titulo");
        texto = b.getString("texto");
    }

    private void ModificarNota() {
        final String note_id = id;
        final String nom_titu = titulon.getText().toString();
        final String tex_titu = texton.getText().toString();
        String url = "https://proyectmel.herokuapp.com/mod_nota.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                response = response.replace("\n", "");
                String[] separate = response.split("-");

                if (separate[0].equals("1")) {
                    Intent i = new Intent(Modificar_Notas.this, Notas.class);
                    Bundle b = new Bundle();
                    b.putString("id", id);
                    i.putExtra("user", b);
                    startActivity(i);
                }
                Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_SHORT).show();

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("deletePost", "Error:" + error);
                    }
                }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", note_id);
                params.put("titulo", nom_titu);
                params.put("texto", tex_titu);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
    }
}
