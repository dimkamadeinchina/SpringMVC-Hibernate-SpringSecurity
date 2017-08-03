package com.example.Util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class HibernateUtil {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public <T> T fetchById(Class<T> entityClass, Serializable id) {
        return (T)sessionFactory.getCurrentSession().get(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> fetchAll(Class<T> entityClass) {
        return sessionFactory.getCurrentSession().createQuery(" FROM "+entityClass.getName()).list();
    }

    public <T> void save(final T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    @SuppressWarnings("rawtypes")
    public <T> List fetchAll(String query) {
        return sessionFactory.getCurrentSession().createSQLQuery(query).list();
    }

}
