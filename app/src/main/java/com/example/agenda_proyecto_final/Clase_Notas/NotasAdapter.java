package com.example.agenda_proyecto_final.Clase_Notas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agenda_proyecto_final.R;

import java.util.ArrayList;

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.NotasViewHolder>{
    private Context mContext;
    private ArrayList<NotasItem> mCitaList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOntItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public NotasAdapter(Context context, ArrayList<NotasItem> citaList){
        mContext = context;
        mCitaList = citaList;
    }
    @NonNull
    @Override
    public NotasAdapter.NotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.recyler_notas,parent, false);
        return new NotasAdapter.NotasViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull NotasAdapter.NotasViewHolder holder, int position) {
        NotasItem currentItem = mCitaList.get(position);

        String titulo = currentItem.getntitulo();
        String texto = currentItem.getntexto();
        String fecha = currentItem.getmfecha();


        holder.mTitu.setText(titulo);
        holder.mTextnot.setText(texto);
        holder.mTextFecha.setText(fecha);
    }

    @Override
    public int getItemCount() {
        return mCitaList.size();
    }

    public class NotasViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitu;
        public TextView mTextnot;
        public TextView mTextFecha;

        public NotasViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitu = itemView.findViewById(R.id.tv_titulo_details);
            mTextnot = itemView.findViewById(R.id.tv_fecha_details);
            mTextFecha = itemView.findViewById(R.id.tv_texto_details);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
