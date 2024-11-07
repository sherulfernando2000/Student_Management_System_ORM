package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Registration;
import org.hibernate.Session;

import java.util.List;

public interface RegistrationDAO extends CrudDAO<Registration> {
    boolean saveRegistration(List<Registration> registrationList, Session session);

    int getCurrentId();
}
