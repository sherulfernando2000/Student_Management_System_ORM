package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.StudentDTO;

import java.sql.SQLException;
import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean saveStudent(StudentDTO studentDTO);

    public String getCurrentStudentId() throws SQLException;

    public boolean updateStudent(StudentDTO studentDTO);

    StudentDTO searchStudentId(String id);

    List<StudentDTO> getAllCustomer() throws SQLException,ClassNotFoundException;

    public boolean delete(String id);

}
