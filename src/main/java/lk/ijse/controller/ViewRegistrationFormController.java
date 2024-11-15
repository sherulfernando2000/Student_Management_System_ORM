package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.entity.Registration;
import lk.ijse.entity.Student;
import lk.ijse.tdm.tm.StudentTm;
import lk.ijse.tdm.tm.ViewRegiTm;

import java.io.IOException;
import java.util.List;

public class ViewRegistrationFormController {

    @FXML
    private TableColumn<?, ?> colCourseId;

    @FXML
    private TableColumn<?, ?> colCourseName;

    @FXML
    private TableColumn<?, ?> colStudentId;

    @FXML
    private TableColumn<?, ?> colStudentName;

    @FXML
    private TableColumn<?, ?> colUpfrontPayment;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<ViewRegiTm> tblREgiDetails;

    @FXML
    private TextField txtSearchByStudentId;

    ObservableList<ViewRegiTm> obList;

    StudentBO studentBO = (StudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.Student);

    public void initialize(){
        loadRegiDetails();
        setCellValueFactory();
        loadAllRegiDetails();
        txtSearchByStudentId.setOnKeyPressed(this::handleEnterKey);
    }

    private void handleEnterKey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            searchStudentById(txtSearchByStudentId.getText());
        }
    }

    private void searchStudentById(String id) {
        // Filter the obList by the studentId
        ObservableList<ViewRegiTm> filteredList = obList.filtered(registration -> registration.getStudentId().equals(id));

        // Set the filtered list to the table view
        tblREgiDetails.setItems(filteredList);
    }

    public void setCellValueFactory(){
        colCourseId.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        colCourseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colUpfrontPayment.setCellValueFactory(new PropertyValueFactory<>("upforntPay"));

    }

    public void loadAllRegiDetails(){
        List<Student> students = studentBO.getStudentWithEnrolledPrograms();
        obList = FXCollections.observableArrayList();
        for (Student student : students) {
            System.out.println("Student: " + student.getS_name());
            for (Registration registration : student.getRegistrationList()) {
                System.out.println("Enrolled in Program: " + registration.getProgram().getpName());
                ViewRegiTm viewRegiTm = new ViewRegiTm(student.getS_id(),student.getS_name(),registration.getProgram().getpId(), registration.getProgram().getpName(),String.valueOf(registration.getProgram().getFee()));
                obList.add(viewRegiTm);
            }
        }

        tblREgiDetails.setItems(obList);
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane dashRootNode = null;
        try {
            dashRootNode = FXMLLoader.load(this.getClass().getResource("/view/registration_form.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        rootNode.getChildren().clear();
        rootNode.getChildren().add(dashRootNode);
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        ObservableList<ViewRegiTm> filteredList = obList.filtered(registration -> registration.getStudentId().equals(txtSearchByStudentId.getText()));

        // Set the filtered list to the table view
        tblREgiDetails.setItems(filteredList);
    }

    @FXML
    void btnViewAllOnAction(ActionEvent event) {
        loadAllRegiDetails();
    }

    void loadRegiDetails(){
        List<Student> students = studentBO.getStudentWithEnrolledPrograms();
        for (Student student : students) {
            System.out.println("Student: " + student.getS_name());
            for (Registration registration : student.getRegistrationList()) {
                System.out.println("Enrolled in Program: " + registration.getProgram().getpName());
            }
        }

    }

}
