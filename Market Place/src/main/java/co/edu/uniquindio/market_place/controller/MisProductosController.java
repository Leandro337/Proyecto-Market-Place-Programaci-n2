package co.edu.uniquindio.market_place.controller;

import co.edu.uniquindio.market_place.factory.ModelFactory;
import co.edu.uniquindio.market_place.mapping.dto.ProductoDto;
import java.util.List;

public class MisProductosController {
    ModelFactory modelFactory;
    public MisProductosController(){
        modelFactory = ModelFactory.getInstance();
    }
    public List<ProductoDto> obtenerClientes() {
        return modelFactory.obtenerProductos();
    }
}
