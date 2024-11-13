package co.edu.uniquindio.market_place;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMarketplace extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar el archivo FXML de la pantalla de registro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/market_place/IniciarSesion.fxml"));
            Parent root = loader.load();

            // Configurar la escena y el escenario principal
            Scene scene = new Scene(root);
            primaryStage.setTitle("Inicio de sesión");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar la pantalla de registro.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

