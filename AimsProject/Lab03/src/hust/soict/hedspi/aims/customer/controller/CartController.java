package hust.soict.hedspi.aims.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartController {
    private final Store store;
    private final Cart cart;
    private FilteredList<Media> filteredMedia;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, Integer> colMediaId;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Label costLabel;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Button btnPlaceOrder;
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;
    @FXML private ToggleGroup filterCategory;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        if (cart == null) {
            return;
        }

        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredMedia = new FilteredList<>(cart.getItemsOrdered(), media -> true);
        tblMedia.setItems(filteredMedia);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            updateButtonBar(newValue);
        });

        tfFilter.textProperty().addListener((obs, oldValue, newValue) -> {
            showFilteredMedia();
        });
        radioBtnFilterId.selectedProperty().addListener((obs, oldValue, newValue) -> showFilteredMedia());
        radioBtnFilterTitle.selectedProperty().addListener((obs, oldValue, newValue) -> showFilteredMedia());

        cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> updateTotalCost());
        updateTotalCost();
    }

    private void updateTotalCost() {
        costLabel.setText(String.format("%.2f $", cart.totalCost()));
    }

    private void updateButtonBar(Media media) {
        boolean hasSelection = media != null;
        boolean playable = hasSelection && media instanceof Playable;

        btnRemove.setVisible(hasSelection);
        btnPlay.setVisible(playable);
    }

    private void showFilteredMedia() {
        String filterText = tfFilter.getText();
        if (filterText == null || filterText.isBlank()) {
            filteredMedia.setPredicate(media -> true);
            return;
        }

        if (radioBtnFilterId.isSelected()) {
            try {
                int id = Integer.parseInt(filterText.trim());
                filteredMedia.setPredicate(media -> media.getId() == id);
            } catch (NumberFormatException ex) {
                filteredMedia.setPredicate(media -> false);
            }
        } else if (radioBtnFilterTitle.isSelected()) {
            String keyword = filterText.trim().toLowerCase();
            filteredMedia.setPredicate(media -> {
                String title = media.getTitle();
                return title != null && title.toLowerCase().contains(keyword);
            });
        } else {
            filteredMedia.setPredicate(media -> true);
        }
    }

    @FXML
    private void btnViewStorePressed(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/hust/soict/hedspi/aims/customer/view/Store.fxml"));
            loader.setControllerFactory(param -> new ViewStoreController(store, cart));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            throw new IllegalStateException("Cannot load Store.fxml", ex);
        }
    }

    @FXML
    private void btnPlayPressed(ActionEvent e) {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected instanceof Playable) {
            try {
                ((Playable) selected).play();
            } catch (PlayerException ex) {
                System.err.println(ex.getMessage());
                ex.printStackTrace();
                showError(ex.getMessage());
            }
        }
    }

    @FXML
    private void btnRemovePressed(ActionEvent e) {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected != null) {
            cart.removeMedia(selected);
        }
    }

    @FXML
    private void btnPlaceOrderPressed(ActionEvent e) {
        cart.getItemsOrdered().clear();
        tblMedia.getSelectionModel().clearSelection();
        updateButtonBar(null);
        updateTotalCost();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Player Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
