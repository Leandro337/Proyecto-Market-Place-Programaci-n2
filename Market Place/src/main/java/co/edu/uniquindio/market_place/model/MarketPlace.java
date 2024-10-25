package co.edu.uniquindio.market_place.model;

import co.edu.uniquindio.market_place.service.IVendedorCRUD;

import java.util.ArrayList;

public class MarketPlace implements IVendedorCRUD {
    private List<Vendedor> listaVendedores;

    public MarketPlace(){
        this.listaVendedores = new ArrayList<>();
    }

    @Override
    public boolean crearVendedor(String cedula, String nombre, String apellido, String direccion, String usuario, String contraseña) {
        Vendedor vendedorEncontrado = verificarVendedor(cedula);

        if (vendedorEncontrado == null) {
            Vendedor vendedor = Vendededor.builder()
                    .nombre(nombre)
                    .cedula(cedula)
                    .apellido(apellido)
                    .usuario(usuario)
                    .contraseña(contraseña)
                    .direccion(direccion)
                    .build();

            getListVendedores().add(vendedor);

            return true;
        }
        return false;
    }


    @Override
    public boolean eliminarVendedor(String cedula) {
        Vendedor vendedorEncontrado = verificarVendedor(cedula);
        if (vendedorEncontrado != null) {
            getListaVendedores().remove(vendedorEncontrado);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarVendedor (String nombre, String apellido, String direccion, String usuario, String contraseña){
        Vendedor vendedorEncontrado = verificarVendedor(cedula);
        if (vendedorEncontrado != null) {
            vendedorEncontrado.setNombre(nombre);
            vendedorEncontrado.setApellido(apellido);
            vendedorEncontrado.setDireccion(direccion);
            vendedorEncontrado.setUsuario(usuario);
            vendedorEncontrado.setContraseña(contraseña);
            return true;
        }
        return false;
    }


    @Override
    public Vendedor obtenerVendedor(int cedula) {
        for(Vendedor vendedor : listaVendedores) {
            if (vendedor.getCedula().equels(cedula)) {
                return vendedor.getNombre();
            }
        }
    }


    @Override
    public boolean verificarVendedorExistente (String cedula){
        if (verificarVendedor(cedula) == null){
            return true;
        }
        return false;
    }

    public Vendedor verificarVendedor(String cedula) {
        Vendedor vendedorExistente = null;

        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getCedula().equals(cedula)) {
                vendedorExistente = vendedor;
                break;
            }
        }
        return vendedorExistente;
    }

    @Override
    public List<Vendedor> listaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }
}
