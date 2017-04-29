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
    public List<Users> getUsers(String userName) {
        
        
        Users u = new Users();
        List<Users> ls = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.getCurrentSession();
            t = ss.beginTransaction();
           
            String hql = "FROM Users as u where u.userName=?";
            Query query = ss.createQuery(hql);
            query.setParameter(0, userName);
            ls = query.list();
            t.commit();
        } catch (Exception e) {
            sf.getCurrentSession().beginTransaction().rollback();
            e.printStackTrace();
        } 

        return ls;
    }

}
