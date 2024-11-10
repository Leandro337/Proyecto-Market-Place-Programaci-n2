package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.model.Vendedor;

import java.util.List;

public interface IPerfilVendedoresController {

    List<Vendedor> getVendedors();
    boolean agregarVendedor(Vendedor vendedor);
    boolean actualizarVendedor(Vendedor vendedor);
    boolean eliminarVendedor(Vendedor vendedor);

}
