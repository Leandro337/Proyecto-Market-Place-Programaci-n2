package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.model.Vendedor;

import java.util.ArrayList;

public interface IVendedorCRUD {

    boolean crearVendedor(Vendedor newVendedor);
    boolean eliminarVendedor(int cedula);
    boolean actualizarVendedor(String cedula, String nombre, String apellido, int edad);
    Vendedor obtenerVendedor(int cedula);
    ArrayList<Vendedor> listaVendedores();
    boolean verificarVendedor(String cedula);

}
