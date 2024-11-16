package lk.ijse.bo.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.bo.custom.RegistrationBO;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.PaymentDAO;
import lk.ijse.dao.custom.ProgramDAO;
import lk.ijse.dao.custom.RegistrationDAO;
import lk.ijse.dto.RegistrationDTO;
import lk.ijse.entity.Payment;
import lk.ijse.entity.Program;
import lk.ijse.entity.Registration;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {

    RegistrationDAO registrationDAO = (RegistrationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Registration);
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Payment);

    @Override
    public void placeRegister(List<RegistrationDTO> registrationDTOList) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
       // boolean isUpdated =false;
        List<Registration> registrationList = new ArrayList<>();
        boolean isRegistrationSaved =false;

        try{
            for (RegistrationDTO registrationDTO : registrationDTOList) {
                Student student = new Student();
                student.setS_id(registrationDTO.getSid());

                Program program = new Program();
                program.setpId(registrationDTO.getPid());



                Payment payment = new Payment();
                payment.setUpfrontpayment(registrationDTO.getUpfrontpayment());
                payment.setStudent(student);

                Registration registration = new Registration(/*Integer.parseInt(registrationDTO.getRid() ),*/student,program,registrationDTO.getUpfrontpayment(), payment,registrationDTO.getDate());
                registrationList.add(registration);

                boolean isSaved = registrationDAO.saveRegistration(registrationList,session);

                if(isSaved){
                    paymentDAO.savePayment(payment,session);

                }

            }
           /* Registration registration =  new Registration();
            Orders order = new Orders(orderDTO.getoId(),orderDTO.getDate(),orderDTO.getCustomer());
            System.out.println(order);
            boolean isSaved = orderDAO.save(order,session);
            if(isSaved){
                List<OrderDetails> orderDetails1 = new ArrayList<>();
                for (OrderDetailDTO orderDetail: orderDetails ){
                    Item item1 = new Item();
                    item1.setiId(orderDetail.getiId());
                    System.out.println(item1);

                    isUpdated = itemDAO.updateQty(item1,orderDetail.getQty(),session);

                    orderDetails1.add(new OrderDetails(order,item1,orderDetail.getQty()));
                }

                if (isUpdated) {
                    orderDetailDAO.save(orderDetails1,session);
                    transaction.commit();
                    new Alert(Alert.AlertType.CONFIRMATION,"transaction completed").show();

                }


            }*/

            transaction.commit();
            new Alert(Alert.AlertType.CONFIRMATION,"transaction completed").show();

        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            transaction.rollback();
        }finally {
            session.close();
        }

    }

    @Override
    public int getCurrentRegistrationId() {
        return registrationDAO.getCurrentId();
    }
}
