package lk.ijse.dao;

import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null)? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        Student, Programs,Registration, Users,Payment,Query
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case Student:
                return new StudentDAOImpl();

            case Programs:
                return new ProgramDAOImpl();

            case Payment:
                return new PaymentDAOImpl();

                case Registration:
                    return new RegistrationDAOImpl();

            case Users:
                return new UserDAOImpl();

            case Query:
                return new QueryDAOImpl();




            default:
                return null;
        }
    }
}
