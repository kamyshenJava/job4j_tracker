package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        int id = (int) session.save(item);
        item.setId(id);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        int rsl =
                session.createQuery("update Item i set i.name = :newName, i.created = :newCreated where i.id = :fId")
                .setParameter("newName", item.getName())
                .setParameter("newCreated", item.getCreated())
                .setParameter("fId", id)
                        .executeUpdate();
        session.getTransaction().commit();
        session.close();
        return rsl > 0;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        int rsl = session.createQuery("delete from Item i where i.id = :fId")
                .setParameter("fId", id)
                .executeUpdate();
        session.getTransaction().commit();
        session.close();
        return rsl > 0;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("From Item");
        session.getTransaction().commit();
        List<Item> rsl = query.list();
        session.close();
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("From Item i where i.name = :key").setParameter("key", key);
        session.getTransaction().commit();
        List<Item> rsl = query.list();
        session.close();
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("From Item i where i.id = :id").setParameter("id", id);
        session.getTransaction().commit();
        Item rsl = (Item) query.uniqueResult();
        session.close();
        return rsl;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
