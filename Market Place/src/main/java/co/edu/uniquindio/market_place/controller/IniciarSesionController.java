package co.edu.uniquindio.market_place.controller;

import co.edu.uniquindio.market_place.model.Usuario;
import co.edu.uniquindio.market_place.service.Observer;

import java.util.ArrayList;
import java.util.List;

public class IniciarSesionController {
    private static List<Usuario> usuariosVendedores = new ArrayList<>();
    private static List<Usuario> usuariosAdministradores = new ArrayList<>();
    private static final String CLAVE_ADMIN = "123";
    private static List<Observer> observers = new ArrayList<>();  // Lista de observadores

    // Método para registrar un observador
    public static void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Método para eliminar un observador
    public static void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Método para notificar a todos los observadores
    private static void notifyObservers() {
        for (Observer observer : observers) {
            observer.actualizarContactosSugeridos();
        }
    }

    // Método para registrar un vendedor
    public static void registrarVendedor(Usuario vendedor) {
        usuariosVendedores.add(vendedor);
        notifyObservers();  // Notificar a los observadores cuando un nuevo vendedor es registrado
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

