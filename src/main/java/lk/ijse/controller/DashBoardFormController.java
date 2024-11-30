package lk.ijse.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.DashBoardBO;
import lk.ijse.bo.custom.StudentBO;
import lk.ijse.entity.Student;

public class DashBoardFormController {

    @FXML
    private Label lblPrograms;

    @FXML
    private Label lblRegistration;

    @FXML
    private Label lblStudent;

    DashBoardBO dashBoardBO = (DashBoardBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.DashBoard);


    public void initialize() {
        int count = dashBoardBO.getStudentCount();
        lblStudent.setText(String.valueOf(count));

        int programCount = dashBoardBO.getProgramCount();
        lblPrograms.setText(String.valueOf(programCount));

        int regisCount = dashBoardBO.getRegistrationCount();
        lblRegistration.setText(String.valueOf(regisCount));
    }

    public void setStudentCount( ) {

    }



}
