package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Payment;
import lk.ijse.entity.Program;
import org.hibernate.Session;

public interface PaymentDAO extends CrudDAO<Payment> {
    public boolean savePayment(Payment entity, Session session);
}
