package co.edu.uniquindio.market_place.controller;

import co.edu.uniquindio.market_place.factory.ModelFactory;
import co.edu.uniquindio.market_place.model.Usuario;

public class IniciarSesionController {

    ModelFactory modelFactory;

    public IniciarSesionController() {
        modelFactory = ModelFactory.getInstance();
    }

    public Usuario iniciarSesion(String usuario, String contrasenia) {
        return modelFactory.iniciarSesion(usuario, contrasenia);
    }
}
