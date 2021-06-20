/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PhanTuan
 */

/**
 *  
 * Hàm chứa các phương thức chứa câu truy vấn CRUD vào SQL Server của bảng Hóa đơn
 */
public class BillServices {
     /**
     * 
     * Dùng để truy vấn tất cả dữ liệu của hóa đơn
     */
    public ArrayList<Bill> getAllRecords()
    {
       
        ArrayList<Bill> list = new ArrayList<Bill>(); // Khởi tạo danh sách hợp đồng
        try
        {        
            SqlDataAccess acc = new SqlDataAccess(); //  Gọi SQL data access
            ResultSet rs = acc.Query("SELECT * FROM [HOADON]");
            while(rs.next())
            {
                Bill B = new Bill(rs.getInt("MAHD"), rs.getInt("MAKV"), rs.getInt("MAPHONG"), rs.getInt("SOKWDIEN"),rs.getInt("SOKWNUOC"),rs.getInt("TIENDIEN"),rs.getInt("TIENNUOC"),rs.getInt("THANG"),rs.getInt("NAM"),rs.getInt("TONGTIEN"));
                list.add(B);
            }            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    /**
     * Truyền vào các tham số để thêm mới dữ liệu
     * @param MAKV - Mã Khu Vực
     * @param MAPHONG - Mã Phòng
     * @param SOKWDIEN - Số KW Điện
     * @param SOKWNUOC - Số khối nước
     * @param TIENDIEN - Tiền điện
     * @param TIENNUOC - Tiền nước
     * @param THANG - Tháng
     * @param NAM - Năm
     * @param TONGTIEN - Tổng tiền
     * @return 
     */
      public int AddNewRecord(int MAKV,int MAPHONG,int SOKWDIEN,int SOKWNUOC,int TIENDIEN,int TIENNUOC,int THANG,int NAM,int TONGTIEN){
        int rowCount = 0;
        try{
            //Định dạng ngay sinh
        
            SqlDataAccess acc = new SqlDataAccess();
            
                String sql = "INSERT INTO HOADON(MAKV,MAPHONG,SOKWDIEN,SOKWNUOC,TIENDIEN,TIENNUOC,THANG,NAM,TONGTIEN) VALUES("
                        +"'"+ MAKV
                        +"','"+ MAPHONG
                        +"','"+SOKWDIEN
                        +"','"+SOKWNUOC
                        +"','"+TIENDIEN
                        +"','"+TIENNUOC
                        +"','"+THANG
                        +"','"+NAM
                        +"','"+TONGTIEN
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
       * Truyền vào tham số để cập nhật dữ liệu
       * @param MAHOADON -  Mã Hóa Đơn(Điều kiện)
       * @param MAKV - Mã Khu Vực
       * @param MAPHONG - Mã Phòng
       * @param SOKWDIEN - Số KW Điện
       * @param SOKWNUOC - Số khối nước
       * @param TIENDIEN - Tiền điện
       * @param TIENNUOC - Tiền nước
       * @param THANG - Tháng
       * @param NAM - Năm
       * @param TONGTIEN - Tổng tiền
       * @return 
       */
      public int UpdateRecord(int MAHOADON,int MAKV,int MAPHONG,int SOKWDIEN,int SOKWNUOC,int TIENDIEN,int TIENNUOC,int THANG,int NAM, int TONGTIEN){
        int rowCount = 0;
        try{
               
            SqlDataAccess acc = new SqlDataAccess();
            
             String sql = "UPDATE HOADON SET MAKV = "            
                    +""+ MAKV
                    +",MAPHONG = '"+MAPHONG
                    +"', SOKWDIEN = '"+SOKWDIEN
                    +"', SOKWNUOC = '"+SOKWNUOC
                    +"', TIENDIEN = '"+TIENDIEN
                    +"', TIENNUOC = '"+TIENNUOC
                    +"', THANG = '"+THANG
                    +"', NAM = '"+NAM
                    +"', TONGTIEN = '"+TONGTIEN
                    +"' WHERE MAHD = "+MAHOADON;
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
      /**
       * Truyền vào tham số để xóa
       * @param MAHOADON - Mã hóa đơn
       * @return 
       */
       public int DeleteRecord(int MAHOADON){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM HOADON WHERE MAHD = " + MAHOADON;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
      
      
}
