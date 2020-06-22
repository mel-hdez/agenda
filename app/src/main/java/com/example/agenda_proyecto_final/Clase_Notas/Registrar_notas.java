package com.example.agenda_proyecto_final.Clase_Notas;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Registrar_notas extends AppCompatActivity {

    EditText nombre_titulo, texto_nota,edDate;
    Button bton_guarda_not;
    DatePickerDialog mDatePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_notas);

        nombre_titulo = findViewById(R.id.edit_titulo_nota);
        texto_nota = findViewById(R.id.edit_agre_text);
        bton_guarda_not = findViewById(R.id.bton_guarda_notas);
        edDate = (EditText) findViewById(R.id.edit_fecha);

        setDateTimeField();edDate.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDatePickerDialog.show();
                return false;
            }
        });
        bton_guarda_not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {RegistrarNota();
                Toast.makeText(getApplicationContext(), "Guardado Correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setDateTimeField() {

        Calendar newCalendar = Calendar.getInstance();
        mDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
                final Date startDate = newDate.getTime();
                String fdate = sd.format(startDate);

                edDate.setText(fdate);

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        mDatePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }
    private void RegistrarNota() {
        final String nom_titu = nombre_titulo.getText().toString();
        final String tex_titu = texto_nota.getText().toString();
        final String fecha_notas = edDate.getText().toString();
        String url = "https://proyectmel.herokuapp.com/reg_nota.php";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String[] separate = response.split("-");

                if (separate[0].equals("1")) {
                    Intent i = new Intent(Registrar_notas.this, Notas.class);
                    startActivity(i);
                }
                else {
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
                params.put("titulo", nom_titu);
                params.put("texto", tex_titu);
                params.put("fecha", fecha_notas);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
    }
}
