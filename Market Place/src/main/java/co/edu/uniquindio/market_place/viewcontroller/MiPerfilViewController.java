package co.edu.uniquindio.market_place.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.market_place.controller.IniciarSesionController;
import co.edu.uniquindio.market_place.model.Usuario;
import co.edu.uniquindio.market_place.model.Vendedor;
import co.edu.uniquindio.market_place.service.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MiPerfilViewController implements Observer {

    private Usuario usuarioActual;
    private ObservableList<String> listaContactosSugeridos = FXCollections.observableArrayList();

    @FXML
    private Button cerrarSeionButton;

    @FXML
    private Button enviarMensajeButton;

    @FXML
    private Button mostrarMisProductosButton;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Label nombreLabel;

    @FXML
    private URL location;

    @FXML
    private TextArea TextAreaChatsAbiertos;

    @FXML
    private ListView<String> listViewChats;

    @FXML
    private ListView<String> listViewContactos;

    @FXML
    private ListView<String> listViewContactosSugeridos;

    @FXML
    private TextField txtCampoTexto;

    @FXML
    void onCerrarSesion(ActionEvent event) {
        cerrarSesion ();
    }

    @FXML
    void onEnviarMensaje (ActionEvent event){
        enviarMensaje ();
    }

    @FXML
    void onMostrarMisProductos(ActionEvent event) {
        mostrarMisProductos ();
    }

    @FXML
    private void initialize() {
        listViewContactosSugeridos.setOnMouseClicked(event -> {
            String contactoSeleccionado = listViewContactosSugeridos.getSelectionModel().getSelectedItem();
            if (contactoSeleccionado != null) {
                // Abrir nueva ventana con la información del contacto seleccionado
                abrirVentanaContacto(contactoSeleccionado);
            }
        });
        IniciarSesionController.addObserver(this);
    }

    private void abrirVentanaContacto(String contacto) {
        try {
            // Cargar la vista del contacto seleccionado (por ejemplo, "VistaContacto.fxml")
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/market_place/PerfilVendedores.fxml"));
            Parent root = loader.load();

            // Asumiendo que la nueva ventana tiene un controlador que recibe el contacto seleccionado
            PerfilVendedoresViewController controlador = loader.getController();
            controlador.setContacto(contacto);

            // Crear una nueva escena y mostrarla
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.setTitle("Información del Contacto");

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void cerrarSesion() {
        Stage currentStage = (Stage) cerrarSeionButton.getScene().getWindow();
        if (currentStage != null) {
                currentStage.close();
        }

        openWindow("/co/edu/uniquindio/market_place/IniciarSesion.fxml", "Inicio de sesión", null);

    }

    private void openWindow(String s, String inicioDeSesión, Stage ownerStage) {
            try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(s));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.setTitle(inicioDeSesión);

                    if (ownerStage != null) {
                            stage.initOwner(ownerStage);
                    }
                    stage.show();
            } catch (IOException e) {
                    e.printStackTrace();
            }
    }

    private void mostrarMisProductos() {
            try {
                    // Cargar el archivo FXML de la nueva vista (por ejemplo, MisProductos.fxml)
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/market_place/MisProductos.fxml"));
                    Parent root = loader.load();

                    // Crear una nueva escena y mostrarla
                    Stage stage = (Stage) mostrarMisProductosButton.getScene().getWindow(); // Obtiene el escenario actual
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

            } catch (Exception e) {
                    // En caso de error al cargar la nueva vista
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("No se pudo cargar la vista");
                    alert.setContentText("Hubo un error al intentar mostrar los productos.");
                    alert.showAndWait();
            }
    }


    private void enviarMensaje() {

    }


    public void setUsuarioActual(Usuario usuario2) {
        this.usuarioActual = usuario2;
        nombreLabel.setText(usuarioActual.getNombre());

        // Actualizar la lista de contactos sugeridos al cargar el perfil
        actualizarContactosSugeridos();
    }

    @Override
    public void actualizarContactosSugeridos() {
        List<Vendedor> vendedores = Vendedor.getListaVendedores();  // Obtener la lista actualizada de vendedores
        listViewContactosSugeridos.getItems().clear();  // Limpiar la lista actual

        // Agregar los nombres de los vendedores a la lista, excepto el usuario actual
        for (Vendedor vendedor : vendedores) {
            if (!vendedor.getNombre().equals(usuarioActual.getNombre())) {
                listViewContactosSugeridos.getItems().add(vendedor.getNombre());
            }
        }
    }

    public ObservableList<String> getListaContactosSugeridos() {
        return listaContactosSugeridos;
    }

    public void setListaContactosSugeridos(ObservableList<String> listaContactosSugeridos) {
        this.listaContactosSugeridos = listaContactosSugeridos;
    }
}
