package co.edu.uniquindio.market_place.model;

public enum EstadoProducto {
    VENDIDO("Disponible"),
    PUBLICADO("No disponible"),
    CANCELADO("Vendido");

    private final String descripcion;

    EstadoProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
