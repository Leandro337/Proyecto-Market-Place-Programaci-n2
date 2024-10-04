package co.edu.uniquindio.market_place.model;

import co.edu.uniquindio.market_place.service.IVendedorCRUD;

import java.util.ArrayList;

public class MarketPlace implements IVendedorCRUD {

    @Override
    public boolean crearVendedor(Vendedor vendedor) {
        return false;
    }

    @Override
    public boolean eliminarVendedor(int id) {
        return false;
    }

    @Override
    public boolean actualizarVendedor(String cedula, String nombre, String apellido, int edad) {
        return false;
    }

    @Override
    public Vendedor obtenerVendedor(int cedula) {
        return null;
    }

    @Override
    public ArrayList<Vendedor> listaVendedores() {
        return null;
    }

    @Override
    public boolean verificarVendedor(String cedula) {
        return false;
    }
}
