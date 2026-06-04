package hust.soict.hedspi.aims.customer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(CustomerApp.class.getResource("view/CustomerHome.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("AIMS Customer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
