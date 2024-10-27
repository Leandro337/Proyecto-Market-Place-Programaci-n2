package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.model.Vendedor;

public interface IVendedorCRUD {

    boolean crearVendedor(Vendedor newVendedor);

    boolean eliminarVendedor(String cedula);

    boolean actualizarVendedor(String cedula, Vendedor vendedor);

    Vendedor buscarVendedor(String cedula);

    boolean verificarVendedorExistente(String cedula);
}
