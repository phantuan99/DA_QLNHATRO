/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author PhanTuan
 */
public class UserAcc {
      private int MaNV,Role;
   
   private String Password;

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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public UserAcc(int MaNV, String Password, int Role) {
        this.MaNV = MaNV;
        this.Role = Role;
        this.Password = Password;
    }
   
}
