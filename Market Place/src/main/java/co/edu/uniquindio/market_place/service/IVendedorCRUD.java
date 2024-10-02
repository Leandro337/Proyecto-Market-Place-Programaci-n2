package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.model.Vendedor;

import java.util.ArrayList;

public interface IVendedorCRUD {

    boolean crearVendedor(Vendedor vendedor);
    boolean eliminarVendedor(int id);
    boolean actualizarVendedor(Vendedor vendedor);
    Vendedor getVendedor(int id);
    ArrayList<Vendedor> getAllVendedor();

}
