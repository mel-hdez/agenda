package com.example.agenda_proyecto_final.Clase_Notas;

public class NotasItem {
        private String nid, ntitulo, ntexto, nfecha;

        public NotasItem(String id, String titulo, String texto, String fecha){
            nid = id;
            ntitulo = titulo;
            ntexto = texto;
            nfecha = fecha;
        }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNtitulo() {
        return ntitulo;
    }

    public void setNtitulo(String ntitulo) {
        this.ntitulo = ntitulo;
    }

    public String getNtexto() {
        return ntexto;
    }

    public void setNtexto(String ntexto) {
        this.ntexto = ntexto;
    }

    public String getNfecha() {
        return nfecha;
    }

    public void setNfecha(String nfecha) {
        this.nfecha = nfecha;
    }
}