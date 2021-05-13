/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Employee;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author PhanTuan
 */
public class EmployeeServices {
    // Lấy toàn bộ thông tin nhân viên
     public ArrayList<Employee> getAllRecords(){
        ArrayList<Employee> list = new ArrayList<Employee>(); // Khởi tạo danh sách NV
        try{        
            SqlDataAccess acc = new SqlDataAccess();
            ResultSet rs = acc.Query("SELECT * FROM [NHANVIEN]");

            while(rs.next()){
                Employee NV = new Employee(rs.getInt("MANV"), rs.getString("TENNV"), rs.getDate("NGAYSINH"), rs.getInt("SDT"), rs.getString("DIACHI"),rs.getString("EMAIL"));
                list.add(NV);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
     
      //Thêm
    public int AddNewRecord( int MaNV, String TenNV, Date NgaySinh, int SDT, String DiaChi, String Email){
        int rowCount = 0;
        try{
            //Định dạng ngay sinh
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");    
            String strDate = formatter.format(NgaySinh); 
            System.out.println("Date Format with yyyy-MM-dd : "+ NgaySinh );
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO NHANVIEN ( MANV, TENNV, NGAYSINH, SDT, DIACHI,EMAIL) VALUES('" + MaNV + "'" +
                    ",N'" + TenNV +"'"+
                    ",N'" + strDate +"'"+
                    ", '" + SDT   +"'" +  
                    ", '" + DiaChi       +"'" +                  
                    ", '" + Email   +"'" + 
                                  
                    ")";                    
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    //Update
    public int UpdateRecord(int MaNV, String TenNV, Date NgaySinh, int SDT, String DiaChi, String Email){
        int rowCount = 0;
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");    
            String strDate = formatter.format(NgaySinh); 
            
            System.out.println("Date Format with yyyy-MM-dd : "+ NgaySinh ); 
            SqlDataAccess acc = new SqlDataAccess();
            
            String sql = "UPDATE NHANVIEN SET TENNV=N'" + TenNV + "'" +
                    
                    ", NGAYSINH     =" + strDate       +
                    ", SDT          =" + SDT     +         
                    ", DIACHI   =" + DiaChi +
                    ", EMAIL   =" + Email +
                    " WHERE MANV = '" + MaNV +"'";
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    //Xoa
    public int DeleteRecord(int MaNV){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM NHANVIEN WHERE MANV = " + MaNV;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
     
}
