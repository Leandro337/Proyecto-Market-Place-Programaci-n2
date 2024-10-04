package co.edu.uniquindio.market_place.mapping.mapper;

import co.edu.uniquindio.market_place.mapping.dto.VendedorDTO;
import co.edu.uniquindio.market_place.model.Vendedor;

public class VendedorMapper {

    public static Vendedor fromDTO(VendedorDTO dto) {
        return new Vendedor();
    }

    public static VendedorDTO toDTO(Vendedor vendedor) {
        VendedorDTO dto = new VendedorDTO(
                vendedor.getNombre(),
                vendedor.getApellido(),
                vendedor.getCedula(),
                vendedor.getDireccion(),
                vendedor.getUsuario(),
                vendedor.getContraseña(),
                vendedor.getProductos());
        return dto;
    }

}
