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
import pojo.Object;
import util.HibernateUtil;

/**
 *
 * @author vomin
 */
public class ObjectDAO {
    public static List<Object> getObjects() {
        List<Object> ds = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        
        try {
            String hql = "FROM pojo.Object sv";
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
    public static boolean AddObject(Object object)
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
    
    public static Object getObject(String code) {
        Object obj = null;
        
        List<Object> ds = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        
        try {
            String hql = "FROM pojo.Object sv WHERE sv.code =:code";
            Query query = session.createQuery(hql);
            query.setString("code", code);
            ds = query.list();
            obj = ds.get(0);
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        
        return obj;
    }
}
