package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;


public class PerfilVendedoresViewController {

    Usuario usuarioActual;

    @FXML
    private Button cerrarSesionButton;

    @FXML
    private Button miPerfilButton;

    @FXML
    private Button anadirContactButton;

    @FXML
    private Button verProductoButton;

    @FXML
    private Label nombreLabel;

    @FXML
    private ImageView usuarioImagen1;

    @FXML
    private ImageView usuarioImagen2;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    @FXML
    private ListView<?> listView;

    @FXML
    void onCerrarSesion (ActionEvent event) {
        System.out.println("Cerrar Sesion");
        cerrarSesion ();
    }

    @FXML
    void onMiPerfil (ActionEvent event) {
        System.out.println("Abrir perfil");
        abrirMiPerfil ();
    }

    @FXML
    void onAnadirContacto (ActionEvent event) {
        System.out.println("Añadir contacto");
        anadirContacto ();
    }

    @FXML
    void onVerProducto (ActionEvent event) {
        System.out.println("Ver producto");
        verProducto ();
    }

    @FXML
    private void initialize() {
        // Código de inicialización, como configurar textos o imágenes
        nombreLabel.setText("Bienvenido, Usuario");
    }

    private void cerrarSesion() {
        Stage currentStage = (Stage) cerrarSesionButton.getScene().getWindow();
        if (currentStage != null) {
            currentStage.close();
        }

        openWindow("/co/edu/uniquindio/market_place/IniciarSesion.fxml", "Inicio de sesión", null);

    }

    private void openWindow(String s, String inicioDeSesión, Stage ownerStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(s));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(inicioDeSesión);

            if (ownerStage != null) {
                stage.initOwner(ownerStage);
            }
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirMiPerfil() {

    }

    private void verProducto() {

    }

    private void anadirContacto() {

    }

    public void setUsuarioActual(Usuario usuario2) {
        this.usuarioActual = usuario2;
    }
}
