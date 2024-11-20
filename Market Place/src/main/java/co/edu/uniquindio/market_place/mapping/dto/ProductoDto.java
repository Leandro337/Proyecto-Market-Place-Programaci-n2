package co.edu.uniquindio.market_place.mapping.dto;

import co.edu.uniquindio.market_place.model.EstadoProducto;

public record ProductoDto (
        String nombre,
        double precio,
        String categoria,
        EstadoProducto estadoProducto){
}
