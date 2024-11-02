package co.edu.uniquindio.market_place.viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrarViewController {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField apellidoField;

    @FXML
    private TextField cedulaField;

    @FXML
    private TextField direccionField;

    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField contrasenaField;

    @FXML
    private PasswordField claveAdminField;

    @FXML
    private Button registrarUsuarioButton;

    @FXML
    private Button registrarAdminButton;

    // Método que se ejecuta al hacer clic en el botón "Registrar usuario"
    @FXML
    private void handleRegistrarUsuario() {
        String nombre = nombreField.getText();
        String apellido = apellidoField.getText();
        String cedula = cedulaField.getText();
        String direccion = direccionField.getText();
        String usuario = usuarioField.getText();
        String contrasena = contrasenaField.getText();

        // Lógica para registrar el usuario
        System.out.println("Usuario registrado: " + nombre + " " + apellido);
    }

    // Método que se ejecuta al hacer clic en el botón "Registrar Admin"
    @FXML
    private void handleRegistrarAdmin() {
        String claveAdmin = claveAdminField.getText();
        // Lógica para registrar el administrador
        System.out.println("Administrador registrado.");
    }
}

