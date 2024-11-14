package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Student;
import lk.ijse.entity.User;
import lk.ijse.util.PasswordUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class SignUpFormController {

    @FXML
    private TextField txtAdminName;


    @FXML
    private ComboBox<String> cmbAdminCoordinator;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private PasswordField txtAdminCode;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtRePassword;

    @FXML
    private TextField txtUserName;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Users);


    public void initialize() {
        loadUser();
    }

    void loadUser() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            obList.add("Admin");
            obList.add("Coordinator");


            cmbAdminCoordinator.setItems(obList);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnSignupOnAction(ActionEvent event) {
        String userType = cmbAdminCoordinator.getValue();
        String userNameText = txtUserName.getText();
        String emailText = txtEmail.getText();
        String passwordText = txtPassword.getText();
        String rePasswordText = txtRePassword.getText();
        String adminNameText = txtAdminName.getText();
        String adminCodeText = txtAdminCode.getText();

        String hasedPass = PasswordUtil.hashPassword(rePasswordText);

        User user = userBO.searchUserbyName(adminNameText);


        if (passwordText.equals(rePasswordText)) {
            if (user!= null) {
                boolean isPassCorrect = PasswordUtil.verifyPassword(adminCodeText, user.getPassword());
                if (isPassCorrect) {
                    User userDTO  = new User(userNameText,hasedPass,userType,emailText);
                    boolean isSaved = userBO.saveUser(userDTO);
                    new Alert(Alert.AlertType.ERROR, "user  saved").show();
                }else{
                    new Alert(Alert.AlertType.ERROR, "user not saved.Enter valid admin code").show();
                }

            }else{
                new Alert(Alert.AlertType.ERROR, "Admin Name not found please enter valid admin name").show();
            }

        }else {
            new Alert(Alert.AlertType.ERROR, "Passwords do not match").show();
        }


    }

    @FXML
    void linkLoginOnAction(ActionEvent event) throws IOException {
        AnchorPane mainNode = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/view/login_form.fxml")));

        Scene scene = new Scene(mainNode);
        Stage stage = (Stage) rootNode.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Login Page");
    }

}
