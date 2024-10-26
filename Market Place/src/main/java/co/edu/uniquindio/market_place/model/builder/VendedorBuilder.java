package co.edu.uniquindio.market_place.model.builder;

import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.RollUsuario;
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
    protected RollUsuario rol;
    protected List<Producto> listaProductos;

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

    public VendedorBuilder rol (RollUsuario rol){
        this.rol = rol;
        return this;
    }

    public VendedorBuilder listaProductos (Producto listaProductos) {
        this.listaProductos = new ArrayList<Producto>();
        return this;
    }

    public Vendedor build(){
        return new Vendedor(nombre,apellido,cedula,direccion,usuario,contraseña,rol);
    }
}
