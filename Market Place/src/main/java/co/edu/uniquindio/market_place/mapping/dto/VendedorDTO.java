package co.edu.uniquindio.market_place.mapping.dto;

import co.edu.uniquindio.market_place.model.Producto;

import java.util.List;

public record VendedorDTO (
        String nombre,
        String apellido,
        String cedula,
        String direccion,
        String usuario,
        String contraseña,
        List<Producto> productos){
}
