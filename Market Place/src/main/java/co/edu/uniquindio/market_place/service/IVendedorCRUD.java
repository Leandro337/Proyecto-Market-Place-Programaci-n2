package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.model.RollUsuario;
import co.edu.uniquindio.market_place.model.Vendedor;

import java.util.ArrayList;
import java.util.List;

public interface IVendedorCRUD {

    boolean crearVendedor(Vendedor newVendedor);
    boolean eliminarVendedor(int cedula);
    boolean actualizarVendedor(String cedula, String nombre, String apellido, int edad);

    boolean crearVendedor(String cedula, String nombre, String apellido, String direccion, String usuario, String contraseña);

    boolean crearVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña, RollUsuario rol);

    boolean eliminarVendedor(String cedula);

    boolean actualizarVendedor(String nombre, String apellido, String direccion, String usuario, String contraseña);

    boolean actualizarVendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña, RollUsuario rol);

    String obtenerVendedor(int cedula);
    ArrayList<Vendedor> listaVendedores();

    boolean verificarVendedorExistente(String cedula);

    Vendedor verificarVendedor(String cedula);

    List<Vendedor> getListaVendedores();
}
