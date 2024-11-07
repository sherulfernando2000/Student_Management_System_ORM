 package lk.ijse.config;


import lk.ijse.entity.Payment;
import lk.ijse.entity.Program;
import lk.ijse.entity.Registration;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

 public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration(){
        /*Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);

        sessionFactory = configuration.buildSessionFactory();*/
        Configuration configuration = new Configuration();

        //add property
        Properties properties = new Properties();

        //add already created hibernate file to properies in current thread
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));   //set path
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //add properties to configure
        configuration.setProperties(properties);

        //add annotated class to configure
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Program.class);
        configuration.addAnnotatedClass(Registration.class);
        configuration.addAnnotatedClass(Payment.class);

        //build session factory
         sessionFactory = configuration.buildSessionFactory();


    }

    public static FactoryConfiguration getInstance(){
        if(factoryConfiguration == null){
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
