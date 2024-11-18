package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.EstadoProducto;
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
    private TextField imagenProductoField;

    @FXML
    private TextField precioProductoField;

    @FXML
    private TextField categoriaProductoField;

    @FXML
    private ComboBox<String> estadoProductoComboBox;


    // Método para guardar la publicación
    @FXML
    private void onGuardarPublicacion() {
        String nombre = nombreProductoField.getText();
        String imagenUrl = imagenProductoField.getText();
        String precio = precioProductoField.getText();
        String categoria = categoriaProductoField.getText();
        EstadoProducto estado = EstadoProducto.valueOf(estadoProductoComboBox.getValue());

        // Validar que todos los campos estén llenos
        if (nombre.isEmpty() || imagenUrl.isEmpty() || precio.isEmpty() || categoria.isEmpty() || estado == null) {
            // Mostrar un mensaje de error si algún campo está vacío
            mostrarAlerta("Error", "Todos los campos deben ser completados", Alert.AlertType.ERROR);
            return;
        }

        try {
            // Convertir precio a un número (puedes agregar más validaciones si lo deseas)
            double precioProducto = Double.parseDouble(precio);

            // Aquí iría el código para guardar la publicación, como enviar los datos a un modelo o base de datos
            Producto producto = new Producto(nombre, imagenUrl, precioProducto, categoria, estado);
            //productosTableView.save(producto);

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
        imagenProductoField.clear();
        precioProductoField.clear();
        categoriaProductoField.clear();
        estadoProductoComboBox.getSelectionModel().clearSelection();
    }
}
