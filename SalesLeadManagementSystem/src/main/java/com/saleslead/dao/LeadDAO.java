package com.saleslead.dao;

import com.saleslead.entity.Lead;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
@Transactional
public class LeadDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Lead lead) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(lead);
    }

    public Lead get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Lead.class, id);
    }

    public List<Lead> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Lead", Lead.class).getResultList();
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Lead lead = session.get(Lead.class, id);
        if (lead != null) {
            session.delete(lead);
        }
    }
}
