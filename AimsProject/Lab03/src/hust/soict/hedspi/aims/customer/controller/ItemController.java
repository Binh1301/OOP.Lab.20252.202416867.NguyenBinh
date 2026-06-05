package hust.soict.hedspi.aims.customer.controller;

import hust.soict.hedspi.aims.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemController {
    @FXML private Label lblTitle;
    @FXML private Label lblCost;
    @FXML private Button btnAddToCart;
    @FXML private Button btnPlay;

    private Media media;
    private Cart cart;

    public void setData(Media media) {
        setData(media, null);
    }

    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        lblTitle.setText(media.getTitle());
        lblCost.setText(String.format("%.2f $", media.getCost()));

        boolean isPlayable = media instanceof Playable;
        btnPlay.setVisible(isPlayable);
        btnPlay.setManaged(isPlayable);
    }

    @FXML
    private void btnAddToCartClicked(ActionEvent e) {
        if (cart != null && media != null) {
            cart.addMedia(media);
        }
    }

    @FXML
    private void btnPlayClicked(ActionEvent e) {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException ex) {
                System.err.println(ex.getMessage());
                ex.printStackTrace();
                showError(ex.getMessage());
            }
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Player Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
