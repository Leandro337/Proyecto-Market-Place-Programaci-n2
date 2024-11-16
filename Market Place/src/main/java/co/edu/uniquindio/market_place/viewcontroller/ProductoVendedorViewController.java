package co.edu.uniquindio.market_place.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ProductoVendedorViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button likeButton;

    @FXML
    void onLike (ActionEvent event) {
        darLike();
    }

    @FXML
    void initialize() {

    }

    private void darLike () {

    }
}
