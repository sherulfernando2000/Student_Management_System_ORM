package lk.ijse.bo;

import lk.ijse.bo.custom.impl.ProgramBOImpl;
import lk.ijse.bo.custom.impl.RegistrationBOImpl;
import lk.ijse.bo.custom.impl.StudentBOImpl;
import lk.ijse.entity.Student;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory == null)?  boFactory =  new BOFactory():boFactory;

    }

    public enum BOTypes{
        Student, Programs,Registration, Users
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case Student:
                return new StudentBOImpl();

            case Programs:
                return  new ProgramBOImpl();

            case Registration:
                return  new RegistrationBOImpl();


            default:
                return null;
        }
    }
}
