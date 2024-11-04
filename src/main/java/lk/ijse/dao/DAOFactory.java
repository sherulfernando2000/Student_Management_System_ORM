package lk.ijse.dao;

import lk.ijse.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null)? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        Student, Programs,Registration, Users
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case Student:
                return new StudentDAOImpl();

            case Programs:
                return new ProgramDAOImpl();



            default:
                return null;
        }
    }
}
