package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.List;

public class YourController {

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;

    private List<Button> buttons = new ArrayList<>(); // List to hold buttons

    @FXML
    public void initialize() {
        // Add buttons to the list for easy toggling
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);

        // Set event handlers for each button
        button1.setOnAction(this::toggleButtonActive);
        button2.setOnAction(this::toggleButtonActive);
        button3.setOnAction(this::toggleButtonActive);
    }

    private void toggleButtonActive(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        // Deactivate all buttons first
        for (Button button : buttons) {
            button.getStyleClass().remove("button-active");
        }

        // Activate the clicked button
        clickedButton.getStyleClass().add("button-active");
    }
}
