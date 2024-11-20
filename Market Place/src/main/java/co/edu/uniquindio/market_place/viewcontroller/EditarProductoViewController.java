package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.model.EstadoProducto;
import co.edu.uniquindio.market_place.model.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    private ComboBox<EstadoProducto> estadoComboBox;


    private Producto productoOriginal;

    private MisProductosViewController misProductosController;

    // Configura el controlador de la ventana de productos para actualizar la lista
    public void setMisProductosController(MisProductosViewController controller) {
        this.misProductosController = controller;
    }

    public void initData(Producto producto) {
        this.productoOriginal = producto;
        nombreTextField.setText(producto.getNombre());
        precioTextField.setText(String.valueOf(producto.getPrecio()));
        categoriaTextField.setText(producto.getCategoria());

        // Limpiar los elementos anteriores del ComboBox antes de agregar nuevos
        estadoComboBox.getItems().clear();

        // Agregar los valores del Enum EstadoProducto
        estadoComboBox.getItems().addAll(EstadoProducto.values());

        // Establecer el valor actual en el ComboBox
        estadoComboBox.setValue(producto.getEstadoProducto());
    }


    @FXML
    private void onGuardarProducto() {
        // Guardar cambios en el producto
        productoOriginal.setNombre(nombreTextField.getText());
        productoOriginal.setPrecio(Double.parseDouble(precioTextField.getText()));
        productoOriginal.setCategoria(categoriaTextField.getText());
        productoOriginal.setEstadoProducto(estadoComboBox.getValue());

        // Actualizar la lista en la vista principal
        if (misProductosController != null) {
            misProductosController.actualizarProducto(productoOriginal);
        }

        // Cerrar la ventana de edición
        Stage stage = (Stage) guardarButton.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void onCancelar() {
        // Lógica para cancelar edición
        System.out.println("Edición cancelada");
    }
}
