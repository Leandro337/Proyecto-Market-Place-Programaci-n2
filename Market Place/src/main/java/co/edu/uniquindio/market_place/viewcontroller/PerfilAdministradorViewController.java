package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

public class PerfilAdministradorViewController {

    Usuario usuarioActual;

    @FXML
    private CheckBox mensajeVendedoresCheckBox;

    @FXML
    private CheckBox productosPorFechaCheckBox;

    @FXML
    private CheckBox productosPorVendedorCheckBox;

    @FXML
    private Tab tabVendedores;

    @FXML
    private Tab tabEstadisticas;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label nombreLabel;

    // Método que se ejecuta al iniciar la ventana
    @FXML
    public void initialize() {
        // Aquí puedes inicializar valores, datos o comportamientos necesarios
        // Por ejemplo, verificar qué opciones están seleccionadas al iniciar
        System.out.println("Perfil Administrador cargado.");
    }

    // Métodos para manejar los CheckBoxes de estadísticas
    @FXML
    private void handleMensajeVendedoresCheckBox(ActionEvent event) {
        if (mensajeVendedoresCheckBox.isSelected()) {
            showMessage("Estadística", "Cantidad de mensajes enviados entre dos vendedores seleccionada", Alert.AlertType.INFORMATION);
        } else {
            showMessage("Estadística", "Cantidad de mensajes enviados entre dos vendedores deseleccionada", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    private void handleProductosPorFechaCheckBox(ActionEvent event) {
        if (productosPorFechaCheckBox.isSelected()) {
            showMessage("Estadística", "Cantidad de productos publicados entre determinada fecha seleccionada", Alert.AlertType.INFORMATION);
        } else {
            showMessage("Estadística", "Cantidad de productos publicados entre determinada fecha deseleccionada", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    private void handleProductosPorVendedorCheckBox(ActionEvent event) {
        if (productosPorVendedorCheckBox.isSelected()) {
            showMessage("Estadística", "Cantidad de productos publicados por X vendedor seleccionada", Alert.AlertType.INFORMATION);
        } else {
            showMessage("Estadística", "Cantidad de productos publicados por X vendedor deseleccionada", Alert.AlertType.INFORMATION);
        }
    }

    // Método para mostrar alertas
    private void showMessage(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Otros métodos que puedas necesitar
    public void cargarVendedores(String vendedor) {
        // Lógica para cargar información de un vendedor según la pestaña seleccionada
        System.out.println("Cargando información del " + vendedor);
    }

    // Método para manejar acciones en las pestañas
    @FXML
    private void handleTabChanged() {
        if (tabVendedores.isSelected()) {
            System.out.println("Tab de vendedores seleccionada");
            // Aquí puedes agregar la lógica para cuando el administrador seleccione la pestaña de vendedores
        }

        if (tabEstadisticas.isSelected()) {
            System.out.println("Tab de estadísticas seleccionada");
            // Aquí puedes agregar la lógica para cuando el administrador seleccione la pestaña de estadísticas
        }
    }

    public void setUsuarioActual(Usuario usuario2) {
        this.usuarioActual = usuario2;
        nombreLabel.setText(usuarioActual.getNombre());
    }

}
