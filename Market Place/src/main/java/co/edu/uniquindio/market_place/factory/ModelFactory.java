package co.edu.uniquindio.market_place.factory;

import co.edu.uniquindio.market_place.mapping.dto.VendedorDto;
import co.edu.uniquindio.market_place.mapping.mapper.MarketplaceMapping;
import co.edu.uniquindio.market_place.model.MarketPlace;
import co.edu.uniquindio.market_place.model.Vendedor;
import co.edu.uniquindio.market_place.service.IModelFactoryService;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory instance;
    MarketPlace marketPlace;
    MarketplaceMapping mapper;

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    private ModelFactory() {
        mapper = new MarketplaceMapping();
    ///    marketPlace = inicializarDatos();

    }

    public MarketPlace getMarketPlace (){
        return marketPlace;
    }

    public void setMarketPlace(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    @Override
    public List <VendedorDto> getVendedoresDto(){
        return mapper.getVendedoresDto(getMarketPlace().getListaVendedores());
    }


    @Override
    public boolean agregarVendedor(VendedorDto vendedorDto) {
        if(getMarketPlace().verificarVendedorExistente(vendedorDto.cedula())){
            Vendedor newVendedor = mapper.vendedorDtoToVendedor(vendedorDto);

            getMarketPlace().crearVendedor(newVendedor);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarVendedor(String cedulaActual, VendedorDto vendedorDto) {
        if(!getMarketPlace().verificarVendedorExistente(cedulaActual)){
            Vendedor newVendedor = mapper.vendedorDtoToVendedor(vendedorDto);

            getMarketPlace().actualizarVendedor(cedulaActual, newVendedor);
            return true;
        }
        return false;

    }

    @Override
    public boolean eliminarVendedor(String cedula) {
        return getMarketPlace().eliminarVendedor(cedula);
    }



///    public static MarketPlace inicializarDatos(){
///         MarketPlace marketPlace = new MarketPlace();
/////         Hacer           ////
///     }

}
