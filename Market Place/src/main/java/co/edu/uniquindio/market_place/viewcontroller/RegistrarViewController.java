package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.model.Usuario;
import co.edu.uniquindio.market_place.model.RollUsuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

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
    private Button registrarVendedorButton;

    @FXML
    private Button registrarAdminButton;

    @FXML
    public void initialize() {
        // initView();
    }

    @FXML
    private void botonRegistrarVendedor(ActionEvent event) {
        if (camposLlenos(false)) { // Llamada a validar que los campos estén llenos
            Usuario nuevoVendedor = crearUsuario(RollUsuario.VENDEDOR); // Crea usuario como vendedor
            System.out.println("Usuario registrado como vendedor: " + nuevoVendedor);
            abrirVentanaIniciarSesion(); // Abre la ventana de login
        } else {
            System.out.println("Por favor, complete todos los campos para registrar el usuario.");
        }
    }

    @FXML
    private void botonRegistrarAdmin(ActionEvent event) {
        if (camposLlenos(true)) { // Llamada a validar con clave de admin incluida
            Usuario nuevoAdmin = crearUsuario(RollUsuario.ADMINISTRADOR); // Crea usuario como administrador
            System.out.println("Usuario registrado como administrador: " + nuevoAdmin);
            abrirVentanaIniciarSesion(); // Abre la ventana de login
        } else {
            System.out.println("Por favor, complete todos los campos para registrar al administrador.");
        }
    }

    private boolean camposLlenos(boolean esAdmin) {
        // Validación de campos comunes
        boolean camposComunes = !nombreField.getText().isEmpty() && !apellidoField.getText().isEmpty() &&
                !cedulaField.getText().isEmpty() && !direccionField.getText().isEmpty() &&
                !usuarioField.getText().isEmpty() && !contrasenaField.getText().isEmpty();

        if (esAdmin) {
            return camposComunes && !claveAdminField.getText().isEmpty(); // Incluye la clave de admin en la validación
        }
        return camposComunes;
    }

    private Usuario crearUsuario(RollUsuario rol) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombreField.getText());
        nuevoUsuario.setApellido(apellidoField.getText());
        nuevoUsuario.setCedula(cedulaField.getText());
        nuevoUsuario.setDireccion(direccionField.getText());
        nuevoUsuario.setUsuario(usuarioField.getText());
        nuevoUsuario.setContrasena(contrasenaField.getText());
        nuevoUsuario.setRol(rol);
        return nuevoUsuario;
    }

    private void abrirVentanaIniciarSesion() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/market_place/IniciarSesion.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Iniciar Sesion");
            stage.setScene(new Scene(root));
            stage.show();

            // Cerrar la ventana actual después de abrir el iniciar sesion
            Stage currentStage = (Stage) registrarVendedorButton.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al abrir la ventana de login.");
        }
    }
}
