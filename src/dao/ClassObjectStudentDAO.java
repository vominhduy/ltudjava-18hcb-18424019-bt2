/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojo.ClassObjectStudent;
import pojo.Student;
import util.HibernateUtil;

/**
 *
 * @author vomin
 */
public class ClassObjectStudentDAO {
    public static List<ClassObjectStudent> getObjectByClass(String classCode) {
        List<ClassObjectStudent> ds = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        
        try {
            String hql = "FROM pojo.ClassObjectStudent sv WHERE sv.classCode =:classCode";
            Query query = session.createQuery(hql);
            query.setString("classCode", classCode);
            ds = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    
    public static List<ClassObjectStudent> getObjects() {
        List<ClassObjectStudent> ds = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        
        try {
            String hql = "FROM pojo.ClassObjectStudent sv";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    
    public static boolean AddObject(ClassObjectStudent object)
    {
        boolean kq = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.save(object);
            trans.commit();
            kq = true;
        } catch (Exception ex) {
            kq = false;
            trans.rollback();
            System.out.println("ERROR BT2: " + ex.getMessage());
        }
        return kq;
    }
}
