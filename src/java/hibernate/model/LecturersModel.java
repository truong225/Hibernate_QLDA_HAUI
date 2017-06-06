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
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author we
 */
public class LecturersModel {

    private SessionFactory sf = null;
    private Session ss = null;
    private Transaction t = null;
    
    
    
    public void init() {
        sf = HibernateUtil.getSessionFactory();
        ss = sf.openSession();
        t = ss.beginTransaction();
    }
    
    public void close(){
        ss.close();
    }
    
    public void rollback(){
        t.rollback();
    }
    
    public void commit(){
        t.commit();
    }
    
    //Lay danh sach Message
    public List<Message> getAllMessageApprove(int userId){
        List<Message> lsMes = null;
        try {
            init();
            String hql = "FROM Message as m where m.messageStatus=0 and m.messageLecturerId = ?";
            Query query = ss.createQuery(hql);
            query.setInteger(0, userId);
            lsMes = query.list();
            commit();
        } catch (Exception e) {
            rollback();
        }finally{
            close();
        }
        return lsMes;
    }
    
    //Lay user theo ID
    public Users getUserByID(int id){
        Users user = null;
        
        try {
            init();
            String hql = "FROM Users as u where u.id="+id;
            Query query = ss.createQuery(hql);
            user = (Users) query.uniqueResult();
             rollback();
        } catch (Exception e) {
            t.rollback();
        }finally{
            close();
        }
        return user;
    }
    
    //Lay de tai theo ID
    public Detai getProjectByID(int id){
         Detai project = null;
        try {
            init();
            String hql = "FROM Detai as u where u.projectId="+id;
            Query query = ss.createQuery(hql);
            project = (Detai) query.uniqueResult();
             rollback();
        } catch (Exception e) {
            t.rollback();
        }finally{
            close();
        }
        return project;
    }
    
    //Lay Messenger theo ID
     public Message getMesByID(int id){
        Message mes = null;
        try {
            init();
            String hql = "FROM Message as m where m.messageId="+id;
            Query query = ss.createQuery(hql);
            mes = (Message) query.uniqueResult();
             rollback();
        } catch (Exception e) {
            t.rollback();
        }finally{
            close();
        }
        return mes;
    }
    
    //Update Messenger
    public boolean updateMessage(Message mes){
        boolean check = false;
        try {
            init();
            ss.update(mes);
            commit();
            check = true;
        } catch (Exception e) {
            rollback();
        }finally{
            close();
        }
        return check;
    }
    
    //Update Detai
    public boolean updateProject(Detai dt){
        boolean check = false;
        try {
            init();
            ss.update(dt);
            commit();
            check = true;
        } catch (Exception e) {
            rollback();
        }finally{
            close();
        }
        return check;
    }
    
    //Update User
    public boolean updateUser(Users user){
        boolean check = false;
        try {
            init();
            ss.update(user);
            commit();
            check = true;
        } catch (Exception e) {
            rollback();
        }finally{
            close();
        }
        return check;
    }
    
    //Lay danh sach de tai dang huong dan
    public List<Detai> getListProjectOngoing(int userId){
        List<Detai> lsProject = null;
        try {
            init();
            String hql = "FROM Detai as d where d.projectInstructorid = ? and d.projectStudentid > -1 and d.isdelete = ? and d.projectProgress>0";
            Query query = ss.createQuery(hql);
            query.setInteger(0, userId);
            query.setBoolean(1, false);
            lsProject = query.list();
            commit();
        } catch (Exception e) {
            rollback();
        }finally{
            close();
        }
        
        return lsProject;
    }
    
    //Lay danh sach de tai cua minh
    public List<Detai> getListProject(int userId){
        List<Detai> lsProject = null;
        try {
            init();
            String hql = "FROM Detai as d where d.projectInstructorid = ? and d.isdelete = ?";
            Query query = ss.createQuery(hql);
            query.setInteger(0, userId);
            query.setBoolean(1, false);
            lsProject = query.list();
            commit();
        } catch (Exception e) {
            rollback();
        }finally{
            close();
        }
        
        return lsProject;
    }
    
    //Lay danh sach tien do theo de tai
    public List<Tiendo> getAllTDbyProjectId(int id){
         List<Tiendo> lsProject = null;
        try {
            init();
            String hql = "FROM Tiendo as t where t.detai.projectId = ? and t.isdelete = ?";
            Query query = ss.createQuery(hql);
            query.setInteger(0, id);
            query.setBoolean(1, false);
            lsProject = query.list();
            commit();
        } catch (Exception e) {
            rollback();
        }finally{
            close();
        }
        
        return lsProject;
    }
    
    //Them tien do
    public boolean addProcess(Tiendo td){
        boolean check = false;
        try {
            init();
            ss.save(td);
            commit();
            check = true;
        } catch (Exception e) {
            rollback();
        }finally{
            close();
        }
        return check;
    }
    
    //Them de tai
    public boolean addProject(Detai project){
        boolean check = false;
        try {
            init();
            ss.save(project);
            commit();
            check = true;
        } catch (Exception e) {
            rollback();
        }finally{
            close();
        }
        return check;
    }
}
