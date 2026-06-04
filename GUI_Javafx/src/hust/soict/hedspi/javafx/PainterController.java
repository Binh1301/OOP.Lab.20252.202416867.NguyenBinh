package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    private static final double BRUSH_RADIUS = 4;

    @FXML private Pane drawingAreaPane;

    @FXML
    private void drawingAreaMouseDragged(MouseEvent e) {
        Circle dot = new Circle(e.getX(), e.getY(), BRUSH_RADIUS, Color.BLACK);
        drawingAreaPane.getChildren().add(dot);
    }

    @FXML
    private void clearButtonPressed(ActionEvent e) {
        drawingAreaPane.getChildren().clear();
    }
}
