package com.example.agenda_proyecto_final;

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

import java.util.HashMap;
import java.util.Map;


public class Registrar_usuario extends AppCompatActivity  {

    EditText nombre_usuario,email_usuario,password_usuario;
    Button bton_guarda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_user);

        nombre_usuario = findViewById(R.id.edit_nombre_usuario_registrar);
        email_usuario = findViewById(R.id.edit_email_usuario_registrar);
        password_usuario = findViewById(R.id.edit_password_usuario_registrar);
        bton_guarda = findViewById(R.id.bton_guarda_us);

        bton_guarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistrarUsuario();
                Toast.makeText(getApplicationContext(),"hola", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void RegistrarUsuario() {
        final String nombre_usu = nombre_usuario.getText().toString();
        final String email_nuevo = email_usuario.getText().toString();
        final String contrasena_nueva = password_usuario.getText().toString();
        String url = "https://proyectmel.herokuapp.com/reg_usuario.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        response = response.replace("\n", "");
                        String[] separate = response.split("-");

                        if (separate[0].equals("1")) {
                            Intent i = new Intent(Registrar_usuario.this, Login.class);
                            Bundle b = new Bundle();
                            b.putString("id", separate[1]);
                            i.putExtra("user", b);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(),"Ingrese un usuario y contraseña válido", Toast.LENGTH_SHORT).show();
                        }
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
                params.put("nombre", nombre_usu);
                params.put("email", email_nuevo);
                params.put("contraseña", contrasena_nueva);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
    }


}
