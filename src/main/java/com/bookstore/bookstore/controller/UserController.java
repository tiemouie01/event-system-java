package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.model.User;
import com.bookstore.bookstore.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;

public class UserController {
    public UserController() {
    }
    public void saveUser(User user){
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(user);
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    public User getUserById(int id){
        Transaction tx = null;
        User user = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            user = session.find(User.class,id);
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByUsername(String username){
        Transaction tx = null;
        User user = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            String hql = "FROM User u WHERE u.username = :username";
            user = session.createQuery(hql, User.class)
                    .setParameter("username", username)
                    .uniqueResult();
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query<User> productQuery = session.createQuery("FROM User",User.class);
            users = productQuery.getResultList();
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
        return users;
    }
    public void updateUser(User user){
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.merge(user);
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
