package co.edu.uniquindio.market_place.mapping.dto;

import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.RollUsuario;

import java.util.List;

public record VendedorDto(
        String nombre,
        String apellido,
        String cedula,
        String direccion,
        String usuario,
        String contrasena){
}
