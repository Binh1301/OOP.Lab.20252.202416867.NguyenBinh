package hust.soict.hedspi.aims.customer.controller;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemController {
    @FXML private Label lblTitle;
    @FXML private Label lblCost;
    @FXML private Button btnAddToCart;
    @FXML private Button btnPlay;

    private Media media;

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(String.format("%.2f $", media.getCost()));

        boolean isPlayable = media instanceof Playable;
        btnPlay.setVisible(isPlayable);
        btnPlay.setManaged(isPlayable);
    }

    @FXML
    private void btnAddToCartClicked(ActionEvent e) {
    }

    @FXML
    private void btnPlayClicked(ActionEvent e) {
        if (media instanceof Playable) {
            ((Playable) media).play();
        }
    }
}
