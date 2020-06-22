package com.example.agenda_proyecto_final.Clase_Notas;

public class NotasItem {
        private String ntitulo, ntexto, nfecha;

        public NotasItem(String titulo, String texto, String fecha){
            ntitulo = titulo;
            ntexto = texto;
            nfecha = fecha;
        }

        public String getntitulo(){
            return ntitulo;
        }
        public void setNtitulo(String titulo) {
        this.ntitulo = titulo;
    }

        public String getntexto(){
            return ntexto;
        }
        public void ntexto(String texto) {
        this.ntexto = texto;
    }

        public String getmfecha(){
            return nfecha;
        }
        public void nfecha(String fecha) {
        this.nfecha = fecha;
    }

}