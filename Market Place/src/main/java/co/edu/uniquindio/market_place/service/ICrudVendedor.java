package co.edu.uniquindio.market_place.service;

import co.edu.uniquindio.market_place.model.Usuario;

public interface ICrudVendedor {
    boolean crearVendedor(Usuario newUsuario);
    boolean eliminarVendedor(String cedula);
    boolean actualizarVendedor(String cedula, Usuario usuario);
    Usuario buscarVendedor(String cedula);
    boolean verificarVendedorExistente(String cedula);
}
