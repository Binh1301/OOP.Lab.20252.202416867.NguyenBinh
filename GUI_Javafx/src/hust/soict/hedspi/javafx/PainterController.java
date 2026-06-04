package hust.soict.hedspi.javafx;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class PainterController {
    @FXML private Canvas canvas;
    @FXML private ColorPicker colorPicker;
    @FXML private Slider lineWidthSlider;

    private GraphicsContext gc;

    @FXML
    private void initialize() {
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(colorPicker.getValue());
        gc.setLineWidth(lineWidthSlider.getValue());

        colorPicker.setOnAction(e -> gc.setStroke(colorPicker.getValue()));
        lineWidthSlider.valueProperty().addListener((obs, o, n) -> gc.setLineWidth(n.doubleValue()));
    }

    @FXML
    private void onMouseDragged(MouseEvent e) {
        gc.strokeLine(e.getX(), e.getY(), e.getX(), e.getY());
    }
}
