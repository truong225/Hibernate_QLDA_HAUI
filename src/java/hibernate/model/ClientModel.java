/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.model;

import hibernate.entity.Detai;
import hibernate.entity.Tiendo;
import hibernate.entity.Users;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 *
 * @author we
 */
public class ClientModel {

    private SessionFactory sf = null;
    private Session ss = null;
    private Transaction t = null;

    //Lay danh sách khoa
    public List getAllFaculty() {
        init();
        List listFaculty = new ArrayList<>();
        //DISTINCT by user_faculty
        listFaculty = ss.createCriteria(Users.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.distinct(Projections.property("userFaculty")))
                ).list();

        return listFaculty;
    }

    //Lay danh sách GV theo khoa
    public List<Users> getAllDSGVByID(String faculty) {
        List<Users> ls = null;
        try {
            init();
            String hql = "FROM Users as a where a.userType = 2 and a.userFaculty = '" + faculty + "'";
            Query query = ss.createQuery(hql);
            ls = query.list();
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            ss.close();
        }
        return ls;
    }

    public void init() {
        sf = HibernateUtil.getSessionFactory();
        ss = sf.openSession();
        t = ss.beginTransaction();
    }

    //Lay danh sach sinh vien
    public List<Users> getUsersSV(Users users) {

        List<Users> ls = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            t = ss.beginTransaction();
            String hql = "FROM Users as u where u.userName=? and u.userPassword=? and u.userActive = 1 and u.userType = 1";
            Query query = ss.createQuery(hql);
            query.setParameter(0, users.getUserName());
            query.setParameter(1, users.getUserPassword());
            ls = query.list();
            t.commit();
            if (ls.size() > 0) {
                Users newItem = ls.get(0);
                Integer countLogin = newItem.getUserCountLogin();
                countLogin++;
                newItem.setUserCountLogin(countLogin);
                t = ss.beginTransaction();
                ss.save(newItem);
                t.commit();
            }

        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        }
        return ls;
    }

    //Lay de tai dang thuc hien 
    public int getIDProject(int id) {
        int projectId = 0;
        try {
            init();
            String hql = "FROM Detai as d where d.users.userId =?";
            Query query = ss.createQuery(hql);
            query.setParameter(0, id);
            Detai detai = (Detai) query.uniqueResult();
            projectId = detai.getProjectId();
        } catch (Exception e) {
        }
        return projectId;
    }

    //Lay userID theo username
    public int getUserIdByUsername(String id) {
        int userId = -1;
        try {
            init();
            String hql = "FROM Users as u where u.userName=? and u.userActive = 1 and u.userType = 1";
            Query query = ss.createQuery(hql);
            query.setParameter(0, id);
            Users users = (Users) query.uniqueResult();
            userId = users.getUserId();
        } catch (Exception e) {
        }finally{
            ss.close();
        }
        return userId;
    }

    //Lay DS tien do
    public List<Tiendo> getAllTD(int id) {
        List<Tiendo> ls = null;
        try {
            ls = new ArrayList<>();
            init();
            int projectId = getIDProject(id);
            String hql = "FROM Tiendo as u where u.detai.projectId = ? and u.tdStatus=1";
            Query query = ss.createQuery(hql);
            query.setInteger(0, projectId);
            ls = query.list();
            
        } catch (Exception e) {
        }finally{
            ss.close();
        }

        return ls;
    }

}
