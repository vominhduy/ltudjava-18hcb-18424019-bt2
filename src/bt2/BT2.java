/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package bt2;

import dao.ClassDAO;
import dao.StudentDAO;
import pojo.Class;
import java.util.List;
//import pojo.Student;

/**
 *
 * @author vomin
 */
public class BT2 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Class> temp = ClassDAO.getClasses();
        frmLogin lg = new frmLogin();
        lg.setTitle("18424019  -  Đăng nhập");
        lg.show();
    }
}
