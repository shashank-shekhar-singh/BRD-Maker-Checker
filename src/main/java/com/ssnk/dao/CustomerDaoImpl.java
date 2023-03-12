package com.ssnk.dao;

import com.ssnk.entity.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private static final Logger logger = LogManager.getLogger(CustomerDaoImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    @Override
    public void saveOrUpdate(Customer customer) {
        this.hibernateTemplate.saveOrUpdate(customer);
    }

    @Transactional
    @Override
    public void update(Customer customer) {
        customer.setId(getCustomerId(customer));
        this.hibernateTemplate.update(customer);
    }

    @Transactional
    @Override
    public void delete(Customer customer) {
        customer.setId(getCustomerId(customer));
        hibernateTemplate.delete(customer);
    }

    @Override
    public List<Customer> getAll() {
        return hibernateTemplate.loadAll(Customer.class);
    }

    @Override
    public Customer getCustomer(long id) {
        return hibernateTemplate.get(Customer.class, id);
    }

    public int getCustomerId(Customer customer) {
        String hql = "SELECT C.id FROM customer C WHERE C.contactNumber='" + customer.getContactNumber() +"'";
        Query query = Objects.requireNonNull(hibernateTemplate.getSessionFactory()).getCurrentSession().createQuery(hql);
        return (int) query.getSingleResult();
    }
}
