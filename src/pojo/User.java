package pojo;
// Generated Aug 25, 2019 1:13:02 PM by Hibernate Tools 4.3.1



/**
 * User generated by hbm2java
 */
public class User  implements java.io.Serializable {


     private String id;
     private String password;
     private boolean isAdmin;

    public User() {
    }

    public User(String id, String password, boolean isAdmin) {
       this.id = id;
       this.password = password;
       this.isAdmin = isAdmin;
    }
   
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isIsAdmin() {
        return this.isAdmin;
    }
    
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }




}


