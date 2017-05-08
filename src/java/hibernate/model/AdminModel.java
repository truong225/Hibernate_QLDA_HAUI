/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.model;

import hibernate.entity.Users;
import hibernate.entity.*;
import hibernate.util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javafx.scene.input.KeyCode;
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

    private SessionFactory sf = null;
    private Session ss = null;
    private Transaction t = null;

    public List<Detai> getAllDTNonActive() {
        List<Detai> ls = null;
        try {
            init();

            String hql = "FROM Detai as d where d.projectStatus = 0 and d.isdelete = 0";
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

    public List<Detai> getAllDTActive() {
        List<Detai> ls = null;
        try {
            init();

            String hql = "FROM Detai as d where d.projectStatus = 1 and d.isdelete = 0";
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

    public List<Detai> getAllDTActive1() {
        List<Detai> ls = null;
        try {
            init();
            t = ss.beginTransaction();

            String hql = "FROM Detai as d where d.projectStatus = 1 and d.isdelete = 0";
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

    public List<Users> getDSAdmin() {
        List<Users> ls = null;

        try {
            init();

            String hql = "FROM Users as u where u.userType =0 and u.userActive = 1";

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

    public List<Users> getDSHDC() {
        List<Users> ls = null;

        try {
            init();

            String hql = "FROM Users as u where u.userType =2 and u.userActive = 1 and u.userNv = 3";

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

    public List<Users> getDSGVPB() {
        List<Users> ls = null;

        try {
            init();

            String hql = "FROM Users as u where u.userType =2 and u.userActive = 1 and u.userNv = 2";

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

    public List<Users> getDSGVHD() {
        List<Users> ls = null;

        try {
            init();

            String hql = "FROM Users as u where u.userType =2 and u.userActive = 1 and u.userNv = 1";

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

    public List<Users> getDSGV() {
        List<Users> ls = null;

        try {
            init();

            String hql = "FROM Users as u where u.userType =2 and u.userActive = 1";

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

    public List<Users> getDSSV() {
        List<Users> ls = null;

        try {
            init();

            String hql = "FROM Users as u where u.userType =1 and u.userActive = 1";

            Query query = ss.createQuery(hql);
            ls = query.list();
            t.commit();
            //ss.close();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            ss.close();
        }
        return ls;
    }

    public List<Users> getUsersAd(Users users) {

        List<Users> ls = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            t = ss.beginTransaction();
            String hql = "FROM Users as u where u.userName=? and u.userPassword=? and u.userActive = 1 and u.userType = 0";
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
        } finally {
            ss.close();
        }

        return ls;
    }

    public List<Users> getUsers(Users users) {

        List<Users> ls = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            t = ss.beginTransaction();
            String hql = "FROM Users as u where u.userName=? and u.userPassword=? and u.userActive = 1";
            Query query = ss.createQuery(hql);
            query.setParameter(0, users.getUserName());
            query.setParameter(1, users.getUserPassword());
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

    public List<Users> getUsers(Integer userId) {

        List<Users> ls = null;

        try {
            init();
            String hql = "FROM Users as u where u.userId=?";
            Query query = ss.createQuery(hql);
            query.setParameter(0, userId);

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

    public boolean InsertSV(Users users) {
        boolean check = false;
        try {
            init();
            users.setUserActive(true);
            users.setUserNv(0);
            users.setUserCountLogin(0);
            ss.save(users);
            t.commit();
            check = true;

        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            check = false;
        } finally {
            ss.close();
        }

        return check;

    }

    public boolean InsertDT(Detai dt) {
        boolean check = false;
        try {
            init();
            dt.setProjectStatus(true);
            dt.setProjectPagecount(0);
            dt.setProjectViewcount(0);
            dt.setIsdelete(false);
            ss.save(dt);
            t.commit();
            check = true;

        } catch (Exception e) {
            t.rollback();
            //e.printStackTrace();
            check = false;
        } finally {
            ss.close();
        }

        return check;

    }

    public boolean Update(Users users) {
        boolean check = false;
        try {
            Users newItem = users;
            sf = HibernateUtil.getSessionFactory();
            ss = sf.openSession();
            t = ss.beginTransaction();
            ss.update(newItem);

            t.commit();
            check = true;
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            check = false;
        } finally {
            ss.close();
        }

        return check;
    }

    public boolean Delete(Integer userId) {
        boolean check = false;
        try {
            List<Users> ls = getUsers(userId);
            Users users = ls.get(0);
            users.setIsdelete(true);
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dateDelete = sdf.format(date);
            users.setDeleteDate(dateDelete);
            users.setUserActive(false);
            init();
            ss.update(users);
            t.commit();
            check = true;
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
            check = false;
        } finally {
            // ss.close();
        }

        return check;
    }

    public void init() {
        sf = HibernateUtil.getSessionFactory();
        ss = sf.openSession();
        t = ss.beginTransaction();
    }

    public static void main(String[] args) {
        AdminModel model = new AdminModel();
        Detai dt = new Detai();
        dt.setProjectName("test");
        dt.setProjectInstructorid(3);
        model.InsertDT(dt);

    }
}
