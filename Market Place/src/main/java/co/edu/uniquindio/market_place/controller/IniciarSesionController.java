package co.edu.uniquindio.market_place.controller;

import co.edu.uniquindio.market_place.model.Usuario;
import co.edu.uniquindio.market_place.service.IIniciarSesionController;

import java.util.ArrayList;
import java.util.List;

public class IniciarSesionController implements IIniciarSesionController {
    private static List<Usuario> usuariosVendedores = new ArrayList<>();
    private static List<Usuario> usuariosAdministradores = new ArrayList<>();
    private static final String CLAVE_ADMIN = "123";

    // Método para registrar un vendedor
    public static void registrarVendedor(Usuario vendedor) {
        usuariosVendedores.add(vendedor);
    }

    // Método para registrar un administrador
    public static void registrarAdministrador(Usuario administrador) {
        usuariosAdministradores.add(administrador);
    }

    // Método para iniciar sesión, diferenciando por tipo de usuario
    public Usuario iniciarSesion(String nombreUsuario, String contrasena) {
        return buscarUsuario(nombreUsuario, contrasena);
    }

    // Método para buscar el usuario en las listas correspondientes
    private Usuario buscarUsuario(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuariosVendedores) {
            if (usuario.getUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        for (Usuario usuario : usuariosAdministradores) {
            if (usuario.getUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    public static boolean verificarClaveAdmin(String clave) {
        return CLAVE_ADMIN.equals(clave);
    }
}

