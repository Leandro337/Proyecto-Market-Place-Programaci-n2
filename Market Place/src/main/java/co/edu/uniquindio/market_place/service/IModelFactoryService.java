package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.mapping.dto.VendedorDTO;

import java.util.List;

public interface IModelFactoryService{
    List<VendedorDTO> obtenerVendedores();
    boolean agregarVendedor(VendedorDTO vendedorDTO);
    boolean eliminarVendedor(VendedorDTO vendedorDTO);
    boolean actualizarVendedor(String cedula, VendedorDTO vendedorDTO);
}
