package co.edu.uniquindio.market_place.viewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class MisProductosViewController {

    @FXML
    private ImageView iconUsuario;

    @FXML
    private Label nombreLabel;

    @FXML
    private Button cerrarSesionButton, miPerfilButton, likeButton1, likeButton2, likeButton3, crearPublicacionButton, eliminarButton1, eliminarButton2;

    @FXML
    private ImageView productoImagen1, productoImagen2, productoImagen3;

    @FXML
    private TextArea productoDescripcion1, productoDescripcion2, productoDescripcion3;

    @FXML
    void cerrarSesion() {
        // Lógica para cerrar sesión
        System.out.println("Cerrar sesión");
    }

    @FXML
    void likeProducto1() {
        // Lógica para dar like al producto 1
        System.out.println("Like al producto 1");
    }

    @FXML
    void likeProducto2() {
        // Lógica para dar like al producto 2
        System.out.println("Like al producto 2");
    }

    @FXML
    void likeProducto3() {
        // Lógica para dar like al producto 3
        System.out.println("Like al producto 3");
    }

    @FXML
    void crearPublicacion() {
        // Lógica para crear una publicación
        System.out.println("Crear publicación");
    }

    @FXML
    void eliminarProducto1() {
        // Lógica para eliminar el producto 1
        System.out.println("Eliminar producto 1");
    }

    @FXML
    void eliminarProducto2() {
        // Lógica para eliminar el producto 2
        System.out.println("Eliminar producto 2");
    }

    @FXML
    void initialize() {
        // Lógica de inicialización
        System.out.println("Vista de productos inicializada");
    }
}
