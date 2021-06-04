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
    //khai báo các biến chứa thông tin đối tượng Khách hàng gồm: mã khách hàng, tên khách hàng, ngày sinh, số điện thoại,địa chỉ, email
    private int MAKH;
    private String TENKH;
    private Date NGAYSINH;
    private String SDT;
    private String DIACHI;
    private String Email;
    
    //phương thức khởi tạo của đối tượng khách hàng
    public Customer(int MAKH, String TENKH, Date NGAYSINH, String SDT, String DIACHI, String Email) {
        this.MAKH = MAKH;
        this.TENKH = TENKH;
        this.NGAYSINH = NGAYSINH;
        this.SDT = SDT;
        this.DIACHI = DIACHI;
        this.Email = Email;
    }
    //phương thức đọc mã khách hàng
    public int getMAKH() {
        return MAKH;
    }
    //phương thức ghi mã khách hàng
    public void setMAKH(int MAKH) {
        this.MAKH = MAKH;
    }
    //phương thức đọc tên khách hàng
    public String getTENKH() {
        return TENKH;
    }
    //phương thức ghi tên khách hàng
    public void setTENKH(String TENKH) {
        this.TENKH = TENKH;
    }
    //phương thức đọc ngày sinh khách hàng
    public Date getNGAYSINH() {
        return NGAYSINH;
    }
    //phương thức ghi ngày sinh khách hàng
    public void setNGAYSINH(Date NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }
    //phương thức đọc số điện thoại
    public String getSDT() {
        return SDT;
    }
    //phương thức ghi số điện thoại
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    //phương thức đọc địa chỉ
    public String getDIACHI() {
        return DIACHI;
    }
    //phương thức ghi địa chỉ
    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }
    //phương thức đọc email
    public String getEmail() {
        return Email;
    }
    //phương thức ghi email
    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    
}
