package com.example.agenda_proyecto_final;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.agenda_proyecto_final.Clase_Usuario.Sing_up;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private TextView tv1;
    String str;
    EditText edit_nombre, edit_contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edit_nombre = findViewById(R.id.edit_user);
        edit_contra = findViewById(R.id.edit_pass);
        tv1 = findViewById(R.id.text_sing_up);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sig = new Intent(Login.this, Sing_up.class);
                startActivity(sig);
            }
        });
    }

    public void ingresar_mp(View view) {ingresar();}

    private void ingresar() {
        final String nombre_log = edit_nombre.getText().toString();
        final String contraseña = edit_contra.getText().toString();
        String url = "https://proyectmel.herokuapp.com/login.php";
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        response = response.replace("\n", "");
                        String[] separate = response.split("-");

                        if (separate[0].equals("1")) {
                            Intent i = new Intent(Login.this, Menu_Principal.class);
                            Bundle b = new Bundle();
                            b.putString("id", separate[1]);
                            i.putExtra("user", b);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(),
                                    "Ingrese un usuario y contraseña válido", Toast.LENGTH_SHORT).show();
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
                params.put("nombre", nombre_log);
                params.put("contraseña", contraseña);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
    }
}
