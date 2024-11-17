package co.edu.uniquindio.market_place.model;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario{
    private static List<Vendedor> listaVendedores = new ArrayList<>();

    public Vendedor (String nombre, String apellido, String cedula, String direccion, String usuario, String contrasena) {
        super (nombre, apellido, cedula, direccion, usuario, contrasena);
        listaVendedores.add(this);
    }

    public static List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public static void setListaVendedores(List<Vendedor> listaVendedores) {
        Vendedor.listaVendedores = listaVendedores;
    }
}
