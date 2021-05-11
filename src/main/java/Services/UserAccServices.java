/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.UserAcc;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PhanTuan
 */
public class UserAccServices {
      public ArrayList<UserAcc> getAllRecords(){
        ArrayList<UserAcc> list = new ArrayList<UserAcc>(); // Khởi tạo danh sách UserAccount
        try{        
            SqlDataAccess acc = new SqlDataAccess();
            ResultSet rs = acc.Query("SELECT * FROM [UserAccount]");

            while(rs.next()){
                UserAcc NV = new UserAcc(rs.getInt("MANV"), rs.getString("Password"), rs.getInt("Role"));
                list.add(NV);
            }            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

//Thêm
    public int AddNewRecord( String Password, int Role){
        
        int rowCount = 0;
        try{            
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO UserAccount (  Password, Role) VALUES('" + Password + "'" +
                    ",'" + Role +"'"+
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
    public int UpdateRecord(int MaNV,String Password, int Role ){
        int rowCount = 0;
        try{      
            SqlDataAccess acc = new SqlDataAccess();
            
            String sql = "UPDATE UserAccount SET Password='" + Password + "'" +   
                    ", Role     =" + Role  +
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
            String sql = "DELETE FROM UserAccount WHERE MANV = " + MaNV;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}