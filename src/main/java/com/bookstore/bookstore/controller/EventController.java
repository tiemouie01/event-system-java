package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.model.Event;
import com.bookstore.bookstore.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class EventController {
    public EventController() {
    }

    public void saveBook(Event event){
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(event);
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    public Event geBookrById(int id){
        Transaction tx = null;
        Event event = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            event = session.find(Event.class,id);
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
        return event;
    }
    public List<Event> getBooks(){
        List<Event> events = new ArrayList<>();
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query<Event> productQuery = session.createQuery("FROM Event",Event.class);
            events = productQuery.getResultList();
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
        return events;
    }
    public void updateBooks(Event event){
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.merge(event);
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
