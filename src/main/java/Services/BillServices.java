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
     * Dùng để select dữ liệu từ database
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
                Bill B = new Bill(rs.getInt("MAHD"), rs.getInt("MAKV"), rs.getInt("MAPHONG"), rs.getInt("SOKWDIEN"),rs.getInt("SOKWNUOC"),rs.getInt("TIENDIEN"),rs.getInt("TIENNUOC"),rs.getInt("THANG"),rs.getInt("NAM")   );
                list.add(B);
            }            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    
      public int AddNewRecord(int MAKV,int MAPHONG,int SOKWDIEN,int SOKWNUOC,int TIENDIEN,int TIENNUOC,int THANG,int NAM){
        int rowCount = 0;
        try{
            //Định dạng ngay sinh
        
            SqlDataAccess acc = new SqlDataAccess();
            
                String sql = "INSERT INTO HOADON(MAKV,MAPHONG,SOKWDIEN,SOKWNUOC,TIENDIEN,TIENNUOC,THANG,NAM) VALUES("
                        +"'"+ MAKV
                        +"','"+ MAPHONG
                        +"','"+SOKWDIEN
                        +"','"+SOKWNUOC
                        +"','"+TIENDIEN
                        +"','"+TIENNUOC
                        +"','"+THANG
                        +"','"+NAM
                        +"')";   
            
   
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
      
      
      public int UpdateRecord(int MAHOADON,int MAKV,int MAPHONG,int SOKWDIEN,int SOKWNUOC,int TIENDIEN,int TIENNUOC,int THANG,int NAM){
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
                    +"' WHERE MAHD = "+MAHOADON;
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
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
