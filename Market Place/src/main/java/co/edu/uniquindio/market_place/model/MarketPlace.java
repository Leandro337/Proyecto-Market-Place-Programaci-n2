package co.edu.uniquindio.market_place.model;

import co.edu.uniquindio.market_place.service.ICrudProducto;
import co.edu.uniquindio.market_place.service.ICrudVendedor;

import java.util.ArrayList;
import java.util.List;

public class MarketPlace implements ICrudProducto, ICrudVendedor {
    private final int claveAdmin = 1030;
    private List<Usuario> listaVendedores;
    private List <Producto> listaProductos;

    public MarketPlace(){
        this.listaVendedores = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
    }

    public int getClaveAdmin() {
        return claveAdmin;
    }

    public void setListaVendedores(List<Usuario> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }




    //------------------------CRUD VENDEDOR------------------------------//

    public List<Usuario> getListaVendedores() {
        return listaVendedores;
    }



    public boolean crearVendedor(Usuario newUsuario) {
        if (newUsuario != null) {
            getListaVendedores().add(newUsuario);
            return true;
        }
        return false;
    }

    public boolean eliminarVendedor(String cedula) {
        for (Usuario usuario : getListaVendedores()) {
            if (usuario.getCedula().equals(cedula)) {
                getListaVendedores().remove(usuario);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarVendedor(String cedula, Usuario usuario){
        Usuario usuarioExistente = buscarVendedor(cedula);
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setApellido(usuario.getApellido());
            usuarioExistente.setDireccion(usuario.getDireccion());
            usuarioExistente.setUsuario(usuario.getUsuario());
            usuarioExistente.setContrasena(usuario.getContrasena());
            return true;
        }
        return false;
    }

    public Usuario buscarVendedor(String cedula) {
        for(Usuario usuario : listaVendedores) {
            if (usuario.getCedula().equals(cedula)) {
                return usuario;
            }
        }
        System.out.println("No se encontro el vendedor");
        return null;
    }


    public boolean verificarVendedorExistente(String cedula){
        Usuario usuarioExistente = null;
        for (Usuario usuario : listaVendedores) {
            if (usuario.getCedula().equals(cedula)) {
                usuarioExistente = usuario;
                break;
            }
        }

        if (usuarioExistente == null) {
            return true;
        }
        return false;
    }



    //------------------------CRUD PRODUCTO------------------------------//

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    public boolean crearProducto(Producto newProducto) {
        if (newProducto != null) {
            getListaProductos().add(newProducto);
            return true;
        }
        return false;
    }

    public boolean eliminarProducto(String nombre) {
        for (Producto producto : getListaProductos()) {
            if (producto.getNombre().equals(nombre)) {
                getListaProductos().remove(producto);
                return true;
            }
        }
        return false;
    }

    public boolean actualizarProducto(String nombre, Producto producto) {
        Producto productoExistente = buscarProducto(nombre);
        if (productoExistente != null) {
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setImagen(producto.getImagen());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setCategoria(producto.getCategoria());
            productoExistente.setEstadoProducto(producto.getEstadoProducto());
            return true;
        }
        return false;
    }

    public Producto buscarProducto(String nombre) {
        for(Producto producto : listaProductos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        System.out.println("No se encontro el vendedor");
        return null;
    }


    public boolean verificarProductoExistente(String nombre){
        Producto productoExistente = null;
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equals(nombre)) {
                productoExistente = producto;
                break;
            }
        }

        if (productoExistente == null) {
            return true;
        }
        return false;
    }

    public Usuario iniciarSesion(String usuario, String contrasenia) {
        for (Usuario usuarioExistente : getListaVendedores()) {
            if (usuarioExistente.getUsuario().equals(usuario) && usuarioExistente.getContrasena().equals(contrasenia)) {
                return usuarioExistente;
            }
        }
        return null;
    }
}
