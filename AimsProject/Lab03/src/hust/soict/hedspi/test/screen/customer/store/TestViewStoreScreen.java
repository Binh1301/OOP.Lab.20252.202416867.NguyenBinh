package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.Cart;
import hust.soict.hedspi.aims.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Store store = new Store();
        Cart cart = new Cart();
        store.addMedia(new Book("Clean Code", "Programming", 29.99f));
        store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 19.99f));
        store.addMedia(new CompactDisc("The Fame", "Pop", "Lady Gaga", "Lady Gaga", 15.5f));

        FXMLLoader loader = new FXMLLoader(getClass().getResource(
                "/hust/soict/hedspi/aims/customer/view/Store.fxml"));
        loader.setControllerFactory(param -> new ViewStoreController(store, cart));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setTitle("AIMS Store");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
