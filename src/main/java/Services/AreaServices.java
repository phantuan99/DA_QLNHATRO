/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Area;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PhanTuan
 */

/**
 * 
 * Chứa các phương thức truy vấn của khu vực
 */
public class AreaServices {
  
    /**
     * 
     * Dùng để select dữ liệu từ database
     */
    public ArrayList<Area> getAllRecords()
    {
       
        ArrayList<Area> list = new ArrayList<Area>(); // Khởi tạo danh sách khu vực
        try
        {        
            SqlDataAccess acc = new SqlDataAccess(); 
            ResultSet rs = acc.Query("SELECT * FROM [KHUVUC]");
            while(rs.next())
            {
                Area KV = new Area(rs.getInt("MAKV"), rs.getInt("MANV"), rs.getString("TENKV"), rs.getString("DIACHIKV"));
                list.add(KV);
            }            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }


       /**
        * Phương thức chứa câu lệnh truy vấn thêm mới vào database
        * @param MaNV - Truyền vào nhân viên
        * @param TenKV - Truyền vào khu vực
        * @param DiaChiKV - Truyền vào địa chỉ khu vực
        * @return 
        */
    public int AddNewRecord(int MaNV, String TenKV, String DiaChiKV){
     
        int rowCount = 0;
        try{            
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO KHUVUC (MANV,TENKV,DIACHIKV) VALUES('" + MaNV + "'" +                
                    ",N'" + TenKV +"'"+
                    ",N'" + DiaChiKV +"'"+
                    ")";                    
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    /**
     * Phương thức chứa câu lệnh truy vấn cập nhật dữ liệu vào database
     * @param MaKV - Truyền vào mã khu vực(đây là tự động)
     * @param MaNV - Truyền vào nhân viên
     * @param TenKV - Truyền vào tên khu vực
     * @param DiaChiKV - Truyền vào địa chỉ khu vực
     * @return 
     */
    public int UpdateRecord(int MaKV,int MaNV, String TenKV, String DiaChiKV ){
        int rowCount = 0;
        try{      
            SqlDataAccess acc = new SqlDataAccess();
            
            String sql = "UPDATE KHUVUC SET MANV='" + MaNV + "'" +   
                    ", TENKV='" + TenKV  + "'" +
                    ", DIACHIKV='" + DiaChiKV  + "'" +
                    " WHERE MAKV= '" + MaKV +"'";
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
    /**
     * Phương thức chứa câu lệnh truy vấn xóa dữ liệu ở database
     * @param MaKV
     * @return 
     */
    public int DeleteRecord(int MaKV){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM KHUVUC WHERE MAKV = " + MaKV;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
