package co.edu.uniquindio.market_place.mapping.mapper;

import co.edu.uniquindio.market_place.mapping.dto.ProductoDto;
import co.edu.uniquindio.market_place.mapping.dto.VendedorDto;
import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.Vendedor;
import co.edu.uniquindio.market_place.service.IMarketPlaceMapping;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceMapping implements IMarketPlaceMapping {

    @Override
    public List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores) {
        if(listaVendedores==null){
            return null;
        }

        List<VendedorDto> vendedoresDto = new ArrayList<>();
        for (Vendedor vendedor : listaVendedores) {
            vendedoresDto.add(vendedorToVendedorDto(vendedor));
        }

        return vendedoresDto;
    }

    @Override
    public VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        return new VendedorDto(
                vendedor.getNombre(),
                vendedor.getApellido(),
                vendedor.getCedula(),
                vendedor.getDireccion(),
                vendedor.getUsuario(),
                vendedor.getContrasena());
    }


    @Override
    public Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto) {
        return Vendedor.builder()
                .nombre(vendedorDto.nombre())
                .apellido(vendedorDto.apellido())
                .cedula(vendedorDto.cedula())
                .direccion(vendedorDto.direccion())
                .usuario(vendedorDto.usuario())
                .contrasena(vendedorDto.contrasena())
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
