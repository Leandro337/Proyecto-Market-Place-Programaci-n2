package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.model.Vendedor;

import java.util.List;

public interface IControllerVendedor {

    List<Vendedor> obtenerVendedor();
    boolean agregarVendedor(Vendedor vendedor);
    boolean eliminarVendedor(Vendedor vendedor);
    boolean actualizarVendedor(String cedula);
}
