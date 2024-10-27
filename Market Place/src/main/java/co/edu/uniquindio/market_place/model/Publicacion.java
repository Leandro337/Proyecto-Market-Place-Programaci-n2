package co.edu.uniquindio.market_place.model;

import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private List<Comentario> comentarios;

    public Publicacion() {
        comentarios = new ArrayList<Comentario>();
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
