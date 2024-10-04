package co.edu.uniquindio.market_place.controller;

import co.edu.uniquindio.market_place.model.Vendedor;
import co.edu.uniquindio.market_place.service.IControllerVendedor;

import java.util.List;

public class VendedorController implements IControllerVendedor {


    @Override
    public List<Vendedor> obtenerVendedor() {
        return List.of();
    }

    @Override
    public boolean agregarVendedor(Vendedor vendedor) {
        return false;
    }

    @Override
    public boolean eliminarVendedor(Vendedor vendedor) {
        return false;
    }

    @Override
    public boolean actualizarVendedor(String cedula) {
        return false;
    }
}
