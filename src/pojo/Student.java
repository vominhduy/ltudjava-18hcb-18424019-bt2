package pojo;
// Generated Aug 25, 2019 11:51:13 AM by Hibernate Tools 4.3.1



/**
 * Student generated by hbm2java
 */
public class Student  implements java.io.Serializable {


     private String code;
     private String name;
     private String gender;
     private String pid;
     private String classCode;
     private Short mark1;
     private Short mark2;
     private Short mark3;
     private Short mark4;

    public Student() {
    }

	
    public Student(String code) {
        this.code = code;
    }
    public Student(String code, String name, String gender, String pid, String classCode, Short mark1, Short mark2, Short mark3, Short mark4) {
       this.code = code;
       this.name = name;
       this.gender = gender;
       this.pid = pid;
       this.classCode = classCode;
       this.mark1 = mark1;
       this.mark2 = mark2;
       this.mark3 = mark3;
       this.mark4 = mark4;
    }
   
    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPid() {
        return this.pid;
    }
    
    public void setPid(String pid) {
        this.pid = pid;
    }
    public String getClassCode() {
        return this.classCode;
    }
    
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }
    public Short getMark1() {
        return this.mark1;
    }
    
    public void setMark1(Short mark1) {
        this.mark1 = mark1;
    }
    public Short getMark2() {
        return this.mark2;
    }
    
    public void setMark2(Short mark2) {
        this.mark2 = mark2;
    }
    public Short getMark3() {
        return this.mark3;
    }
    
    public void setMark3(Short mark3) {
        this.mark3 = mark3;
    }
    public Short getMark4() {
        return this.mark4;
    }
    
    public void setMark4(Short mark4) {
        this.mark4 = mark4;
    }




}


