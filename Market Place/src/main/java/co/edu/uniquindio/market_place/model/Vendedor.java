package co.edu.uniquindio.market_place.model;

import co.edu.uniquindio.market_place.service.IVendedorCRUD;

import java.util.ArrayList;
import java.util.List;

public class Vendedor implements IVendedorCRUD {

    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String usuario;
    private String contraseña;
    private List<Producto> productos;

    public Vendedor() {
    }

    public Vendedor(String nombre, String apellido, String cedula, String direccion, String usuario, String contraseña, List<Producto> productos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", productos=" + productos +
                '}';
    }

    @Override
    public boolean crearVendedor(Vendedor vendedor) {
        return false;
    }

    @Override
    public boolean eliminarVendedor(int id) {
        return false;
    }

    @Override
    public boolean actualizarVendedor(Vendedor vendedor) {
        return false;
    }

    @Override
    public Vendedor getVendedor(int id) {
        return null;
    }

    @Override
    public ArrayList<Vendedor> getAllVendedor() {
        return null;
    }
}
