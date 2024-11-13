package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.model.Usuario;
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
    private Label nombreLabel;

    @FXML
    private Button cerrarSesionButton, miPerfilButton, añadirContactoButton, likeButton1, likeButton2;

    @FXML
    private ImageView usuarioImagen1, usuarioImagen2;

    @FXML
    private TextArea textArea1, textArea2;

    @FXML
    private ListView<?> listView;

    @FXML
    private void initialize() {
        // Código de inicialización, como configurar textos o imágenes
        nombreLabel.setText("Bienvenido, Usuario");
    }

    @FXML
    private void onCerrarSesion() {
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


    @FXML
    private void onMiPerfil() {
        System.out.println("Abrir perfil");
    }

    @FXML
    private void onAñadirContacto() {
        System.out.println("Añadir contacto");
    }

    @FXML
    private void onLike1() {
        System.out.println("Primer Like");
    }

    @FXML
    private void onLike2() {
        System.out.println("Segundo Like");
    }

    public void setUsuarioActual(Usuario usuario2) {
        this.usuarioActual = usuario2;
    }
}
