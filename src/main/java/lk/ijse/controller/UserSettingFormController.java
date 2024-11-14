package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.entity.User;
import lk.ijse.util.PasswordUtil;

public class UserSettingFormController {

    @FXML
    private TextField txtCurrentPassword;

    @FXML
    private TextField txtNewPassword;

    @FXML
    private TextField txtUserName;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Users);


    @FXML
    void btnSaveChangesOnAction(ActionEvent event) {
        User user = userBO.searchUserbyName(txtUserName.getText());
        String password =  txtCurrentPassword.getText();

        if (user != null) {
            String userName = user.getUserName();
            String dbPassword = user.getPassword();
            boolean isPassCorrect = PasswordUtil.verifyPassword(password, dbPassword);
            if (isPassCorrect) {
                String newpassword  = txtNewPassword.getText();
                String hashPass = PasswordUtil.hashPassword(newpassword);
                boolean isPasswordUpdated = userBO.updateUserPassword(hashPass,userName);
                if (isPasswordUpdated) {
                    new Alert(Alert.AlertType.ERROR,"Password updated successfully").show();
                }else{
                    new Alert(Alert.AlertType.ERROR,"Password not updated successfully").show();
                }

            }else {
                new Alert(Alert.AlertType.ERROR,"Current Password not correct").show();
            }

        }else{
            new Alert(Alert.AlertType.ERROR,"User not found.").show();
        }

    }

}
