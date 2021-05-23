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
public class AreaServices {
    public ArrayList<Area> getAllRecords(){
        ArrayList<Area> list = new ArrayList<Area>(); // Khởi tạo danh sách NV
        try{        
            SqlDataAccess acc = new SqlDataAccess();
            ResultSet rs = acc.Query("SELECT * FROM [KHUVUC]");

            while(rs.next()){
                Area KV = new Area(rs.getInt("MAKV"), rs.getInt("MANV"), rs.getString("TENKV"), rs.getString("DIACHIKV"));
                list.add(KV);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

//Thêm
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
    //Update
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
    
    //Xoa
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
