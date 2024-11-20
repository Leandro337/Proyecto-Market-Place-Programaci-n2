package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.Usuario;
import co.edu.uniquindio.market_place.service.ObserverProductoCreado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MisProductosViewController implements ObserverProductoCreado {
    private Usuario usuarioActual;

    @FXML
    private Button cerrarSesionButton;

    @FXML
    private Button editarProductoButton;

    @FXML
    private Button crearPublicacionButton;

    @FXML
    private Button volverAPerfilButton;

    @FXML
    private TableView<Producto> productosTableView;

    @FXML
    private TableColumn<Producto, String> nombreProducto;
    @FXML
    private TableColumn<Producto, Double> precioProducto;
    @FXML
    private TableColumn<Producto, String> categoriaProducto;
    @FXML
    private TableColumn<Producto, String> EstadoProducto;
    @FXML
    private TableColumn<Producto, String> fechaProducto;

    private ObservableList<Producto> productos = FXCollections.observableArrayList(); // Lista observable de productos

    @FXML
    private void initialize() {
        productosTableView.setItems(productos); // Vincula la TableView con la lista observable

        nombreProducto.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getNombre()));
        precioProducto.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getPrecio()));
        categoriaProducto.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getCategoria()));
        EstadoProducto.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getEstado().toString()));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void actualizarProducto(Producto productoActualizado) {
        // Buscar el producto en la lista y actualizar sus valores
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getNombre() == productoActualizado.getNombre()) {
                // Reemplazar los valores del producto con los nuevos datos
                productos.get(i).setNombre(productoActualizado.getNombre());
                productos.get(i).setPrecio(productoActualizado.getPrecio());
                productos.get(i).setCategoria(productoActualizado.getCategoria());
                productos.get(i).setEstadoProducto(productoActualizado.getEstadoProducto());
                break;  // Salir del bucle una vez que se actualice el producto
            }
        }
        productosTableView.refresh(); // Refrescamos la TableView para reflejar los cambios
    }


    @FXML
    private void onCerrarSesion(ActionEvent event) {
        try {
            // Cerrar la ventana actual
            Stage stage = (Stage) cerrarSesionButton.getScene().getWindow();
            stage.close();

            // Cargar el FXML de la pantalla de inicio de sesión
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/market_place/IniciarSesion.fxml"));
            Scene loginScene = new Scene(loader.load());

            // Abrir la nueva ventana de inicio de sesión
            Stage loginStage = new Stage();
            loginStage.setScene(loginScene);
            loginStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la pantalla de inicio de sesión.");
        }
    }

    @FXML
    private void onEditarProducto(ActionEvent event) {
        Producto selectedProduct = productosTableView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            try {
                // Cargar el FXML de la pantalla de edición
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/market_place/EditarProducto.fxml"));
                Scene editProductScene = new Scene(loader.load());

                // Obtener el controlador de la vista cargada y pasarle el producto seleccionado
                EditarProductoViewController editProductController = loader.getController();
                editProductController.initData(selectedProduct);
                editProductController.setMisProductosController(this); // Pasamos el controlador

                // Abrir la nueva ventana de edición de producto sin cerrar la ventana de Mis Productos
                Stage editProductStage = new Stage();
                editProductStage.setScene(editProductScene);
                editProductStage.show();
            } catch (Exception e) {
                e.printStackTrace();
                showAlert("Error", "No se pudo cargar la pantalla de edición de producto.");
            }
        } else {
            showAlert("Selecciona un producto", "Por favor, selecciona un producto para editar.");
        }
    }


    // Acción para crear una nueva publicación
    @FXML
    private void onCrearPublicacion(ActionEvent event) {
        try {
            // Cargar el FXML de la pantalla de creación de producto
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/market_place/CrearProducto.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la vista cargada
            CrearProductoViewController crearProductoController = loader.getController();

            // Registrar el controlador actual como listener
            crearProductoController.setProductoCreadoListener(this);

            // Abrir la nueva ventana de creación de producto
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la pantalla de creación de publicación.");
        }
    }

    @Override
    public void onProductoCreado(Producto producto) {

        // Actualizar la TableView
        productosTableView.getItems().add(producto);

    }


    @FXML
    private void onVolver(ActionEvent event) {
        try {
            // Cerrar la ventana actual
            Stage stage = (Stage) volverAPerfilButton.getScene().getWindow();
            stage.close();

            // Cargar el FXML de la pantalla de perfil
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/market_place/MiPerfil.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la vista cargada
            MiPerfilViewController miPerfilController = loader.getController();

            // Pasar el usuario actual al controlador de "Mi Perfil"
            miPerfilController.setUsuarioActual(usuarioActual);

            // Abrir la nueva ventana de perfil
            Stage profileStage = new Stage();
            profileStage.setScene(new Scene(root));
            profileStage.setTitle("Perfil");
            profileStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la pantalla de perfil.");
        }
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
    }
}

