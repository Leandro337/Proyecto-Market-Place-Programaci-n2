package co.edu.uniquindio.market_place.mapping;

import co.edu.uniquindio.market_place.model.Vendedor;
import co.edu.uniquindio.market_place.model.VendedorDTO;

public class VendedorMapper {

    public static Vendedor fromDTO(VendedorDTO dto) {
        return new Vendedor(dto.getNombre(),dto.getApellido(),dto.getCedula(),dto.getDireccion(),dto.getUsuario(),dto.getContraseña(),dto.getProductos());
    }

    public static VendedorDTO toDTO(Vendedor vendedor) {
        VendedorDTO dto = new VendedorDTO();
        dto.setNombre(vendedor.getNombre());
        dto.setApellido(vendedor.getApellido());
        dto.setCedula(vendedor.getCedula());
        dto.setDireccion(vendedor.getDireccion());
        dto.setUsuario(vendedor.getUsuario());
        dto.setContraseña(vendedor.getContraseña());
        dto.setProductos(vendedor.getProductos());
        return dto;
    }

}
