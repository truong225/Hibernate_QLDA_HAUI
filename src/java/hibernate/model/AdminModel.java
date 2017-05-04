/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.model;

import hibernate.entity.Users;
import hibernate.entity.*;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author we
 */
public class AdminModel {

    SessionFactory sf = null;
    Session ss = null;
    Transaction t = null;
    
    
    public List<Detai> getAllDTNonActive(){
        List<Detai> ls = null;
        try {
            sf =HibernateUtil.getSessionFactory();
            ss = sf.getCurrentSession();
            t = ss.beginTransaction();
            
            String hql = "FROM Detai as d where d.projectStatus = 0 and d.isdelete = 0";
            Query query = ss.createQuery(hql);
            ls = query.list();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
        return ls;
    }
    
    public List<Detai> getAllDTActive(){
        List<Detai> ls = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.getCurrentSession();
            t = ss.beginTransaction();
            
            String hql = "FROM Detai as d where d.projectStatus = 1 and d.isdelete = 0";
            Query query = ss.createQuery(hql);
            ls = query.list();
            t.commit();
            
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }finally{
            
        }
        return ls;
    }
    
    public List<Users> getDSAdmin(){
        List<Users> ls = null;
        
        try {
            sf= HibernateUtil.getSessionFactory();
            ss = sf.getCurrentSession();
            t = ss.beginTransaction();
            
            String hql = "FROM Users as u where u.userType =0 and u.userActive = 1";
            
            Query query  = ss.createQuery(hql);
            ls = query.list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
        return ls;
    }
    
    public List<Users> getDSGV(){
        List<Users> ls = null;
        
        try {
            sf= HibernateUtil.getSessionFactory();
            ss = sf.getCurrentSession();
            t = ss.beginTransaction();
            
            String hql = "FROM Users as u where u.userType =0 and u.userActive = 1";
            
            Query query  = ss.createQuery(hql);
            ls = query.list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
        return ls;
    }
    
    public List<Users> getDSSV(){
        List<Users> ls = null;
        
        try {
            sf= HibernateUtil.getSessionFactory();
            ss = sf.getCurrentSession();
            t = ss.beginTransaction();
            
            String hql = "FROM Users as u where u.userType =1 and u.userActive = 1";
            
            Query query  = ss.createQuery(hql);
            ls = query.list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
        return ls;
    }
    
    public List<Users> getUsers(String userName, String userPassword) {

        List<Users> ls = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.getCurrentSession();
            t = ss.beginTransaction();
           
            String hql = "FROM Users as u where u.userName=? and u.userPassword=?";
            Query query = ss.createQuery(hql);
            query.setParameter(0, userName);
            query.setParameter(1, userPassword);
            ls = query.list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } 

        return ls;
    }
    
}
