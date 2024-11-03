package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO extends CrudDAO<Student> {

    public  String getCurrentId() throws SQLException;

    public Student searchId(String id);



}
