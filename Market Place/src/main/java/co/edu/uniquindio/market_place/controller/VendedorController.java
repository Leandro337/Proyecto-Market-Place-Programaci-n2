package co.edu.uniquindio.market_place.controller;

import co.edu.uniquindio.market_place.factory.ModelFactory;
import co.edu.uniquindio.market_place.mapping.dto.VendedorDto;
import co.edu.uniquindio.market_place.model.Vendedor;
import co.edu.uniquindio.market_place.service.IVendedorControllerService;

import java.util.List;

public class VendedorController implements IVendedorControllerService {
    ModelFactory modelFactory;

    public VendedorController() {
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public List <VendedorDto> getVendedoresDto(){
    return modelFactory.getVendedoresDto();
    }

    @Override
    public boolean agregarVendedor(VendedorDto vendedorDto) {
        return modelFactory.agregarVendedor(vendedorDto);
    }

    @Override
    public boolean eliminarVendedor(String cedula) {
        return modelFactory.eliminarVendedor(cedula);
    }

    @Override
    public boolean actualizarVendedor(String cedulaActual, VendedorDto vendedorDto) {
        return modelFactory.actualizarVendedor(cedulaActual, vendedorDto);
    }
}
