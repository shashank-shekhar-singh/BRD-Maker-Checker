package com.ssnk.dao;

import com.ssnk.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    @Override
    public void insert(User user) {
        this.hibernateTemplate.save(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        user.setUserId(getUserId(user));
        this.hibernateTemplate.update(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        user.setUserId(getUserId(user));
        hibernateTemplate.delete(user);
    }

    @Override
    public List<User> getAll() {
        return hibernateTemplate.loadAll(User.class);
    }

    @Override
    public User getUser(int id) {
        return hibernateTemplate.get(User.class, id);
    }

    @Override
    public User findUserByUsername(String username) {
        String hql = "FROM User U WHERE U.username='" + username +"'";
        Session session;
        try {
            session = hibernateTemplate.getSessionFactory().getCurrentSession();
        }
        catch (Exception e) {
            logger.error(e);
            session = hibernateTemplate.getSessionFactory().openSession();
        }
        Query query = session.createQuery(hql);
        return (User) query.getSingleResult();
    }


    public int getUserId(User user) {
        String hql = "SELECT U.userId FROM User U WHERE U.username='" + user.getUsername() +"'";
        Query query = Objects.requireNonNull(hibernateTemplate.getSessionFactory()).getCurrentSession().createQuery(hql);
        return (int) query.getSingleResult();
    }
}
