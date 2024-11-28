package lk.ijse.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.RegistrationDAO;
import lk.ijse.entity.Registration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public boolean  saveRegistration(List<Registration> registrationList, Session session) {

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

    @Override
    public int getCurrentId() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
       /* String hql = "SELECT rId FROM Registration r desc limit 1 ";

        Query query = session.createQuery(hql);
        //String currentId = (String) query.uniqueResult();
        Integer id = (Integer) query.uniqueResult();*/

        String hql = "SELECT r.rId FROM Registration r ORDER BY r.rId DESC";
        Query query = session.createQuery(hql);
        query.setMaxResults(1); // Limit the result to only 1 item
        Integer id = (Integer) query.uniqueResult();
        session.close();
        if(id != null){
            System.out.println(id);
            return id;

        }
        return id;
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
