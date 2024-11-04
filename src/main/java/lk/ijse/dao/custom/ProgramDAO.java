package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.ProgramDTO;
import lk.ijse.entity.Program;
import lk.ijse.entity.Student;

import java.sql.SQLException;

public interface ProgramDAO  extends CrudDAO<Program> {
    public  String getCurrentId() throws SQLException;

    public Program searchId(String id);

    Program searchByName(String name);
}
