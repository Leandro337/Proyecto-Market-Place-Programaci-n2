package co.edu.uniquindio.market_place.factory;

import co.edu.uniquindio.market_place.mapping.dto.ProductoDto;
import co.edu.uniquindio.market_place.mapping.dto.UsuarioDto;
import co.edu.uniquindio.market_place.mapping.mapper.MarketplaceMapping;
import co.edu.uniquindio.market_place.model.MarketPlace;
import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.Usuario;
import co.edu.uniquindio.market_place.service.IModelFactoryService;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory instance;
    MarketPlace marketPlace;
    MarketplaceMapping mapper;

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    private ModelFactory() {
        mapper = new MarketplaceMapping();
        marketPlace = new MarketPlace();

    }

    public MarketPlace getMarketPlace (){
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    @Override
    public List <UsuarioDto> getVendedoresDto(){
        return mapper.getVendedoresDto(getMarketPlace().getListaVendedores());
    }

    @Override
    public List<ProductoDto> getProductosDto(){
        return mapper.getProductosDto(getMarketPlace().getListaProductos());
    }


    @Override
    public boolean agregarVendedor(UsuarioDto usuarioDto) {
        if(getMarketPlace().verificarVendedorExistente(usuarioDto.cedula())){
            Usuario newUsuario = mapper.vendedorDtoToVendedor(usuarioDto);

            getMarketPlace().crearVendedor(newUsuario);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarVendedor(String cedulaActual, UsuarioDto usuarioDto) {
        if(!getMarketPlace().verificarVendedorExistente(cedulaActual)){
            Usuario newUsuario = mapper.vendedorDtoToVendedor(usuarioDto);

            getMarketPlace().actualizarVendedor(cedulaActual, newUsuario);
            return true;
        }
        return false;

    }

    @Override
    public boolean eliminarVendedor(String cedula) {
        return getMarketPlace().eliminarVendedor(cedula);
    }


    @Override
    public boolean agregarProducto(ProductoDto productoDto) {
        if(getMarketPlace().verificarProductoExistente(productoDto.nombre())){
            Producto newProducto = mapper.productoDtoToProducto(productoDto);

            getMarketPlace().crearProducto(newProducto);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarProducto(String nombreActual, ProductoDto productoDto) {
        if(!getMarketPlace().verificarProductoExistente(nombreActual)){
            Producto newProducto = mapper.productoDtoToProducto(productoDto);

            getMarketPlace().actualizarProducto(nombreActual, newProducto);
            return true;
        }
        return false;

    }

    @Override
    public boolean eliminarProducto(String nombre) {
        return getMarketPlace().eliminarProducto(nombre);
    }

    public Usuario iniciarSesion(String usuario, String contrasenia) {
        return marketPlace.iniciarSesion(usuario, contrasenia);
    }
}
