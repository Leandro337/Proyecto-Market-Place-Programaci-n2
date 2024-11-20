package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.EstadoProducto;
import co.edu.uniquindio.market_place.service.ObserverProductoCreado;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CrearProductoViewController {

    @FXML
    public Button cancelarButton;

    @FXML
    private Button guardarButton;

    @FXML
    private TextField nombreProductoField;

    @FXML
    private TextField precioProductoField;

    @FXML
    private TextField categoriaProductoField;

    @FXML
    private ComboBox<EstadoProducto> estadoProductoComboBox;

    private ObserverProductoCreado productoCreadoListener; // Listener para notificar la creación

    // Método para registrar el listener
    public void setProductoCreadoListener(ObserverProductoCreado listener) {
        this.productoCreadoListener = listener;
    }

    @FXML
    public void initialize() {
        // Agregar los valores del enum al ComboBox
        estadoProductoComboBox.getItems().setAll(EstadoProducto.values());
    }


    @FXML
    private void onGuardarPublicacion() {
        String nombre = nombreProductoField.getText();
        String precio = precioProductoField.getText();
        String categoria = categoriaProductoField.getText();

        // Obtener el estado seleccionado del ComboBox (ahora es un valor de EstadoProducto)
        EstadoProducto estado = estadoProductoComboBox.getValue();

        // Validar que todos los campos estén llenos
        if (nombre.isEmpty() || precio.isEmpty() || categoria.isEmpty() || estado == null) {
            mostrarAlerta("Error", "Todos los campos deben ser completados", Alert.AlertType.ERROR);
            return;
        }

        try {
            // Convertir precio a un número
            double precioProducto = Double.parseDouble(precio);

            // Crear el producto
            Producto producto = new Producto(nombre, precioProducto, categoria, estado);

            // Notificar al listener sobre el nuevo producto
            if (productoCreadoListener != null) {
                productoCreadoListener.onProductoCreado(producto);
            }

            // Mostrar mensaje de éxito
            mostrarAlerta("Éxito", "La publicación se ha guardado correctamente", Alert.AlertType.INFORMATION);

            // Limpiar los campos después de guardar
            limpiarCampos();
        } catch (NumberFormatException e) {
            // Mostrar un error si el precio no es un número válido
            mostrarAlerta("Error", "El precio debe ser un número válido", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void onCancelar() {
        limpiarCampos();
        Stage stage = (Stage) cancelarButton.getScene().getWindow();
        stage.close();
    }

    // Método para mostrar alertas
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        nombreProductoField.clear();
        precioProductoField.clear();
        categoriaProductoField.clear();
        estadoProductoComboBox.getSelectionModel().clearSelection();
    }
}
