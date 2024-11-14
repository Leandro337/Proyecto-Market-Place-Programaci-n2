package co.edu.uniquindio.market_place.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.market_place.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MiPerfilViewController {

        Usuario usuarioActual;

        @FXML
        private ResourceBundle resources;

        @FXML
        private Label nombreLabel;


        @FXML
        private URL location;

        @FXML
        private TextArea TextAreaChatsAbiertos;

        @FXML
        private Button btnCerrarSeion;

        @FXML
        private Button btnEnviarMensaje;

        @FXML
        private Button btnMostrarMisProductos;

        @FXML
        private ListView<?> listViewChats;

        @FXML
        private ListView<?> listViewContactos;

        @FXML
        private ListView<?> listViewContactosSugeridos;

        @FXML
        private TextField txtCampoTexto;

        @FXML
        private void onCerrarSesion() {
                Stage currentStage = (Stage) btnCerrarSeion.getScene().getWindow();
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

        @FXML
        void onEnviarMensaje(ActionEvent event) {

        }

        @FXML
        void onMostrarMisProductos(ActionEvent event) {
                try {
                        // Cargar el archivo FXML de la nueva vista (por ejemplo, MisProductos.fxml)
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/market_place/MisProductos.fxml"));
                        Parent root = loader.load();

                        // Crear una nueva escena y mostrarla
                        Stage stage = (Stage) btnMostrarMisProductos.getScene().getWindow(); // Obtiene el escenario actual
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


        @FXML
        void initialize() {

        }

        public void setUsuarioActual(Usuario usuario2) {
                this.usuarioActual = usuario2;
                nombreLabel.setText(usuarioActual.getNombre());
        }
}
