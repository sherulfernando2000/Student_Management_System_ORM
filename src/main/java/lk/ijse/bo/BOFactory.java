package lk.ijse.bo;

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

            /*case Item:
                return  new ItemBOImpl();

            case Orders:
                return  new OrderBOImpl();*/
            default:
                return null;
        }
    }
}
