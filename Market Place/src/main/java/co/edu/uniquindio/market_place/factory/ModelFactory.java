package co.edu.uniquindio.market_place.factory;

import co.edu.uniquindio.market_place.mapping.dto.ProductoDto;
import co.edu.uniquindio.market_place.mapping.dto.UsuarioDto;
import co.edu.uniquindio.market_place.mapping.mapper.MarketplaceMapping;
import co.edu.uniquindio.market_place.model.MarketPlace;
import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.RollUsuario;
import co.edu.uniquindio.market_place.model.Usuario;
import co.edu.uniquindio.market_place.service.IModelFactoryService;

import java.util.ArrayList;
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

        inicializarDatos();

    }

    private void inicializarDatos() {
        initUsuarios();
    }

    private void initUsuarios() {
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Jhan Carlos");
        usuario1.setApellido("Ocoró");
        usuario1.setCedula("2143532324");
        usuario1.setContrasena("5465546456");
        usuario1.setUsuario("maloh");
        usuario1.setDireccion("Armenia, Quindío");
        usuario1.setRol(RollUsuario.VENDEDOR);
        usuario1.setListaContactos(new ArrayList<>());
        usuario1.setListaProductos(new ArrayList<>());

        marketPlace.getListaVendedores().add(usuario1);


        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Mariana");
        usuario2.setApellido("Ramírez");
        usuario2.setCedula("3158745231");
        usuario2.setContrasena("mariana2023");
        usuario2.setUsuario("mramirez");
        usuario2.setDireccion("Bogotá, Cundinamarca");
        usuario2.setRol(RollUsuario.VENDEDOR);
        usuario2.setListaContactos(new ArrayList<>());
        usuario2.setListaProductos(new ArrayList<>());

        marketPlace.getListaVendedores().add(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.setNombre("Andrés");
        usuario3.setApellido("López");
        usuario3.setCedula("2254789632");
        usuario3.setContrasena("andres123");
        usuario3.setUsuario("alopez");
        usuario3.setDireccion("Medellín, Antioquia");
        usuario3.setRol(RollUsuario.VENDEDOR);
        usuario3.setListaContactos(new ArrayList<>());
        usuario3.setListaProductos(new ArrayList<>());

        marketPlace.getListaVendedores().add(usuario3);

        Usuario usuario4 = new Usuario();
        usuario4.setNombre("Camila");
        usuario4.setApellido("Sánchez");
        usuario4.setCedula("3248596174");
        usuario4.setContrasena("camila456");
        usuario4.setUsuario("csanchez");
        usuario4.setDireccion("Cali, Valle del Cauca");
        usuario4.setRol(RollUsuario.VENDEDOR);
        usuario4.setListaContactos(new ArrayList<>());
        usuario4.setListaProductos(new ArrayList<>());

        marketPlace.getListaVendedores().add(usuario4);

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
