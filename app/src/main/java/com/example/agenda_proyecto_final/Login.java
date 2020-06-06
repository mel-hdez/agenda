package com.example.agenda_proyecto_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv1 =findViewById(R.id.text_sing_up);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sig = new Intent(Login.this, Sing_up.class);
                startActivity(sig);
            }
        });

    }

    public void ingresar_mp(View view) {
        Intent sig = new Intent(Login.this, Menu_Principal.class);
        startActivity(sig);
    }
}
