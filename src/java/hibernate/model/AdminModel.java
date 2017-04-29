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

/**
 *
 * @author we
 */
public class AdminModel {
    SessionFactory sf = HibernateUtil.getSessionFactory();

    
    public List<Users> getUsers(String userName){
        Users u = new Users();
        List<Users> ls=null;
        try{
        sf.getCurrentSession().beginTransaction();
        String hql = "FROM Users as u where u.userName=?";
        Query query = sf.getCurrentSession().createQuery(hql);
        query.setParameter(0, userName);
        ls = query.list();
        
      
        }
        catch (Exception e){
            sf.getCurrentSession().beginTransaction().rollback();
            e.printStackTrace();
        }finally{
            sf.getCurrentSession().beginTransaction().commit();
        }
        
        return ls;
    }
    
    
    
    
}
