package sample;

import org.opencv.core.Core;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            BorderPane root = loader.load();
            root.setStyle("-fx-background-color: whitesmoke;");
            Scene scene = new Scene(root, 1200, 500);
            primaryStage.setTitle("Card Detection");
            primaryStage.setScene(scene);
            primaryStage.show();


            Controller controller = loader.getController();
            controller.init();


            primaryStage.setOnCloseRequest((we -> controller.setClosed()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        launch(args);
    }
}
