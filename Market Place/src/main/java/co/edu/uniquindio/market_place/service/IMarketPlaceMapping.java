package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.mapping.dto.ProductoDto;
import co.edu.uniquindio.market_place.mapping.dto.UsuarioDto;
import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.Usuario;

import java.util.List;

public interface IMarketPlaceMapping {

    List<ProductoDto> getProductosDto(List<Producto> listaProductos);
    ProductoDto productoToProductoDto(Producto producto);
    Producto productoDtoToProducto(ProductoDto productoDto);

    List<UsuarioDto>getVendedoresDto (List<Usuario> listaVendedores);
    UsuarioDto vendedorToVendedorDto (Usuario usuario);
    Usuario vendedorDtoToVendedor (UsuarioDto usuarioDto);

}
