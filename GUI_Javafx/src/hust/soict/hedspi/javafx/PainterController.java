package hust.soict.hedspi.javafx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    private static final double BRUSH_RADIUS = 4;

    @FXML private Pane drawingAreaPane;
    @FXML private ToggleGroup toolToggleGroup;
    @FXML private RadioButton eraserRadio;

    @FXML
    private void drawingAreaMouseDragged(MouseEvent e) {
        boolean erasing = toolToggleGroup != null && toolToggleGroup.getSelectedToggle() == eraserRadio;
        Color color = erasing ? Color.WHITE : Color.BLACK;
        Circle dot = new Circle(e.getX(), e.getY(), BRUSH_RADIUS, color);
        ObservableList<Node> children = drawingAreaPane.getChildren();
        children.add(dot);
    }

    @FXML
    private void clearButtonPressed(ActionEvent e) {
        drawingAreaPane.getChildren().clear();
    }
}
