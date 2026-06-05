package hust.soict.hedspi.aims.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ViewStoreController {
    private static final int ITEMS_PER_ROW = 3;

    private final Store store;

    @FXML private GridPane gridPane;

    public ViewStoreController(Store store) {
        this.store = store;
    }

    @FXML
    private void initialize() {
        if (store == null) {
            return;
        }

        int column = 0;
        int row = 0;

        for (Media media : store.getItemsInStore()) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                        "/hust/soict/hedspi/aims/customer/view/Item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(media);

                gridPane.add(anchorPane, column, row);
                column++;
                if (column == ITEMS_PER_ROW) {
                    column = 0;
                    row++;
                }
            } catch (IOException ex) {
                throw new IllegalStateException("Cannot load Item.fxml", ex);
            }
        }
    }

    @FXML
    private void btnViewCartPressed(ActionEvent e) {
    }
}
