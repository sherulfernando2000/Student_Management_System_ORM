package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;

public interface DashBoardBO extends SuperBO {
    int getStudentCount();

    public int getProgramCount();

    public int getRegistrationCount();
}
