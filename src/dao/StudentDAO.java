/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package dao;

import java.io.FileInputStream;
import util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojo.Student;

/**
 *
 * @author vomin
 */
public class StudentDAO {
    public static List<Student> getStudents() {
        List<Student> ds = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        
        try {
            String hql = "SELECT sv FROM pojo.Student sv";
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
    
    public static List<Student> getStudentsByClass(String classCode) {
        List<Student> ds = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        
        try {
            String hql = "FROM pojo.Student sv WHERE sv.classCode =:classCode";
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
    public static boolean AddStudent(Student student)
    {
        boolean kq = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.save(student);
            trans.commit();
            kq = true;
        } catch (Exception ex) {
            kq = false;
            trans.rollback();
            System.out.println("ERROR BT2: " + ex.getMessage());
        }
        return kq;
    }
    
    public static Student getStudent(String code)
    {
        List<Student> ds = null;
        Student std = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        try {
            String hql = "FROM pojo.Student sv WHERE sv.code =:code";
            Query query = session.createQuery(hql);
            query.setString("code", code);
            ds = query.list();
            if (ds != null && ds.size() > 0)
                std = ds.get(0);
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return std;
    }
}
