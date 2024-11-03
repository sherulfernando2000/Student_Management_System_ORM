package lk.ijse.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean save(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Object student = session.save(entity);
        System.out.println(student);

        if (student != null) {
            transaction.commit();
            session.close();
            return true;
        }else{
            return false;
        }
    }

    @Override
    public  String getCurrentId() throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT MAX(CAST(SUBSTRING(s.s_id, 3) AS integer)) FROM Student s";

        Query query = session.createQuery(hql);
        //String currentId = (String) query.uniqueResult();
        Integer id = (Integer) query.uniqueResult();
        String currentId = id.toString();
        System.out.println(currentId);
        return currentId;
    }

    public boolean update(Student entity) {
        try {
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            new Alert(Alert.AlertType.ERROR,"student not updated.").show();
            return false;

        }
    }

    @Override
    public Student searchId(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction trancation = session.beginTransaction();

        Query query = session.createQuery("from Student where s_id = ?1");
        query.setParameter(1,id);
        Student student = (Student)query.uniqueResult();
        trancation.commit();
        //session.close();
        return student;
    }

    @Override
    public List<Student> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Student ");
        List<Student> students = query.list();
        return students;
    }

    public boolean delete(String id) {
        try {
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("delete from Student where s_id = ?1");
            query.setParameter(1, id);
            boolean isDelete = query.executeUpdate() > 0;
            transaction.commit();
            session.close();
            return true;

        } catch (HibernateException e) {
            new Alert(Alert.AlertType.CONFIRMATION,e.getMessage()).show();
            return false;
        }

    }




}
