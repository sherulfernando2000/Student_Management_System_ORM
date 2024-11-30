package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dto.StudentDTO;
import lk.ijse.tdm.tm.StudentTm;
import lk.ijse.util.Regex;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class StudentFormController {

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private Label lblStudentId;

    @FXML
    private TableView<StudentTm> tblStudent;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtStudentName;

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Student);

    public void initialize(){
        getCurrentStudentId();
        setCellValueFactory();
        loadAllStudents();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("s_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("s_name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }



    private void loadAllStudents() {
        ObservableList<StudentTm> obList = FXCollections.observableArrayList();
        try {
            List<StudentDTO> studentList = studentBO.getAllCustomer();
            for (StudentDTO studentDTO : studentList) {
                StudentTm tm = new StudentTm(
                        studentDTO.getS_id(),
                        studentDTO.getS_name(),
                        studentDTO.getAddress(),
                        studentDTO.getContact_no(),
                        studentDTO.getEmail()
                );

                obList.add(tm);
            }

            tblStudent.setItems(obList);
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }



    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String stuId = lblStudentId.getText();
        boolean isDeleted = studentBO.delete(stuId);
        if (isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION,"Student deleted").show();
            loadAllStudents();
            clearFields();
            getCurrentStudentId();
        }


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String stuId = lblStudentId.getText();
        String stuName = txtStudentName.getText();
        String stuContact = txtContact.getText();
        String stuEmail = txtEmail.getText();
        String stuAddress = txtAddress.getText();

        StudentDTO studentDTO = new StudentDTO(stuId,stuName,stuAddress,stuContact,stuEmail);

        switch (isValied()){
            case 0: try {
                boolean isSaved = studentBO.saveStudent(studentDTO);
                if (isSaved ) {
                    new Alert(Alert.AlertType.CONFIRMATION,"Student saved").show();
                    loadAllStudents();
                    getCurrentStudentId();
                    clearFields();
                }
            } catch (Exception e) {
                new Alert( Alert.AlertType.ERROR,e.getMessage()).show();
            };
            break;

            case 1:
                new Alert(Alert.AlertType.ERROR,"Invalid name ").show();
                break;

            case 2:
                new Alert(Alert.AlertType.ERROR,"Invalid contact number").show();
                break;

            case 3:
                new Alert(Alert.AlertType.ERROR,"Invalid email").show();
                break;

            case 4:
                new Alert(Alert.AlertType.ERROR,"Invalid address").show();
                break;


        }




    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String stuId = lblStudentId.getText();
        String stuName = txtStudentName.getText();
        String stuContact = txtContact.getText();
        String stuEmail = txtEmail.getText();
        String stuAddress = txtAddress.getText();

        StudentDTO studentDTO = new StudentDTO(stuId,stuName,stuAddress,stuContact,stuEmail);

        try {
            boolean isUpdated = studentBO.updateStudent(studentDTO);
            if (isUpdated ) {
                new Alert(Alert.AlertType.CONFIRMATION,"Student updated").show();
                loadAllStudents();
            }
        } catch (Exception e) {
            new Alert( Alert.AlertType.ERROR,e.getMessage()).show();
        }


    }

    private void getCurrentStudentId() {
        try {
            String currentId = studentBO.getCurrentStudentId();
            String nextOrderId = generateNextOrderId(currentId);
            lblStudentId.setText(nextOrderId);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }

    private String generateNextOrderId(String currentId) {
        if(currentId != null) {
            /*String[] split = currentId.split("S-");  //" ", "2"
            int idNum = Integer.parseInt(split[1]);*/
            int idNum = Integer.parseInt(currentId);
            return "S-" + ++idNum;
        }
        return "S-1";
    }

    @FXML
    void rowOnMouseClicked(MouseEvent event) {
        String id = tblStudent.getSelectionModel().getSelectedItem().getS_id();

        try {
            StudentDTO studentDTO = studentBO.searchStudentId(id);//searchProductId(id);
            if (studentDTO != null) {
                lblStudentId.setText(studentDTO.getS_id());
                txtStudentName.setText(studentDTO.getS_name());
                txtContact.setText(studentDTO.getContact_no());
                txtAddress.setText(studentDTO.getAddress());
                txtEmail.setText(studentDTO.getEmail());

            } else {
                new Alert(Alert.AlertType.INFORMATION, "customer not found!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    void clearFields(){
        txtStudentName.setText("");
        txtContact.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
    }

    @FXML
    void txtAddressOnKeyReleased(KeyEvent event) {
        Regex.setTextColor(lk.ijse.util.TextField.ADDRESS ,txtAddress);
    }

    @FXML
    void txtContactOnKeyReleased(KeyEvent event) {
        Regex.setTextColor(lk.ijse.util.TextField.PHONENO,txtContact);
    }

    @FXML
    void txtEmailOnKeyReleased(KeyEvent event) {
        Regex.setTextColor(lk.ijse.util.TextField.EMAIL,txtEmail);
    }

    @FXML
    void txtNameOnKeyReleased(KeyEvent event) {
        Regex.setTextColor(lk.ijse.util.TextField.NAME,txtStudentName);
    }

    public int isValied(){
        if (!Regex.setTextColor(lk.ijse.util.TextField.NAME,txtStudentName)) return 1;
        if (!Regex.setTextColor(lk.ijse.util.TextField.PHONENO,txtContact)) return 2;
        if (!Regex.setTextColor(lk.ijse.util.TextField.EMAIL,txtEmail)) return 3;
        if (!Regex.setTextColor(lk.ijse.util.TextField.ADDRESS,txtAddress)) return 4;
        return 0;
    }



}
