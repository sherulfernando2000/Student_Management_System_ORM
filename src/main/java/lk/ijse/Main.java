package lk.ijse;

import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {


        Configuration configuration = new Configuration();

        //add property
        Properties properties = new Properties();

        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));   //set path
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //add properties to configure
        configuration.setProperties(properties);

        //add annotated class to configure
        configuration.addAnnotatedClass(Student.class);

        //build session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        session.save(student);
        transaction.commit();
        session.close();



    }
}