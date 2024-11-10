package co.edu.uniquindio.market_place.controller;

import co.edu.uniquindio.market_place.factory.ModelFactory;
import co.edu.uniquindio.market_place.mapping.dto.UsuarioDto;
import co.edu.uniquindio.market_place.service.IPerfilVendedoresController;

import java.util.List;

public class PerfilVendedoresController implements IPerfilVendedoresController {
    ModelFactory modelFactory;

    public PerfilVendedoresController() {
    modelFactory = ModelFactory.getInstance();
    }

    @Override
    public List<UsuarioDto> getVendedoresDto() {
        return modelFactory.getVendedoresDto();
    }

    @Override
    public boolean agregarVendedor(UsuarioDto usuarioDto) {
        return modelFactory.agregarVendedor(usuarioDto);
    }

    @Override
    public boolean actualizarVendedor(String cedulaActual, UsuarioDto usuarioDto) {
        return modelFactory.actualizarVendedor(cedulaActual, usuarioDto);
    }

    @Override
    public boolean eliminarVendedor(String cedula) {
        return modelFactory.eliminarVendedor(cedula);
    }
}
