/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojo.User;
import util.HibernateUtil;

/**
 *
 * @author vomin
 */
public class UserDAO {
    public static User getUser(String id) throws NoSuchAlgorithmException {
        List<User> ds = null;
        User tmp = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.openSession();
        
        try {
            String hql = "SELECT sv FROM pojo.User sv WHERE sv.id =: id";
            Query query = session.createQuery(hql);
            query.setString("id", id);
            ds = query.list();
            
            if (ds != null && ds.size() > 0)
            {    
                tmp = ds.get(0);
                tmp.setPassword(Md5(tmp.getPassword()));
            }
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return tmp;
    }
    
    public static String Md5(String pass) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(pass.getBytes(StandardCharsets.UTF_8));
        
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
    public static boolean UpdateUser(User user) throws NoSuchAlgorithmException
    {
        user.setPassword(Md5(user.getPassword()));
        boolean kq = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        
        Session session = sessionFactory.getCurrentSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.update(user);
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
