package lk.ijse.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.dao.custom.PaymentDAO;
import lk.ijse.entity.Payment;
import lk.ijse.entity.Program;
import org.hibernate.Session;

import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public boolean save(Payment entity) {
        return false;
    }

    @Override
    public boolean update(Payment entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Payment> getAll() {
        return List.of();
    }

    @Override
    public boolean savePayment(Payment entity, Session session) {
        try {
            session.save(entity);
            return true;
        } catch (Exception e) {
             new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
             return false;
        }
    }
}
