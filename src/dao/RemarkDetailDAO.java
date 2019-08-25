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
}
