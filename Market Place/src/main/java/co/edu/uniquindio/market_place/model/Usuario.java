package co.edu.uniquindio.market_place.model;

import co.edu.uniquindio.market_place.model.builder.UsuarioBuilder;

import java.util.List;

public class Usuario {

    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String usuario;
    private String contrasena;
    private RollUsuario rol;
    private List<Producto> listaProductos;
    private List<Usuario> listaContactos;


    public Usuario(String nombre, String apellido, String cedula, String direccion, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public RollUsuario getRol() {
        return rol;
    }

    public void setRol(RollUsuario rol) {
        this.rol = rol;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Usuario> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(List<Usuario> listaContactos) {
        this.listaContactos = listaContactos;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contrasena + '\'' +
                ", rol= '" + rol + '\'' +
                ", productos=" + listaProductos +
                '}';
    }
}
