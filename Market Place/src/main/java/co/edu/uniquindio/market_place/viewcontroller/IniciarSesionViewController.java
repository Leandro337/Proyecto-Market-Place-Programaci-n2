package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.controller.IniciarSesionController;
import co.edu.uniquindio.market_place.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IniciarSesionViewController {

    IniciarSesionController iniciarSesionController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField contraseñaTxt;

    @FXML
    private Button iniciarSesionButton;

    @FXML
    private Button registrarButton;

    @FXML
    private TextField usuarioTxt;

    @FXML
    void onIniciarSesion(ActionEvent event) {
        iniciarSesion();

    }


    @FXML
    void onRegistrar(ActionEvent event) {
        registrarse();
    }

    @FXML
    void initialize() {
        iniciarSesionController = new IniciarSesionController();


    }

    private void iniciarSesion() {
        String usuario = usuarioTxt.getText();
        String contrasenia = contraseñaTxt.getText();
        if (validar(usuario, contrasenia)) {
            Usuario usuario2 = iniciarSesionController.iniciarSesion(usuario, contrasenia);
            if (usuario2 != null) {
                showMessage("Inicio de sesión", "Inicio de sesión exitoso", Alert.AlertType.INFORMATION);
                cargarMarketPlace(usuario2);
            } else {
                showMessage("Error", "Error al iniciar sesión", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Error", "Ingrese todos los datos", Alert.AlertType.ERROR);
        }

    }

    private void cargarMarketPlace(Usuario usuario2) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/market_place/PerfilVendedores.fxml"));
            Parent root = loader.load();
            PerfilVendedoresViewController perfilVendedoresViewController = loader.getController();
            perfilVendedoresViewController.setUsuarioActual(usuario2);

            Scene scene = new Scene(root);
            Stage stage = (Stage) contraseñaTxt.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Market Place "+"-> "+usuario2.getNombre());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean validar(String usuario, String contrasenia) {
        if (usuario == null || usuario.isEmpty()) {
            return false;
        }
        if (contrasenia == null || contrasenia.isEmpty()) {
            return false;
        }
        return true;
    }

    private void showMessage(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    public void registrarse() {
        try {
            // Cargar el archivo FXML de la ventana de registro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/market_place/Registrar.fxml"));
            Parent root = loader.load();

            // Crear una nueva ventana (Stage) para la ventana de registro
            Stage stage = new Stage();
            stage.setTitle("Registrar");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
