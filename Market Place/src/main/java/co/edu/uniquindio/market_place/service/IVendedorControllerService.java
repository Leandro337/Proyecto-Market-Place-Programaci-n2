package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.mapping.dto.VendedorDto;

import java.util.List;

public interface IVendedorControllerService {
    List<VendedorDto> getVendedoresDto();
    boolean agregarVendedor(VendedorDto vendedor);
    boolean eliminarVendedor(String cedula);
    boolean actualizarVendedor(String cedulaActual, VendedorDto vendedor);
}
