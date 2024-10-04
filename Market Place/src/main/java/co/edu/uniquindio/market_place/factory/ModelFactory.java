package co.edu.uniquindio.market_place.factory;

import co.edu.uniquindio.market_place.mapping.dto.VendedorDTO;
import co.edu.uniquindio.market_place.model.MarketPlace;
import co.edu.uniquindio.market_place.model.Vendedor;
import co.edu.uniquindio.market_place.service.IModelFactoryService;
import co.edu.uniquindio.market_place.service.IVendedorCRUD;

import java.util.ArrayList;
import java.util.List;

public class ModelFactory implements IModelFactoryService {

    private static ModelFactory instance;
    MarketPlace marketPlace;

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public MarketPlace getMarketPlace() {
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    @Override
    public List<VendedorDTO> obtenerVendedores() {
        return List.of();
    }

    @Override
    public boolean agregarVendedor(VendedorDTO vendedorDTO) {
        return false;
    }

    @Override
    public boolean eliminarVendedor(VendedorDTO vendedorDTO) {
        return false;
    }

    @Override
    public boolean actualizarVendedor(String cedula, VendedorDTO vendedorDTO) {
        return false;
    }
}
