/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package pojo;
import java.util.Date;
public class SinhVien implements java.io.Serializable {
    private String Code;
    private String Name;
    private String Gender;
    private String PID;
    private String ClassCode;
    
    public SinhVien() {
    }
    public SinhVien(String maSinhVien) {
        this.Code = maSinhVien;
    }
    public SinhVien(String maSinhVien, String hoVaTen, String
            gioiTinh, String cmnd, String maLop) {
        this.Code = maSinhVien;
        this.Name = hoVaTen;
        this.Gender = gioiTinh;
        this.PID = cmnd;
        this.ClassCode = maLop;
    }

    public String getMaSinhVien() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getHoVaTen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNgaySinh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDiaChi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}