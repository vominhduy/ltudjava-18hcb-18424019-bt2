/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojo.RemarkDetail;
import util.HibernateUtil;

/**
 *
 * @author vomin
 */
public class RemarkDetailDAO {
    public static List<RemarkDetail> getRemarks(Date from) {
        List<RemarkDetail> ds = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        
        try {
            String hql = "SELECT sv FROM pojo.RemarkDetail sv WHERE sv.createTime >= :from";
            Query query = session.createQuery(hql);
            query.setDate("from",from);
            ds = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    
    public static RemarkDetail getRemarkDetail(String objectCode, String studentCode, int remarkPoint) {
        List<RemarkDetail> ds = null;
        RemarkDetail tmp = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        
        try {
            String hql = "SELECT sv FROM pojo.RemarkDetail sv WHERE sv.objectCode = :objectCode AND sv.studentCode =: studentCode AND sv.remarkPoint =: remarkPoint";
            Query query = session.createQuery(hql);
            query.setString("objectCode", objectCode);
            query.setString("studentCode", studentCode);
            query.setInteger("remarkPoint", remarkPoint);
            ds = query.list();
            if (ds != null && ds.size() > 0)
                tmp = ds.get(0);
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return tmp;
    }
    
    public static boolean UpdateRemarkDetail(RemarkDetail detail)
    {
        boolean kq = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.update(detail);
            trans.commit();
            kq = true;
        } catch (Exception ex) {
            kq = false;
            trans.rollback();
            System.out.println("ERROR BT2: " + ex.getMessage());
        }
        return kq;
    }
    
    public static boolean AddRemarkDetail(RemarkDetail detail)
    {
        boolean kq = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.save(detail);
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
