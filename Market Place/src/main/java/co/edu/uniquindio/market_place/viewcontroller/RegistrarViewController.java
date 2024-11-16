package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.controller.IniciarSesionController;
import co.edu.uniquindio.market_place.model.Usuario;
import co.edu.uniquindio.market_place.model.RollUsuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

import static com.almasb.fxgl.dsl.FXGLForKtKt.showMessage;

public class RegistrarViewController {

    @FXML
    private Button registrarVendedorButton;

    @FXML
    private Button registrarAdminButton;

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
    void onRegistrarVendedor(ActionEvent event) {
        registrarVendedor();
    }

    @FXML
    void onRegistrarAdmin(ActionEvent event) {
        registrarAdmin();
    }

    private void registrarVendedor() {
        if (camposLlenos(false)) {
            Usuario nuevoVendedor = crearUsuario(RollUsuario.VENDEDOR); // Crea usuario como vendedor
            System.out.println("Usuario registrado como vendedor: " + nuevoVendedor);
            IniciarSesionController.registrarVendedor(nuevoVendedor); // Registra en la lista de vendedores
            abrirVentanaIniciarSesion();
        } else {
            System.out.println("Por favor, complete todos los campos para registrar el usuario.");
        }
    }

    private void registrarAdmin() {
        if (camposLlenos(true)) { // Llamada a validar con clave de admin incluida
            String claveAdmin = claveAdminField.getText();
            if (IniciarSesionController.verificarClaveAdmin(claveAdmin)) {
                Usuario nuevoAdmin = crearUsuario(RollUsuario.ADMINISTRADOR); // Crea usuario como administrador
                System.out.println("Usuario registrado como administrador: " + nuevoAdmin);
                abrirVentanaIniciarSesion(); // Abre la ventana de login
            } else {
                showMessage("Error", "La clave de administrador es incorrecta", Alert.AlertType.ERROR);
            }
        } else {
            System.out.println("Por favor, complete todos los campos para registrar al administrador.");
        }
    }

    private void showMessage(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean camposLlenos(boolean esAdmin) {
        boolean camposComunes = !nombreField.getText().isEmpty() && !apellidoField.getText().isEmpty() &&
                !cedulaField.getText().isEmpty() && !direccionField.getText().isEmpty() &&
                !usuarioField.getText().isEmpty() && !contrasenaField.getText().isEmpty();

        if (esAdmin) {
            return camposComunes && !claveAdminField.getText().isEmpty();
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

        // Registrar el usuario en la lista correspondiente según el rol
        if (rol == RollUsuario.ADMINISTRADOR) {
            IniciarSesionController.registrarAdministrador(nuevoUsuario);
        } else if (rol == RollUsuario.VENDEDOR) {
            IniciarSesionController.registrarVendedor(nuevoUsuario);
        }

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
