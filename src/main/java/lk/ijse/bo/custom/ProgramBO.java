package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.ProgramDTO;
import lk.ijse.entity.Program;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProgramBO extends SuperBO {
    public boolean saveProgram(ProgramDTO programDTO);

    public String getCurrentProgramId() throws SQLException;


    public boolean updateProgram(ProgramDTO programDTO);

    public ProgramDTO searchProgramId(String id) ;


    public List<ProgramDTO> getAllPrograms() throws SQLException,ClassNotFoundException;

    public boolean delete(String id);

    ProgramDTO searchProgramByName(String name);
}
