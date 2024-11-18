package co.edu.uniquindio.market_place.viewcontroller;

import co.edu.uniquindio.market_place.model.Producto;
import co.edu.uniquindio.market_place.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class MisProductosViewController {
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


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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

                // Abrir la nueva ventana de edición de producto
                Stage editProductStage = new Stage();
                editProductStage.setScene(editProductScene);
                editProductStage.show();

                // Cerrar la ventana actual
                Stage stage = (Stage) editarProductoButton.getScene().getWindow();
                stage.close();
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
            Scene createProductScene = new Scene(loader.load());

            // Abrir la nueva ventana de creación de producto
            Stage createProductStage = new Stage();
            createProductStage.setScene(createProductScene);
            createProductStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar la pantalla de creación de publicación.");
        }
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


    // Método para abrir la ventana de edición de producto
    private void openEditProductWindow(Producto product) {
        // Implementa la lógica para abrir una ventana de edición con los datos del producto
        // Aquí se puede usar un FXMLLoader para cargar un archivo FXML de edición y pasarlo al controlador
        System.out.println("Editando producto: " + product.getNombre());
    }

    // Método para abrir la ventana de creación de producto
    private void openCreateProductWindow() {
        // Implementa la lógica para abrir una ventana de creación de producto
        System.out.println("Abriendo formulario de creación de producto...");
    }

    // Si quieres realizar alguna acción cuando el mouse se mueva sobre la tabla o la tabla sea clickeada
    @FXML
    private void onTableClick() {
        Producto selectedProduct = productosTableView.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            System.out.println("Producto seleccionado: " + selectedProduct.getNombre());
        }
    }

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
    }
}

