package co.edu.uniquindio.market_place;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class MainMarketplace extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar la ventana de perfil del vendedor
            FXMLLoader perfilLoader = new FXMLLoader(getClass().getResource("PerfilVendedores.fxml"));
            Parent perfilRoot = perfilLoader.load();
            Stage perfilStage = new Stage();
            perfilStage.setTitle("Perfil del Vendedor");
            perfilStage.setScene(new Scene(perfilRoot));
            perfilStage.show();

            // Cargar la ventana de productos
            FXMLLoader productosLoader = new FXMLLoader(getClass().getResource("MisProductos.fxml"));
            Parent productosRoot = productosLoader.load();
            Stage productosStage = new Stage();
            productosStage.setTitle("Mis Productos");
            productosStage.setScene(new Scene(productosRoot));
            productosStage.show();

            // Cargar la nueva ventana de registro de usuarios
            FXMLLoader registroLoader = new FXMLLoader(getClass().getResource("Registrar.fxml"));
            Parent registroRoot = registroLoader.load();
            Stage registroStage = new Stage();
            registroStage.setTitle("Registro de Usuarios");
            registroStage.setScene(new Scene(registroRoot));
            registroStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
