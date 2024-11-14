package lk.ijse.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class SidePanelFormController {
    @FXML
    private AnchorPane rootNode;

    @FXML
    private AnchorPane childRootNode;

    @FXML
    private Label lblDate;


    public void initialize() throws IOException {
        AnchorPane dashRootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
        childRootNode.getChildren().clear();
        childRootNode.getChildren().add(dashRootNode);
        setDateTime();

    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) {
        navigateTo("/view/dashboard_form.fxml");
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        AnchorPane loadNode = null;
        try {
            loadNode = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/login_form.fxml")));
            Scene scene = new Scene(loadNode);
            Stage stage = (Stage) rootNode.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Login form");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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

    private void setDateTime() {
        LocalDate now = LocalDate.now();
        lblDate.setText(String.valueOf(now));
        /*LocalTime now1 = LocalTime.of(LocalTime.now().getHour(), LocalTime.now().getMinute());
        lblOrderTime.setText(String.valueOf(now1));*/

    }





}
