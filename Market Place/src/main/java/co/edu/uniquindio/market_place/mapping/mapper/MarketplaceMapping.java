package co.edu.uniquindio.market_place.mapping.mapper;

import co.edu.uniquindio.market_place.mapping.dto.ProductoDto;
import co.edu.uniquindio.market_place.mapping.dto.UsuarioDto;
import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.Usuario;
import co.edu.uniquindio.market_place.service.IMarketPlaceMapping;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceMapping implements IMarketPlaceMapping {

    @Override
    public List<UsuarioDto> getVendedoresDto(List<Usuario> listaVendedores) {
        if(listaVendedores==null){
            return null;
        }

        List<UsuarioDto> vendedoresDto = new ArrayList<>();
        for (Usuario usuario : listaVendedores) {
            vendedoresDto.add(vendedorToVendedorDto(usuario));
        }

        return vendedoresDto;
    }

    @Override
    public UsuarioDto vendedorToVendedorDto(Usuario usuario) {
        return new UsuarioDto(
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getCedula(),
                usuario.getDireccion(),
                usuario.getUsuario(),
                usuario.getContrasena());
    }


    @Override
    public Usuario vendedorDtoToVendedor(UsuarioDto usuarioDto) {
        return Usuario.builder()
                .nombre(usuarioDto.nombre())
                .apellido(usuarioDto.apellido())
                .cedula(usuarioDto.cedula())
                .direccion(usuarioDto.direccion())
                .usuario(usuarioDto.usuario())
                .contrasena(usuarioDto.contrasena())
                .build();
    }


    @Override
    public List<ProductoDto> getProductosDto(List<Producto> listaProductos) {
        if(listaProductos==null){
            return null;
        }

        List<ProductoDto> productosDto = new ArrayList<>();
        for (Producto producto : listaProductos) {
            productosDto.add(productoToProductoDto(producto));
        }

        return productosDto;
    }

    @Override
    public ProductoDto productoToProductoDto(Producto producto) {
        return new ProductoDto(
                producto.getNombre(),
                producto.getImagen(),
                producto.getPrecio(),
                producto.getCategoria());
    }


    @Override
    public Producto productoDtoToProducto(ProductoDto productoDto) {
        return Producto.builder()
                .nombre(productoDto.nombre())
                .imagen(productoDto.imagen())
                .precio(productoDto.precio())
                .categoria(productoDto.categoria())
                .build();
    }

}
