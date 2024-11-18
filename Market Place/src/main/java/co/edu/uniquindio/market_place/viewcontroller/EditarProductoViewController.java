package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.model.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EditarProductoViewController {

    @FXML
    private Button guardarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField precioTextField;

    @FXML
    private TextField categoriaTextField;

    @FXML
    private ComboBox<String> estadoComboBox;

    public void initData(Producto producto) {
        nombreTextField.setText(producto.getNombre());
        precioTextField.setText(String.valueOf(producto.getPrecio()));
        categoriaTextField.setText(producto.getCategoria());
        estadoComboBox.setValue(producto.getEstadoProducto().toString());
    }

    @FXML
    private void onGuardarProducto() {
        // Lógica para guardar cambios
        System.out.println("Producto editado: " + nombreTextField.getText());
    }

    @FXML
    private void onCancelar() {
        // Lógica para cancelar edición
        System.out.println("Edición cancelada");
    }
}
