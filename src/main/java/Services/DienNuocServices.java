/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.DienNuoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PhanTuan
 */
public class DienNuocServices {
       /**
     * 
     * Dùng để select dữ liệu từ database
     */
    public ArrayList<DienNuoc> getAllRecords()
    {
       
        ArrayList<DienNuoc> list = new ArrayList<DienNuoc>(); // Khởi tạo danh sách điện nước
        try
        {        
            SqlDataAccess acc = new SqlDataAccess(); //  Gọi SQL data access
            ResultSet rs = acc.Query("SELECT * FROM [DIENNUOC]");
            while(rs.next())
            {
                DienNuoc DN = new DienNuoc(rs.getInt("ID"), rs.getInt("MAKV"), rs.getInt("GIADIEN"), rs.getInt("GIANUOC"));
                list.add(DN);
            }            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    
     public int AddNewRecord( int MaKV, int GiaDien, int GiaNuoc){
        int rowCount = 0;
        try{                    
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO DIENNUOC (MAKV, GIADIEN, GIANUOC) VALUES(" 
                    +"'"+MaKV
                    +"','"+GiaDien
                    +"','"+GiaNuoc                
                    +"')";   
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
     public int UpdateRecord(int Id, int MaKV, int GiaDien, int GiaNuoc){
        int rowCount = 0;
        try{

            SqlDataAccess acc = new SqlDataAccess();
            
             String sql = "UPDATE DIENNUOC SET MAKV = "
                    +"'"+ MaKV
                    +"',GIADIEN ='"+GiaDien
                    +"', GIANUOC = N'"+GiaNuoc
                 
                    +"' WHERE ID = "+Id;
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
      public int DeleteRecord(int Id){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM DIENNUOC WHERE ID = " + Id;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    
     
}
