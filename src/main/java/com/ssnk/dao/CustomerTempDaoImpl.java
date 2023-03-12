package com.ssnk.dao;

import com.ssnk.entity.CustomerTemp;
import com.ssnk.entity.RecordStatus;
import com.ssnk.entity.User;
import com.ssnk.service.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Repository
public class CustomerTempDaoImpl implements CustomerTempDao {

    private static final Logger logger = LogManager.getLogger(CustomerTempDaoImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void insert(CustomerTemp customerTemp) {
        customerTemp.setRecordStatus(RecordStatus.N);
        customerTemp.setActiveFlag(true);
        customerTemp.setCreatedBy(Integer.toString(userDao.findUserByUsername(UserServiceImpl.getCurrentUsersUsername()).getUserId()));
        customerTemp.setModifiedBy(customerTemp.getCreatedBy());
        this.hibernateTemplate.saveOrUpdate(customerTemp);
    }

    @Transactional
    @Override
    public void update(int id) {
        CustomerTemp customerTemp = getCustomerTemp(id);
        customerTemp.setRecordStatus(RecordStatus.N);
        customerTemp.setModifiedBy(Integer.toString(userDao.findUserByUsername(UserServiceImpl.getCurrentUsersUsername()).getUserId()));
        customerTemp.setId(getCustomerTempId(customerTemp));
        this.hibernateTemplate.update(customerTemp);
    }

    @Transactional
    @Override
    public void delete(int id) {
        hibernateTemplate.delete(getCustomerTemp(id));
    }

    @Override
    public List<CustomerTemp> getAll() {
        logger.info("Calling getAll Temp Customers...");
        return hibernateTemplate.loadAll(CustomerTemp.class);
    }

    @Override
    public CustomerTemp getCustomerTemp(int id) {
        return hibernateTemplate.get(CustomerTemp.class, id);
    }

    public int getCustomerTempId(CustomerTemp customerTemp) {
        String hql = "SELECT C.id FROM CustomerTemp C WHERE C.contactNumber='" + customerTemp.getContactNumber() +"'";
        Query query = Objects.requireNonNull(hibernateTemplate.getSessionFactory()).getCurrentSession().createQuery(hql);
        return (int) query.getSingleResult();
    }
}
