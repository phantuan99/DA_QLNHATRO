/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author PhanTuan
 */

import Services.*;
/**
 * 
 * Dùng để kết nối database và chứa các câu lệnh thực thi vào database
 */
public class SqlDataAccess {
   
    // Khởi tạo đối tượng statement 
    private Connection conn; 
    private Statement stmt;
 
    public SqlDataAccess(){
        try{
            SqlConnection myCon = new SqlConnection(); 
            conn = myCon.getConnection(); 
            stmt = conn.createStatement();
        }
        catch(Exception ex){      	
        }        
    }
   /**
    * Lệnh thực thi khi có cập nhật ở CSDL
    * Truyền vào câu lệnh truy vấn thêm, xóa, sửa
    * @param str
    * @return 
    */  
    public int Update(String str){
        try{
            int i = stmt.executeUpdate(str);
            return i;
        }
        catch(Exception ex){
            return -1;
        }
    }
     /**
    * Lệnh thực thi khi select dữ liệu
    * Truyền vào câu lệnh truy vấn select
    * @param str
    * @return 
    */  
    public ResultSet Query(String str){
        try{
            ResultSet rs = stmt.executeQuery(str);
            return rs;
        }
        catch(Exception ex){
            return null;
        }
        
    }
}

    
