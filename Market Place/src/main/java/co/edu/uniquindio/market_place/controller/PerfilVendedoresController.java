package co.edu.uniquindio.market_place.controller;

import co.edu.uniquindio.market_place.factory.ModelFactory;
import co.edu.uniquindio.market_place.mapping.dto.VendedorDto;
import co.edu.uniquindio.market_place.model.Vendedor;
import co.edu.uniquindio.market_place.service.IPerfilVendedoresController;

import java.util.List;

public class PerfilVendedoresController implements IPerfilVendedoresController {

    private ModelFactory modelFactory = ModelFactory.getInstance();

    @Override
    public List<Vendedor> getVendedors() {
        return List.of();
    }

    @Override
    public boolean agregarVendedor(Vendedor vendedor) {
        return false;
    }

    @Override
    public boolean actualizarVendedor(Vendedor vendedor) {
        return false;
    }

    @Override
    public boolean eliminarVendedor(Vendedor vendedor) {
        return false;
    }
}
