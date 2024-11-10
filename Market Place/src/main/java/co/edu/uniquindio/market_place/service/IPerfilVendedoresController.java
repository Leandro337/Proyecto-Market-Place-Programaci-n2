package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.mapping.dto.UsuarioDto;

import java.util.List;

public interface IPerfilVendedoresController {

    List<UsuarioDto> getVendedoresDto();
    boolean agregarVendedor(UsuarioDto vendedor);
    boolean actualizarVendedor(String nombreActual, UsuarioDto vendedor);
    boolean eliminarVendedor(String nombre);

}
