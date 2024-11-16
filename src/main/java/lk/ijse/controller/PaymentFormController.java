package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.PaymentBO;
import lk.ijse.bo.custom.ProgramBO;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dto.ProgramDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Payment;
import lk.ijse.entity.Program;
import lk.ijse.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class PaymentFormController {

    @FXML
    private ComboBox<String> cmbProgramNames;

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
    ProgramBO programBO = (ProgramBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Programs);
    PaymentBO paymentBO = (PaymentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Payment);

    @FXML
    void btnPayOnAction(ActionEvent event) {

        String studentId = txtStudentId.getText();
        String payingamount = txtPayingAmount.getText();

        Student student = new Student();
        student.setS_id(studentId);

        Payment payment = new Payment();
        payment.setUpfrontpayment(Double.parseDouble(payingamount));
        payment.setStudent(student);

        boolean isSaved = paymentBO.savePayment(payment);
        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Payment Saved", ButtonType.OK).show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Payment Not Saved", ButtonType.OK).show();
        }


    }

    @FXML
    void cmbProgramNamesOnAction(ActionEvent event) {
        String programName = cmbProgramNames.getValue();
        String studentId = txtStudentId.getText();

        System.out.println(programName+studentId);

        Object[] programPaymentDetails = paymentBO.getProgramPaymentDetails(studentId, programName);
        System.out.println(programPaymentDetails[0].toString());

        txtProgramFee.setText((String.valueOf(programPaymentDetails[0])));
        txtUpfrontPayment.setText(String.valueOf(programPaymentDetails[1]) );
        txtTotalPaid.setText((String.valueOf(programPaymentDetails[2])));

        Double balance = (Double) programPaymentDetails[0] - (Double) programPaymentDetails[2];
        txtBalance.setText(balance.toString());



    }

    @FXML
    void getDateOnAction(ActionEvent event) {

    }

    @FXML
    void txtStudentIdOnAction(ActionEvent event) {
        String id = txtStudentId.getText();
        List<String> programNames = null;
        try {
            StudentDTO student = studentBO.searchStudentId(id);

            ObservableList<String> obList = FXCollections.observableArrayList();
            try {
                 programNames = programBO.getProgramNamesByStudentId(id);
                List<String> programNameList = new ArrayList<>();

                for (String program: programNames){
                    obList.add(program);
                }




            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            }

            if (student != null && programNames != null) {
                txtStudentName.setText(student.getS_name());
                cmbProgramNames.setItems(obList);






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

