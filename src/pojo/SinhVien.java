/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package pojo;

public class SinhVien implements java.io.Serializable {
    private String Code;
    private String Name;
    private String Gender;
    private String PID;
    private String ClassCode;

    public SinhVien() {
    }
    

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getClassCode() {
        return ClassCode;
    }

    public void setClassCode(String ClassCode) {
        this.ClassCode = ClassCode;
    }

    public SinhVien(String Code, String Name, String Gender, String PID, String ClassCode) {
        this.Code = Code;
        this.Name = Name;
        this.Gender = Gender;
        this.PID = PID;
        this.ClassCode = ClassCode;
    }
}