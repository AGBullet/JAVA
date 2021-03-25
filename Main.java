package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    // Не могу выбрать css, т.к его просто нет в быстром доступе

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Наш чат");
        primaryStage.setScene(new Scene(root, 660, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
