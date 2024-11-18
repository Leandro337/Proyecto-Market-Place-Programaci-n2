package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.controller.IniciarSesionController;
import co.edu.uniquindio.market_place.model.Administrador;
import co.edu.uniquindio.market_place.model.Usuario;
import co.edu.uniquindio.market_place.model.Vendedor;
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
            Vendedor nuevoVendedor = (Vendedor) crearUsuario(false);
            showMessage("Registro exitoso", "Nuevo vendedor registrado", Alert.AlertType.INFORMATION);
            IniciarSesionController.registrarVendedor(nuevoVendedor);  // Este método ahora notificará a los observadores
            abrirVentanaIniciarSesion();
        } else {
            showMessage("Campos incompletos", "Complete todos los campos para registrar al vendedor", Alert.AlertType.ERROR);
        }
    }

    private void registrarAdmin() {
        if (camposLlenos(true)) {
            String claveAdmin = claveAdminField.getText();
            if (IniciarSesionController.verificarClaveAdmin(claveAdmin)) {
                Administrador nuevoAdmin = (Administrador) crearUsuario(true);
                showMessage("Registro exitoso", "Nuevo administrador registrado", Alert.AlertType.INFORMATION);
                IniciarSesionController.registrarAdministrador(nuevoAdmin); // Cambia el controlador si es necesario
                abrirVentanaIniciarSesion();
            } else {
                showMessage("Error", "La clave de administrador es incorrecta", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Campos incompletos", "Complete todos los campos para registrar al administrador", Alert.AlertType.ERROR);
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

    private Usuario crearUsuario(boolean esAdmin) {
        if (esAdmin) {
            return new Administrador(
                    nombreField.getText(),
                    apellidoField.getText(),
                    cedulaField.getText(),
                    direccionField.getText(),
                    usuarioField.getText(),
                    contrasenaField.getText(),
                    claveAdminField.getText()
            );
        } else {
            return new Vendedor(
                    nombreField.getText(),
                    apellidoField.getText(),
                    cedulaField.getText(),
                    direccionField.getText(),
                    usuarioField.getText(),
                    contrasenaField.getText()
            );
        }
    }


    private void abrirVentanaIniciarSesion() {
        try {
            // Obtener el Stage de la ventana actual
            Stage stage = (Stage) registrarVendedorButton.getScene().getWindow();
            stage.close(); // Cerrar la ventana de registro

            // Cargar la nueva ventana de inicio de sesión
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/market_place/IniciarSesion.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Iniciar Sesion");
            newStage.setScene(new Scene(root));
            newStage.show(); // Mostrar la ventana de inicio de sesión
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
