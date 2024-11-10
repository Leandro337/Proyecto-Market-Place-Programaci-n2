package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.mapping.dto.ProductoDto;

import java.util.List;

public interface IMisProductosController {

    List<ProductoDto> getProductosDto();
    boolean agregarProducto(ProductoDto producto);
    boolean actualizarProducto(String nombreActual, ProductoDto producto);
    boolean eliminarProducto(String nombre);
}
