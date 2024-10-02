package co.edu.uniquindio.market_place.model;

import co.edu.uniquindio.market_place.service.IVendedorCRUD;

import java.util.ArrayList;

public class MarketPlace implements IVendedorCRUD {

    @Override
    public boolean crearVendedor(Vendedor vendedor) {
        return false;
    }

    @Override
    public boolean eliminarVendedor(int id) {
        return false;
    }

    @Override
    public boolean actualizarVendedor(Vendedor vendedor) {
        return false;
    }

    @Override
    public Vendedor getVendedor(int id) {
        return null;
    }

    @Override
    public ArrayList<Vendedor> getAllVendedor() {
        return null;
    }
}
