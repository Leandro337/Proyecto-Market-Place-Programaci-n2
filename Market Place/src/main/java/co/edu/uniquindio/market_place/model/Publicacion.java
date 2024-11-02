package co.edu.uniquindio.market_place.model;

import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private String descripcion;
    private List<Comentario> comentarios;

    public Publicacion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Publicacion(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
