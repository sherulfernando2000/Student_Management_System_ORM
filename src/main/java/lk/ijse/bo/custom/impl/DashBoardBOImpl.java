package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.DashBoardBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ProgramDAO;
import lk.ijse.dao.custom.RegistrationDAO;
import lk.ijse.dao.custom.StudentDAO;

public class DashBoardBOImpl implements DashBoardBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Student);
    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Programs);
    RegistrationDAO registrationDAO = (RegistrationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Registration);
    @Override
    public int getStudentCount() {
        return studentDAO.getAll().size();
    }

    public int getProgramCount(){
        return programDAO.getAll().size();
    }

    public int getRegistrationCount(){
        return studentDAO.getStudentWithEnrolledPrograms().size();
    }
}
