package co.edu.uniquindio.market_place.controller;

import co.edu.uniquindio.market_place.factory.ModelFactory;
import co.edu.uniquindio.market_place.mapping.dto.ProductoDto;
import co.edu.uniquindio.market_place.service.IMisProductosController;

import java.util.List;

public class MisProductosController implements IMisProductosController {
    ModelFactory modelFactory;

    public MisProductosController() {
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public List<ProductoDto> getProductosDto() {
        return modelFactory.getProductosDto();
    }

    @Override
    public boolean agregarProducto(ProductoDto productoDto) {
        return modelFactory.agregarProducto(productoDto);
    }

    @Override
    public boolean actualizarProducto(String nombreActual, ProductoDto productoDto) {
        return modelFactory.actualizarProducto(nombreActual, productoDto);
    }

    @Override
    public boolean eliminarProducto(String nombre) {
        return modelFactory.eliminarProducto(nombre);
    }
}
