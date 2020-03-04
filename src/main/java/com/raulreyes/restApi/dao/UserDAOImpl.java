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
        System.out.println("ssss");
        Session currentSession = entityManager.unwrap(Session.class);
        String hql = "select u FROM User u";
        Query theQuery = currentSession.createQuery(hql, User.class);
        List<User> users = theQuery.getResultList();
        return users;
    }

    @Override
    public User findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return  currentSession.get(User.class, id);
    }

    @Override
    public void save(User user) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(user);
    }

    @Override
    public String deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        User user = currentSession.get(User.class, id);
        if(user == null){
            throw new RuntimeException("user id no found");
        }
        currentSession.getTransaction().begin();
        currentSession.remove(user);
        currentSession.getTransaction().commit();
        return "user deleted";
    }
}
