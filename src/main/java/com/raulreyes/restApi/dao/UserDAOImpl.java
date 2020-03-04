package com.raulreyes.restApi.dao;

import com.raulreyes.restApi.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "FROM User";
        Query theQuery = currentSession.createQuery(hql, User.class);
        List<User> users = theQuery.getResultList();

        return users;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void save(User user) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(user);
    }

    @Override
    public void deleteById(int id) {

    }
}
