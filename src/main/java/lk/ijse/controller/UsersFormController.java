package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;
import lk.ijse.tdm.tm.StudentTm;
import lk.ijse.tdm.tm.UserTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class UsersFormController {

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPassword;

    @FXML
    private TableColumn<?, ?> colRole;

    @FXML
    private TableView<UserTm> tblUser;

    @FXML
    private TextField txtUserSearch;

    User userSelected;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnUpdate;


    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Users);

    public void initialize(){
        setCellValueFactory();
        loadAllUsers();
    }

    public void loadAllUsers() {
        ObservableList<UserTm> obList = FXCollections.observableArrayList();
        try {
            List<UserDTO> userList = userBO.getAllUser();
            for (UserDTO userDTO : userList) {
                UserTm tm = new UserTm(
                       userDTO.getUserName(),
                       userDTO.getPassword(),
                       userDTO.getRole(),
                       userDTO.getEmail()

                );

                obList.add(tm);
            }

            tblUser.setItems(obList);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void setCellValueFactory() {
        colName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/popup_signup_form.fxml"));
        AnchorPane rootNode = loader.load();

        // Get the PopupSignUpFormController and pass this instance
        PopupSignUpFormController controller = loader.getController();
        controller.setUsersFormController(this);
        controller.btnUpdate.setDisable(true);// Pass UsersFormController instance

        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("signup form");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String userName = txtUserSearch.getText();
        boolean isDeleted = userBO.deleteUser(userName);
        if (isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION,"user deleted").show();
            loadAllUsers();
            clearFields();

        }
    }

    private void clearFields() {
        txtUserSearch.clear();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String userName = txtUserSearch.getText();

        User user = userBO.searchUserbyName(userName);
        loadSelectedUser(user);

    }

    private void loadSelectedUser(User user) {
        ObservableList<UserTm> obList = FXCollections.observableArrayList();
        try {

                UserTm tm = new UserTm(
                        user.getUserName(),
                        user.getPassword(),
                        user.getRole(),
                        user.getEmail()

                );

                obList.add(tm);


            tblUser.setItems(obList);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/popup_signup_form.fxml"));
        AnchorPane rootNode = loader.load();

        // Get the PopupSignUpFormController and pass this instance
        PopupSignUpFormController controller = loader.getController();
        controller.setUsersFormController(this);// Pass UsersFormController instance
        controller.popupinitialize();
        controller.btnSignup.setDisable(true);

        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("signup form");
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void rowOnMouseClicked(MouseEvent event) {
        String id = tblUser.getSelectionModel().getSelectedItem().getUserName();

        try {
            userSelected = userBO.searchUserbyName(id);//searchProductId(id);
            if (userSelected != null) {
                txtUserSearch.setText(userSelected.getUserName());


            } else {
                new Alert(Alert.AlertType.INFORMATION, "customer not found!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnViewAllOnAction(ActionEvent event) {
        loadAllUsers();
    }

}
