package com.event.controller;

import com.event.model.Booking;
import com.event.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.ArrayList;
import java.util.List;


public class BookingController {
    public BookingController() {
    }

    public void saveBook(Booking booking){
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.persist(booking);
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
    public Booking geBookById(int id){
        Transaction tx = null;
        Booking booking = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            booking = session.find(Booking.class,id);
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
        return booking;
    }
    public List<Booking> getBooks(){
        List<Booking> bookings = new ArrayList<>();
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Query<Booking> productQuery = session.createQuery("FROM Booking",Booking.class);
            bookings = productQuery.getResultList();
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
        return bookings;
    }
    public void updateBooks(Booking booking){
        Transaction tx = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.merge(booking);
            tx.commit();
        }catch (Exception e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
