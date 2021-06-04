/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author vuhuynh
 */
public class Customer {
    private int MAKH;
    private String TENKH;
    private Date NGAYSINH;
    private String SDT;
    private String DIACHI;
    private String Email;
//Constructor
    public Customer(int MAKH, String TENKH, Date NGAYSINH, String SDT, String DIACHI, String Email) {
        this.MAKH = MAKH;
        this.TENKH = TENKH;
        this.NGAYSINH = NGAYSINH;
        this.SDT = SDT;
        this.DIACHI = DIACHI;
        this.Email = Email;
    }
// Khởi tạo GET,SET
    public int getMAKH() {
        return MAKH;
    }

    public void setMAKH(int MAKH) {
        this.MAKH = MAKH;
    }

    public String getTENKH() {
        return TENKH;
    }

    public void setTENKH(String TENKH) {
        this.TENKH = TENKH;
    }

    public Date getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(Date NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
