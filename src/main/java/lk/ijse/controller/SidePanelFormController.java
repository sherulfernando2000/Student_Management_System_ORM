package lk.ijse.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SidePanelFormController {
    @FXML
    private AnchorPane childRootNode;

    public void initialize() throws IOException {
        AnchorPane dashRootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
        childRootNode.getChildren().clear();
        childRootNode.getChildren().add(dashRootNode);

    }
}
