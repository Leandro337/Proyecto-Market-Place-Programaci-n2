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
    protected String contraseña;
    protected List<Producto> productos;

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

    public VendedorBuilder contraseña (String cedula){
        this.contraseña = contraseña;
        return this;
    }

    public VendedorBuilder productos (Producto productos) {
        this.productos = new ArrayList<Producto>();
        return this;
    }

    public Vendedor build(){
        return new Vendedor(nombre,apellido,cedula,direccion,usuario,contraseña,productos);
    }
}
