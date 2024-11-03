package lk.ijse.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;
import java.io.IOException;

public class SidePanelFormController {
    @FXML
    private AnchorPane rootNode;

    @FXML
    private AnchorPane childRootNode;

    public void initialize() throws IOException {
        AnchorPane dashRootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
        childRootNode.getChildren().clear();
        childRootNode.getChildren().add(dashRootNode);

    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) {
        navigateTo("/view/dashboard_form.fxml");
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        navigateTo("/view/login_form.fxml");
    }

    @FXML
    void btnProgramsOnAction(ActionEvent event) {
        navigateTo("/view/program_form.fxml");
    }

    @FXML
    void btnRegistrationOnAction(ActionEvent event) {
        navigateTo("/view/registration_form.fxml");
    }

    @FXML
    void btnSettingOnAction(ActionEvent event) {
        navigateTo("/view/userSetting_form.fxml");
    }

    @FXML
    void btnStudentOnAction(ActionEvent event) {
        navigateTo("/view/student_form.fxml");
    }

    @FXML
    void btnUsersOnAction(ActionEvent event) {
        navigateTo("/view/users_form.fxml");
    }

    void navigateTo(String path){
        AnchorPane dashRootNode = null;
        try {
            dashRootNode = FXMLLoader.load(this.getClass().getResource(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        childRootNode.getChildren().clear();
        childRootNode.getChildren().add(dashRootNode);
    }


}
