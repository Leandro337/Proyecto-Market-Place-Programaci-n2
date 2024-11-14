package co.edu.uniquindio.market_place.controller;

import co.edu.uniquindio.market_place.model.Usuario;
import co.edu.uniquindio.market_place.service.IIniciarSesionController;

import java.util.ArrayList;
import java.util.List;

public class IniciarSesionController implements IIniciarSesionController {
    private static List<Usuario> usuariosRegistrados = new ArrayList<>();

    public static void registrarUsuario(Usuario usuario) {
        usuariosRegistrados.add(usuario);
    }

    public Usuario iniciarSesion(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuariosRegistrados) {
            if (usuario.getUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return usuario; // Retorna el usuario si coincide
            }
        }
        return null; // Retorna null si no encuentra coincidencias
    }
}