/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.model;

import hibernate.entity.Users;
import hibernate.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
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

    public void init() {
        sf = HibernateUtil.getSessionFactory();
        ss = sf.openSession();
        t = ss.beginTransaction();
    }
    
}
