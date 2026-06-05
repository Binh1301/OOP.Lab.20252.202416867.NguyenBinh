package hust.soict.hedspi.aims.customer.controller;

import hust.soict.hedspi.aims.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {
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
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    public CartController(Cart cart) {
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
        btnPlay.setManaged(false);
        btnRemove.setVisible(false);
        btnRemove.setManaged(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
            updateButtonBar(newValue);
        });

        tfFilter.textProperty().addListener((obs, oldValue, newValue) -> {
            showFilteredMedia();
        });

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
        btnRemove.setManaged(hasSelection);
        btnPlay.setVisible(playable);
        btnPlay.setManaged(playable);
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
    }

    @FXML
    private void btnPlayPressed(ActionEvent e) {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected instanceof Playable) {
            ((Playable) selected).play();
        }
    }

    @FXML
    private void btnRemovePressed(ActionEvent e) {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected != null) {
            cart.removeMedia(selected);
        }
    }
}
