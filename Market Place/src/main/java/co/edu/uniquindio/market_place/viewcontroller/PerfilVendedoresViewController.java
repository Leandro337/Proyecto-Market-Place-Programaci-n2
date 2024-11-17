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
    private Button volverAPerfilButton;

    @FXML
    private Button anadirContactoButton;

    @FXML
    private Button verProductoButton;

    @FXML
    private Label nombreLabel;

    @FXML
    private Label productoLabel;

    @FXML
    private ImageView usuarioImagen2;

    @FXML
    private Label usuarioLabel;

    @FXML
    private ListView<String> productosVendedorButton;


    @FXML
    void onVolver (ActionEvent event) {
        System.out.println("Abrir perfil");
        volverAMiPerfil ();
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

    public void setContacto(String contacto) {
        // Mostrar el nombre del contacto en la etiqueta
        nombreLabel.setText(contacto);
    }


    private void volverAMiPerfil() {

    }

    private void verProducto() {

    }

    private void anadirContacto() {

    }

    public void setUsuarioActual(Usuario usuario2) {
        this.usuarioActual = usuario2;
    }
}
