package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.mapping.dto.ProductoDto;
import co.edu.uniquindio.market_place.mapping.dto.UsuarioDto;

import java.util.List;

public interface IModelFactoryService{

    List<UsuarioDto> getVendedoresDto();
    boolean agregarVendedor(UsuarioDto vendedor);
    boolean eliminarVendedor(String cedula);
    boolean actualizarVendedor(String cedulaActual, UsuarioDto vendedor);

    List<ProductoDto> getProductosDto();
    boolean agregarProducto(ProductoDto producto);
    boolean eliminarProducto(String nombre);
    boolean actualizarProducto(String nombreActual, ProductoDto producto);
}