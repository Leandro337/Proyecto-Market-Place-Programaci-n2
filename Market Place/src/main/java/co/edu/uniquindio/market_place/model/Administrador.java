package co.edu.uniquindio.market_place.model;

public class Administrador extends Usuario{
    private String claveAdmin;

    public Administrador(String nombre, String apellido, String cedula, String direccion, String usuario, String contrasena, String claveAdmin) {
        super (nombre, apellido, cedula, direccion, usuario, contrasena);
        this.claveAdmin = claveAdmin;
    }

    public String getClaveAdmin() {
        return claveAdmin;
    }

    public void setClaveAdmin(String claveAdmin) {
        this.claveAdmin = claveAdmin;
    }
}
