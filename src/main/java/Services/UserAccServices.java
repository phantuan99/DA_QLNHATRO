/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.UserAcc;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author PhanTuan
 */
/**
 * 
 * Hàm chứa các phương thức truy vấn CRUD của UserAccount
 */
public class UserAccServices 
{
    /**
     * 
     * Đây là phương thức select dùng để select tất cả các giá trị
     */
    public ArrayList<UserAcc> getAllRecords(){
        ArrayList<UserAcc> list = new ArrayList<UserAcc>(); // Khởi tạo danh sách UserAccount
        try{        
            SqlDataAccess acc = new SqlDataAccess();
            ResultSet rs = acc.Query("SELECT * FROM [USERACCOUNT]");

            while(rs.next()){
                UserAcc NV = new UserAcc(rs.getInt("MANV"), rs.getString("Password"), rs.getInt("Role"),rs.getString("TENNV"),rs.getInt("SDT"),rs.getString("EMAIL"),rs.getString("DIACHI"),rs.getDate("NGAYSINH"));
                list.add(NV);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    

    
    
    

/**
 * Đây là phương thức thêm, chứa câu lệnh query để thêm vào database
 * 
 * @param Password - Mật khẩu
 * @param Role - Role
 * @param TENNV - Tên Nhân Viên
 * @param SDT - Số điện thoại
 * @param EMAIL - Địa chỉ email
 * @param DIACHI - Địa chỉ
 * @param NgaySinh - Ngày Sinh
 * @return 
 */
    public int AddNewRecord( String Password, int Role, String TENNV,int SDT,String EMAIL, String DIACHI,Date NgaySinh){
         //Định dạng ngay sinh
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");    
            String strNS = formatter.format(NgaySinh); 
            System.out.println("Date Format with yyyy-MM-dd : "+ NgaySinh );
        int rowCount = 0;
        try{            
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO USERACCOUNT (Password, Role,TENNV,SDT,EMAIL,DIACHI,NGAYSINH) VALUES(" 
                    +"'"+Password
                    +"','"+Role
                    +"',N'"+TENNV
                    +"',N'"+SDT
                    +"','"+EMAIL      
                    +"','"+DIACHI
                    +"','"+strNS       
                    +"')";   
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    /**
     * Đây là phương thức update, chứa câu lệnh query dùng để update lại giá trị trong database
     * @param MaNV - Mã nhân viên
     * @param Password - Mật khẩu
     * @param Role - Role
     * @param TENNV - Tên Nhân Viên
     * @param SDT - Số điện thoại
     * @param EMAIL - Địa chỉ email
     * @param DIACHI - Địa chỉ
     * @param NgaySinh - Ngày Sinh
     * @return 
     */
    public int UpdateRecord(int MaNV,String Password, int Role,String TENNV,int SDT,String EMAIL, String DIACHI,Date NgaySinh){
        int rowCount = 0;
        try{      
             //Định dạng ngay sinh
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");    
            String strNS = formatter.format(NgaySinh); 
            System.out.println("Date Format with yyyy-MM-dd : "+ NgaySinh );
            SqlDataAccess acc = new SqlDataAccess();
            
            String sql = "UPDATE USERACCOUNT SET Password='" + Password + "'" +   
                    ", Role=" + Role  +
                     ", TENNV =N'" + TENNV +"'" +
                    ", SDT  = '" + SDT +"'" +
                    ", EMAIL  = '" + EMAIL +"'" +
                    ", DIACHI  = '" + DIACHI +"'" +
                    ", NGAYSINH  = '" + strNS +"'" +
                    " WHERE MANV = '" + MaNV +"'";
                    
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    /**
     * Đây là phương thức delete, chứa câu lệnh query dùng để xóa các giá trị trong database
     * @param MaNV - Mã nhân viên
     * @return 
     */
    public int DeleteRecord(int MaNV){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM USERACCOUNT WHERE MANV = " + MaNV;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}