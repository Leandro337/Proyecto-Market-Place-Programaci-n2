package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.mapping.dto.ProductoDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MisProductosViewController {
    @FXML
    private Button crearPublicacionButton;

    @FXML
    private Button editarProductoButton;

    @FXML
    private Button cerrarSesionButton;

    @FXML
    private Button volverAPerfilButton;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView iconUsuario;

    @FXML
    private Label nombreLabel;

    @FXML
    private TableColumn<ProductoDto, String> nombreProducto;

    @FXML
    private TableColumn<ProductoDto, Double> precioProducto;

    @FXML
    private TableColumn<ProductoDto, String> cantegoriaProducto;

    @FXML
    private TableView<ProductoDto> estadoProducto;


    @FXML
    void onCerrarSesion(ActionEvent event) {
        cerrarSesion ();
    }

    @FXML
    void onCrearPublicacion(ActionEvent event) {
        crearPublicacion ();
    }

    @FXML
    void onEditarProducto(ActionEvent event) {
        editarProducto();
    }

    @FXML
    void onVolver (ActionEvent event) {
        volverAPerfil();
    }

    @FXML
    void initialize() {

    }

    private void volverAPerfil() {
        try {
            // Cargar el archivo FXML de la vista anterior (MiPerfil.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/market_place/MiPerfil.fxml"));
            Parent root = loader.load();

            // Obtener el escenario actual
            Stage stage = (Stage) volverAPerfilButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores si la carga falla
        }
    }

    private void editarProducto() {

    }

    private void crearPublicacion() {

    }

    private void cerrarSesion() {

    }

}
