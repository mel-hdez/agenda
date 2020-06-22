package com.example.agenda_proyecto_final.Clase_Notas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.agenda_proyecto_final.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

    public class Notas extends AppCompatActivity implements NotasAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private NotasAdapter mNotasAdapter;
    private ArrayList<NotasItem> mCitaList;
    private RequestQueue mRequestQueue;
    String id;
    public static final String EXTRA_TITULO = "titulo";
    public static final String EXTRA_FECHA = "fecha";
    public static final String EXTRA_TEXTO = "texto";



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_notas);
            Intent intent = getIntent();
            Bundle b = intent.getBundleExtra("user");
            id = b.getString("id");

            mRecyclerView = findViewById(R.id.recyclerView_notas);
            mRecyclerView.setHasFixedSize(true);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mCitaList = new ArrayList<>();
            mRequestQueue = Volley.newRequestQueue(this);
            IngresoNotas();
        }

        public void bton_agregar_notas(View view) {
            Intent sig = new Intent(Notas.this, Registrar_notas.class);
            Bundle b = new Bundle();
            b.putString("id", id);
            sig.putExtra("user", b);
            startActivity(sig);
        }


    private void IngresoNotas() {
        String url = "https://proyectmel.herokuapp.com/notas.php?id="+id;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("test", response.toString());
                        try{
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject Notas = response.getJSONObject(i);
                                String titulo = Notas.getString("nom_notas");
                                String fecha = Notas.getString("fecha");
                                String texto = Notas.getString("desc_notas");
                                mCitaList.add(new NotasItem(titulo,texto,fecha));
                            }
                            mNotasAdapter = new NotasAdapter(Notas.this, mCitaList);
                            mRecyclerView.setAdapter(mNotasAdapter);
                            mNotasAdapter.setOntItemClickListener(Notas.this);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("deletePost", "Error:" + error);
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }

        @Override
        public void onItemClick(int position) {
            Intent detailIntent = new Intent(this, Notas_details.class);
            NotasItem clickedItem = mCitaList.get(position);
            detailIntent.putExtra(EXTRA_TITULO, clickedItem.getntitulo());
            detailIntent.putExtra(EXTRA_FECHA, clickedItem.getntexto());
            detailIntent.putExtra(EXTRA_TEXTO, clickedItem.getmfecha());
            startActivity(detailIntent);
        }
    }
