package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;
import lk.ijse.util.PasswordUtil;

import java.io.IOException;
import java.util.Objects;

public class LoginFormController {

    @FXML
    private AnchorPane rootNode;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private ImageView eyeIcon;

    @FXML
    private TextField txtPasswordVisible;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Users);

    @FXML
    private void togglePasswordVisibility() {
        if (txtPasswordVisible.isVisible()) {
            // Hide the visible TextField and show the PasswordField
            txtPasswordVisible.setVisible(false);
            txtPasswordVisible.setManaged(false);
            txtPassword.setVisible(true);
            txtPassword.setManaged(true);

            // Copy text back to the PasswordField
            txtPassword.setText(txtPasswordVisible.getText());
        } else {
            // Show the visible TextField and hide the PasswordField
            txtPasswordVisible.setVisible(true);
            txtPasswordVisible.setManaged(true);
            txtPassword.setVisible(false);
            txtPassword.setManaged(false);

            // Copy text to the visible TextField
            txtPasswordVisible.setText(txtPassword.getText());
        }
    }


    @FXML
    void btnLoggin(ActionEvent event) throws IOException {
        String userNameText = txtUserName.getText();
        String password = txtPassword.getText();

        User user = userBO.searchUserbyName(userNameText);

        if (user!=null) {
            if (user.getRole().equals("Admin")) {

                boolean isPassRight = PasswordUtil.verifyPassword(password, user.getPassword());
                if (isPassRight) {
                    navigatoT0AdminSidePanel();
                }else {
                    new Alert(Alert.AlertType.ERROR,"Incorrect Password").show();
                }

            }else{
                boolean isPassRight = PasswordUtil.verifyPassword(password, user.getPassword());
                if (isPassRight) {
                    navigatoToCoordinatorSidePanel();
                }else {
                    new Alert(Alert.AlertType.ERROR,"Incorrect Password").show();
                }
            }


        }else {
            new Alert(Alert.AlertType.ERROR,"User not found. Enter a correct user name").show();
        }

    }

    void navigatoT0AdminSidePanel() throws IOException {
        AnchorPane mainNode = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/sidePanel_form.fxml")));

        Scene scene = new Scene(mainNode);
        Stage stage = (Stage) rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Home Page");
    }

    void navigatoToCoordinatorSidePanel() throws IOException {
        AnchorPane mainNode = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/coordinatorSidePanel_form.fxml")));
        Scene scene = new Scene(mainNode);
        Stage stage = (Stage) rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Home Page");
    }

    @FXML
    void linkSignUpOnAction(ActionEvent event) throws IOException {
        AnchorPane mainNode = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/SignUp_form.fxml")));

        Scene scene = new Scene(mainNode);
        Stage stage = (Stage) rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("SignUp Page");
    }




}
