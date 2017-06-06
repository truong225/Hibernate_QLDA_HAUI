/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.model;

import hibernate.entity.Detai;
import hibernate.entity.Message;
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
    
    //Lay User qua ten dang nhap va mat khau
    public Users getUserByUsername(String username, String pw){
        Users users = null;
        try {
            init();
            String hql = "FROM Users as u where u.userName = ? and u.userPassword = ?";
            Query query = ss.createQuery(hql);
            query.setString(0, username);
            query.setString(1, pw);
            users = (Users) query.uniqueResult();
            t.commit();
        } catch (Exception e) {
            t.rollback();
        }finally{
            ss.close();
        }
        return users;
        
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
            String hql = "FROM Users as u where u.userName=? and u.userPassword=? and u.userActive = 1";
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
            String hql = "FROM Detai as d where d.projectStudentid =?";
            Query query = ss.createQuery(hql);
            query.setParameter(0, id);
            Detai detai = (Detai) query.uniqueResult();
            projectId = detai.getProjectId();
             t.commit();
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
             t.commit();
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
            String hql = "FROM Tiendo as u where u.detai.projectId=? and u.projectStudentid = ? and u.tdStatus=1";
            Query query = ss.createQuery(hql);
            query.setInteger(0, projectId);
            query.setInteger(1, id);
            ls = query.list();
             t.commit();
        } catch (Exception e) {
        }finally{
            ss.close();
        }
        return ls;
    }
    
    //Lay DS de tai theo ID GV
    public List<Detai> getAllDTByUserID(int userID){
        List<Detai> ls = null;
        try {
            init();
            String hql = "FROM Detai as d where d.projectInstructorid = ? and d.projectStudentid < 0 and d.projectProgress = ? and d.projectCancel=?";
            Query query = ss.createQuery(hql);
            query.setInteger(0, userID);
            query.setInteger(1, 0);
            query.setBoolean(2, false);
            ls = query.list();
             t.commit();
        } catch (Exception e) {
            t.rollback();
        }finally{
            ss.close();
        }
        return ls;
    }
    //Lay user theo ID
    public Users getUserByID(int id){
        Users user = null;
        
        try {
            init();
            String hql = "FROM Users as u where u.id="+id;
            Query query = ss.createQuery(hql);
            user = (Users) query.uniqueResult();
             t.commit();
        } catch (Exception e) {
            t.rollback();
        }finally{
            ss.close();
        }
        return user;
    }
    
    //Lay danh sach giang vien theo DS DT
    public List<Users> getAllGVByDSDT(List<Detai> lsDT){
        List<Users> lsUsers= new ArrayList<Users>();
        for(Detai i:lsDT){
            Users u = getUserByID(i.getProjectInstructorid());
            lsUsers.add(u);
        }
        return lsUsers;
    }
    
    //Lay danh sach de tai theo khoa
    public List<Detai> getAllDT(String faculty){
        List<Users> lsGV = null;
        List<Detai> ls = new ArrayList<>();
        List<Detai> ls1 = null;
        try {
            lsGV = getAllDSGVByID(faculty);
            for(Users i:lsGV){
                ls1 = new ArrayList<>();
                ls1 = getAllDTByUserID(i.getUserId());
                for(Detai j:ls1){
                    ls.add(j);
                }
            }
    
        } catch (Exception e) {
            
        }
        return ls;
    }
    
    //Lay de tai theo id
    public Detai getProjectById(int id){
        Detai dt = null;
        
        try {
            init();
            String hql = "FROM Detai as d where d.projectId = ?";
            Query query = ss.createQuery(hql);
            query.setInteger(0, id);
            dt = (Detai) query.uniqueResult();
             t.commit();
        } catch (Exception e) {
            t.rollback();
        }finally{
            ss.close();
        }
        return dt;
    }

    //Dang ki de tai
    public boolean regisProject(int dtId, int userId){
        Detai dt = getProjectById(dtId);
        boolean check = false;
        try {
            init();
            dt.setProjectStudentid(userId);
            ss.update(dt);
            
            Message message = new Message(dt.getProjectId(), userId, dt.getProjectInstructorid(), 1, 0, "", 0);
            ss.save(message);
            t.commit();
            check = true;
        } catch (Exception e) {
            t.rollback();
        }finally{
            ss.close();
        }
        
        return check;
    }
    
    //Kiem tra xem sinh vien da dang ki de tai chuwa
    public boolean checkRegis(int id){
        boolean check = false;
        try {
            init();
            String hql = "FROM Detai as d where d.users.userId=? and d.projectStatus = ? and d.projectCancel=? ";
            Query query = ss.createQuery(hql);
            query.setInteger(0, id);
            query.setBoolean(1, false);
            query.setBoolean(2, false);
            List<Detai> ls = query.list();
            t.commit();
            if(ls.size()==0){
                check = true;
            }
        } catch (Exception e) {
            t.rollback();
        }finally{
            ss.close();
        }
        return check;
    }
    
}
