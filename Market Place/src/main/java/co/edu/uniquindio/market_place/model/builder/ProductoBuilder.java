package co.edu.uniquindio.market_place.model.builder;

import co.edu.uniquindio.market_place.model.EstadoProducto;
import co.edu.uniquindio.market_place.model.Producto;

public class ProductoBuilder {
    protected String nombre;
    protected double precio;
    protected String categoria;
    protected EstadoProducto estadoProducto;

    public ProductoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoBuilder precio(double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoBuilder categoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public ProductoBuilder estadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
        return this;
    }

    public Producto build() {
        return new Producto(nombre, precio, categoria,estadoProducto);
    }
}
