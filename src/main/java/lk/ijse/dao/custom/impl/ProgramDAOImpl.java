package lk.ijse.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.custom.ProgramDAO;
import lk.ijse.dto.ProgramDTO;
import lk.ijse.entity.Program;
import lk.ijse.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ProgramDAOImpl implements ProgramDAO {

    @Override
    public boolean save(Program entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Object program = session.save(entity);
        System.out.println(program);

        if (program != null) {
            transaction.commit();
            session.close();
            return true;
        }else{
            return false;
        }
    }


    @Override
    public boolean update(Program entity) {
        try {
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return false;

        }
    }

    @Override
    public boolean delete(String id) {
        try {
            Session session = FactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("delete from Program where pId = ?1");
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

    @Override
    public List<Program> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Program ");
        List<Program> programs = query.list();
        return programs;
    }

    public  String getCurrentId() throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT MAX(CAST(SUBSTRING(p.pId, 3) AS integer)) FROM Program p";

        Query query = session.createQuery(hql);
        //String currentId = (String) query.uniqueResult();
        Integer id = (Integer) query.uniqueResult();
        if(id == null){
            return null;
        }else {
            String currentId = id.toString();
            System.out.println(currentId);
            return currentId;
        }
    }

    public Program searchId(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction trancation = session.beginTransaction();

        Query query = session.createQuery("from Program where pId = ?1");
        query.setParameter(1,id);
        Program program = (Program) query.uniqueResult();
        trancation.commit();
        session.close();
        return program;
    }

    @Override
    public Program searchByName(String name) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction trancation = session.beginTransaction();

        Query query = session.createQuery("from Program where pName = ?1");
        query.setParameter(1,name);
        Program program = (Program) query.uniqueResult();
        trancation.commit();
        session.close();
        return program;
    }

}
