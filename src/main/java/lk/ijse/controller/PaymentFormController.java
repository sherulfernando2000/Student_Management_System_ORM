package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dto.StudentDTO;

public class PaymentFormController {

    @FXML
    private ComboBox<?> cmbProgramNames;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label lblRegisterId;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtBalance;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtPayingAmount;

    @FXML
    private TextField txtProgramFee;

    @FXML
    private TextField txtStudentId;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtTotalPaid;

    @FXML
    private TextField txtUpfrontPayment;

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Student);

    @FXML
    void btnPayOnAction(ActionEvent event) {

    }

    @FXML
    void cmbProgramNamesOnAction(ActionEvent event) {

    }

    @FXML
    void getDateOnAction(ActionEvent event) {

    }

    @FXML
    void txtStudentIdOnAction(ActionEvent event) {
        String id = txtStudentId.getText();
        try {
            StudentDTO student = studentBO.searchStudentId(id);
            if (student != null) {
                txtStudentName.setText(student.getS_name());


            }else{
                new Alert(Alert.AlertType.INFORMATION, "student not found!").show();
            }


        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void txtStudentIdOnKeyReleased(KeyEvent event) {

    }

}

