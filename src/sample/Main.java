package sample;

import Logica.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Trabajo Practico N5 Simulacion de Colas");
        primaryStage.setScene(new Scene(root, 2560, 1600));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
