package co.edu.uniquindio.market_place.viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;


public class PerfilVendedoresViewController {

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
        System.out.println("Cerrar sesión");
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
}
