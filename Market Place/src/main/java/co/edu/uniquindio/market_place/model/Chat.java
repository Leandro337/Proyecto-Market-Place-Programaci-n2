package co.edu.uniquindio.market_place.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {

    private List<Mensaje> mensajes;

    public Chat() {
    }

    public Chat(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }
}
