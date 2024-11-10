package co.edu.uniquindio.market_place.model.builder;

import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioBuilder {

    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String direccion;
    protected String usuario;
    protected String contrasena;
    protected List<Producto> listaProductos;
    protected List<Usuario> listaContactos;

    public UsuarioBuilder nombre (String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioBuilder apellido (String apellido) {
        this.apellido = apellido;
        return this;
    }

    public UsuarioBuilder cedula (String cedula) {
        this.cedula = cedula;
        return this;
    }

    public UsuarioBuilder direccion (String direccion) {
        this.direccion = direccion;
        return this;
    }

    public UsuarioBuilder usuario (String usuario) {
        this.usuario = usuario;
        return this;
    }

    public UsuarioBuilder contrasena (String contrasena){
        this.contrasena = contrasena;
        return this;
    }


    public UsuarioBuilder listaProductos (Producto listaProductos) {
        this.listaProductos = new ArrayList<Producto>();
        return this;
    }

    public UsuarioBuilder listaContactos (Usuario listaContactos) {
        this.listaContactos = new ArrayList<Usuario>();
        return this;
    }

    public Usuario build(){
        return new Usuario(nombre,apellido,cedula,direccion,usuario,contrasena);
    }
}
