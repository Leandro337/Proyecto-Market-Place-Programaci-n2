package co.edu.uniquindio.market_place.mapping.mapper;

import co.edu.uniquindio.market_place.mapping.dto.VendedorDto;
import co.edu.uniquindio.market_place.model.Vendedor;
import co.edu.uniquindio.market_place.service.IMarketPlaceMapping;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceMapping implements IMarketPlaceMapping {

    @Override
    public List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores) {
        if(listaVendedores==null){
            return null;
        }

        List<VendedorDto> vendedoresDto = new ArrayList<>();
        for (Vendedor vendedor : listaVendedores) {
            vendedoresDto.add(vendedorToVendedorDto(vendedor));
        }

        return vendedoresDto;
    }

    @Override
    public VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        return new VendedorDto(
                vendedor.getNombre(),
                vendedor.getApellido(),
                vendedor.getCedula(),
                vendedor.getDireccion(),
                vendedor.getUsuario(),
                vendedor.getContrasena());
    }


    @Override
    public Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto) {
        return Vendedor.builder()
                .nombre(vendedorDto.nombre())
                .apellido(vendedorDto.apellido())
                .cedula(vendedorDto.cedula())
                .direccion(vendedorDto.direccion())
                .usuario(vendedorDto.usuario())
                .contrasena(vendedorDto.contrasena())
                .build();
    }

}
