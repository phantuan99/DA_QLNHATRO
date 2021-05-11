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
//Get,Set và Constructor
public class Employee {
   private int MaNV, SDT;
   
   private String TenNV,DiaChi,Email;
   private Date NgaySinh;

    public Employee(int MaNV, String TenNV, Date NgaySinh, int SDT, String DiaChi, String Email) {
        this.MaNV = MaNV;
        this.SDT = SDT;
 
        this.TenNV = TenNV;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.NgaySinh = NgaySinh;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public int getSDT() {
        return SDT;
    }

    public void setSDT(int SDT) {
        this.SDT = SDT;
    }

   

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    
   
   
   
}
