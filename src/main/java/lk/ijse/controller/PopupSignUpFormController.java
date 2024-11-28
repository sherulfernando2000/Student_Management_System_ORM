package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.entity.User;
import lk.ijse.util.PasswordUtil;

public class PopupSignUpFormController {

    @FXML
    private ComboBox<String> cmbAdminCoordinator;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private PasswordField txtAdminCode;

    @FXML
    private TextField txtAdminName;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtRePassword;

    @FXML
    private TextField txtUserName;

    @FXML
    public Button btnSignup;

    @FXML
    public Button btnUpdate;

    private UsersFormController usersFormController; // Reference to UsersFormController

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Users);

    public void initialize() {
        loadUser();
    }

    public void popupinitialize(){
        User userSelected = usersFormController.userSelected;
        txtUserName.setText(userSelected.getUserName());
        txtEmail.setText(userSelected.getEmail());
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
                    usersFormController.loadAllUsers();
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
    void btnUpdateOnAction(ActionEvent event) {
        User userSelected = usersFormController.userSelected;
        if (userSelected != null) {
            txtUserName.setText(userSelected.getUserName());
            txtEmail.setText(userSelected.getEmail());

            String firstUserName = userSelected.getUserName();
            String userName = txtUserName.getText();
            String email = txtEmail.getText();

            User user  = new User();
            user.setUserName(userName);
            user.setEmail(email);

            boolean isUpdated = userBO.updateUser(user,firstUserName);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "user updated").show();
                usersFormController.loadAllUsers();
            }else {
                new Alert(Alert.AlertType.ERROR,"user not updated").show();
            }



        }


    }

    public void setUsersFormController(UsersFormController usersFormController) {
        this.usersFormController = usersFormController;
    }
}
