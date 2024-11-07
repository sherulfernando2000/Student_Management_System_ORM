package lk.ijse.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.dao.custom.RegistrationDAO;
import lk.ijse.entity.Registration;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public boolean saveRegistration(List<Registration> registrationList, Session session) {

        try {
            for (Registration registration:registrationList){
                boolean issaved = save(registration,session);
            }
            return true;
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return false;
        }
    }


    public boolean save(Registration entity, Session session) throws SQLException, ClassNotFoundException {
        try {
            session.save(entity);
            return true;
        } catch (HibernateException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            return false;
        }
    }

    @Override
    public boolean save(Registration entity) {
        return false;
    }

    @Override
    public boolean update(Registration entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Registration> getAll() {
        return List.of();
    }
}
