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
import pojo.Remark;
import pojo.Student;
import util.HibernateUtil;

/**
 *
 * @author vomin
 */
public class RemarkDAO {
    public static Remark getRemark() {
        List<Remark> ds = null;
        Remark tmp = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        
        try {
            String hql = "SELECT sv FROM pojo.Remark sv";
            Query query = session.createQuery(hql);
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
}
