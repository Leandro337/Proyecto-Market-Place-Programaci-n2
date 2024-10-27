package co.edu.uniquindio.market_place.model;

import co.edu.uniquindio.market_place.service.IVendedorCRUD;

import java.util.ArrayList;
import java.util.List;

public class MarketPlace implements IVendedorCRUD {
    private List<Vendedor> listaVendedores;

    public MarketPlace(){
        this.listaVendedores = new ArrayList<>();
    }

    @Override
    public boolean crearVendedor(Vendedor newVendedor) {
        if (newVendedor != null) {
            getListaVendedores().add(newVendedor);
            return true;
        }
        return false;
    }


    @Override
    public boolean eliminarVendedor(String cedula) {
        for (Vendedor vendedor : getListaVendedores()) {
            if (vendedor.getCedula().equals(cedula)) {
                getListaVendedores().remove(vendedor);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean actualizarVendedor(String cedula, Vendedor vendedor){
        Vendedor vendedorExistente = buscarVendedor(cedula);
        if (vendedorExistente != null) {
            vendedorExistente.setNombre(vendedor.getNombre());
            vendedorExistente.setApellido(vendedor.getApellido());
            vendedorExistente.setDireccion(vendedor.getDireccion());
            vendedorExistente.setUsuario(vendedor.getUsuario());
            vendedorExistente.setContrasena(vendedor.getContrasena());
            return true;
        }
        return false;
    }


    @Override
    public Vendedor buscarVendedor(String cedula) {
        for(Vendedor vendedor : listaVendedores) {
            if (vendedor.getCedula().equals(cedula)) {
                return vendedor;
            }
        }
        return null;
    }


    @Override
    public boolean verificarVendedorExistente(String cedula){
        Vendedor vendedorExistente = null;
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getCedula().equals(cedula)) {
                vendedorExistente = vendedor;
                break;
            }
        }

        if (vendedorExistente == null) {
            return true;
        }
        return false;
    }

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }
}
