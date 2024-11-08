package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.controller.MisProductosController;
import co.edu.uniquindio.market_place.mapping.dto.ProductoDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class MisProductosViewController {

    @FXML
    private Button crearPublicacionButton;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cerrarSesionButton;

    @FXML
    private ImageView iconUsuario;

    @FXML
    private Button miPerfilButton;

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
    private Button editarProductoButton;

    @FXML
    void cerrarSesion(ActionEvent event) {

    }

    @FXML
    void crearPublicacion(ActionEvent event) {

    }

    @FXML
    void editarProducto(ActionEvent event) {

    }

    @FXML
    void miPerfil(ActionEvent event) {

    }

    @FXML
    void initialize() {
        misProductosController = new MisProductosController();

        initView();
    }

}
