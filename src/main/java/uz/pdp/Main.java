package uz.pdp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import uz.pdp.model.Student;

public class Main {
    public static void main(String[] args) {
        // xml based configuration
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Student student = new Student();
        student.setId(55);
        student.setFullName("Toby Alderwierld");
        student.setAge(19);

        session.save(student);
        t.commit();
        System.out.println("Successfully added");
        factory.close();
        session.close();

    }
}
