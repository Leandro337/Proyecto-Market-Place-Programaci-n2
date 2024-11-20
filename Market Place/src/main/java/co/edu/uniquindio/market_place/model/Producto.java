package co.edu.uniquindio.market_place.model;

import co.edu.uniquindio.market_place.model.builder.ProductoBuilder;

public class Producto {
    private String nombre;
    private double precio;
    private String categoria;
    private EstadoProducto estadoProducto;

    public Producto(String nombre, double precio, String categoria, EstadoProducto estadoProducto) {
        this.nombre = nombre;
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
