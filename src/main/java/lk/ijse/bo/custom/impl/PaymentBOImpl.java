package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PaymentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.PaymentDAO;
import lk.ijse.dao.custom.ProgramDAO;
import lk.ijse.dao.custom.QueryDAO;
import lk.ijse.entity.Payment;
import lk.ijse.entity.Program;

public class PaymentBOImpl implements PaymentBO {

    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Payment);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.Query);


    public Object[] getProgramPaymentDetails(String studentId, String programId){
       return queryDAO.getProgramPaymentDetails(studentId,programId);
    }

    public boolean savePayment(Payment payment){
        return paymentDAO.save(payment);
    }
}
