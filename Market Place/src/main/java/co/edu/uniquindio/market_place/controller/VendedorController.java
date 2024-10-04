package co.edu.uniquindio.market_place.controller;

import co.edu.uniquindio.market_place.factory.ModelFactory;
import co.edu.uniquindio.market_place.mapping.dto.VendedorDTO;
import co.edu.uniquindio.market_place.model.Vendedor;
import co.edu.uniquindio.market_place.service.IControllerVendedor;

import java.util.List;

public class VendedorController implements IControllerVendedor {
    ModelFactory modelFactory;

    public VendedorController() {
        modelFactory = new ModelFactory();
    }

    public List<VendedorDTO> obtenerVendedores() {
        return modelFactory.obtenerVendedores();
    }

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
    public boolean actualizarVendedor(String cedula, Vendedor vendedor) {
        return false;
    }
}
