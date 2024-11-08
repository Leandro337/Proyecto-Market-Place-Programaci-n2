package co.edu.uniquindio.market_place.model.builder;

import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.Vendedor;

import java.util.ArrayList;
import java.util.List;

public class VendedorBuilder {

    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String direccion;
    protected String usuario;
    protected String contrasena;
    protected List<Producto> listaProductos;
    protected List<Vendedor> listaContactos;

    public VendedorBuilder nombre (String nombre) {
        this.nombre = nombre;
        return this;
    }

    public VendedorBuilder apellido (String apellido) {
        this.apellido = apellido;
        return this;
    }

    public VendedorBuilder cedula (String cedula) {
        this.cedula = cedula;
        return this;
    }

    public VendedorBuilder direccion (String direccion) {
        this.direccion = direccion;
        return this;
    }

    public VendedorBuilder usuario (String usuario) {
        this.usuario = usuario;
        return this;
    }

    public VendedorBuilder contrasena (String contrasena){
        this.contrasena = contrasena;
        return this;
    }


    public VendedorBuilder listaProductos (Producto listaProductos) {
        this.listaProductos = new ArrayList<Producto>();
        return this;
    }

    public VendedorBuilder listaContactos (Vendedor listaContactos) {
        this.listaContactos = new ArrayList<Vendedor>();
        return this;
    }

    public Vendedor build(){
        return new Vendedor(nombre,apellido,cedula,direccion,usuario,contrasena);
    }
}
