package co.edu.uniquindio.market_place.model;

import java.util.ArrayList;
import java.util.List;

public class Muro {
    private List<Chat> chats;
    private List<Publicacion> publicaciones;

    public Muro() {
        this.chats = new ArrayList<Chat>();
        this.publicaciones = new ArrayList<>();
    }

    public List<Chat> getChats() {
        return chats;
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
}
