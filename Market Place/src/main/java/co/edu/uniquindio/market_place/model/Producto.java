package co.edu.uniquindio.market_place.model;

import co.edu.uniquindio.market_place.model.builder.ProductoBuilder;

public class Producto {
    private String nombre;
    private String imagen;
    private double precio;
    private String categoria;
    private EstadoProducto estadoProducto;

    public Producto(String nombre, String imagen, double precio, String categoria, EstadoProducto estadoProducto) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.categoria = categoria;
        this.estadoProducto = estadoProducto;
    }

    public static ProductoBuilder builder() {
        return new ProductoBuilder();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

}
