package lk.ijse.dao;

import lk.ijse.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.dao.custom.impl.ProgramDAOImpl;
import lk.ijse.dao.custom.impl.RegistrationDAOImpl;
import lk.ijse.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null)? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        Student, Programs,Registration, Users,Payment
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
            default:
                return null;
        }
    }
}
