package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.mapping.dto.ProductoDto;
import co.edu.uniquindio.market_place.mapping.dto.VendedorDto;
import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.Vendedor;

import java.util.List;

public interface IMarketPlaceMapping {

    List<ProductoDto> getProductosDto(List<Producto> listaProductos);
    ProductoDto productoToProductoDto(Producto producto);
    Producto productoDtoToProducto(ProductoDto productoDto);

    List<VendedorDto>getVendedoresDto (List<Vendedor> listaVendedores);
    VendedorDto vendedorToVendedorDto (Vendedor vendedor);
    Vendedor vendedorDtoToVendedor (VendedorDto vendedorDto);
}
