    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author PhanTuan
 */
/**
 * 
 * Chứa Constructor và Getter, Setter của User Account
 */
public class UserAcc {
   private int MaNV,Role,SDT; 
   private String Password,TENNV,EMAIL,DIACHI;
   private Date NgaySinh;

    

    public UserAcc(int MaNV,String Password, int Role, String TENNV,int SDT,String EMAIL, String DIACHI,Date NgaySinh) {
        this.MaNV = MaNV;
        this.Role = Role;
        this.SDT = SDT;
        this.Password = Password;
        this.TENNV = TENNV;
        this.EMAIL = EMAIL;
        this.DIACHI = DIACHI;
        this.NgaySinh = NgaySinh;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int Role) {
        this.Role = Role;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTENNV() {
        return TENNV;
    }

    public void setTENNV(String TENNV) {
        this.TENNV = TENNV;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }
    
    public Date getNgaySinh() {
            return NgaySinh;
        }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
   
   

    
   
}
