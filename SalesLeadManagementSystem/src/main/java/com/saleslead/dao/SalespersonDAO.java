package com.saleslead.dao;

import com.saleslead.entity.Salesperson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class SalespersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Salesperson salesperson) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(salesperson);
    }

    public Salesperson get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Salesperson.class, id);
    }

    public List<Salesperson> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Salesperson", Salesperson.class).getResultList();
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Salesperson salesperson = session.get(Salesperson.class, id);
        if (salesperson != null) {
            session.delete(salesperson);
        }
    }
}
