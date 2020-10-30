package gorokhov;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory entityFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = entityFactory.createEntityManager();

        Product p = new Product();
        p.setTitle("tea");
        p.setPrice(12.53);
        createEntity(em, p);

        Product p2= new Product();
        p2.setTitle("banana");
        p2.setPrice(45.23);
        createEntity(em, p2);

        Client client1 = new Client();
        client1.setName("Sasha");
        createEntity(em, client1);

        Client client2 = new Client();
        client2.setName("Pasha");
        createEntity(em, client2);

        try {
            Sell sell = new Sell();
            sell.setProduct(readEntity(em,Product.class,1));
            sell.setClient(readEntity(em,Client.class,1));
            sell.setDate(new SimpleDateFormat("yyyy.MM.dd").parse("2017.11.04"));
            sell.setAmount(12);
            sell.setPrice(45.33);
            createEntity(em, sell);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Sell sellResult = em.createNamedQuery("Sell.findById", Sell.class).setParameter("id", 1).getSingleResult();
        System.out.println(sellResult);
    }

    private static <T> void createEntity(EntityManager em, T entity){

        System.out.println("Creating entity");
        //open transaction
        em.getTransaction().begin();
        //put person into persist area of Hibernate
        em.persist(entity);
        //commit/close transaction
        em.getTransaction().commit();

        System.out.println("Creating finished");

    }

    private static <T> T readEntity(EntityManager em, Class<T> clazz, int id){
        System.out.println("Start reading");

        em.getTransaction().begin();
        T person = em.find(clazz, id);
        em.getTransaction().commit();

        System.out.println("Reading completed->" + person);
        return person;
    }

    private static <T> T saveEntity(EntityManager em, T entity){
        System.out.println("Start saving");

        em.getTransaction().begin();
        T savedEntity = em.merge(entity);
        em.getTransaction().commit();

        System.out.println("Saving completed->" + savedEntity);

        return savedEntity;
    }


}
