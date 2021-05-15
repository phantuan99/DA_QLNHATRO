/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Customer;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author vuhuynh
 */
public class CustomerServices {
    public ArrayList<Customer> getAllRecords(){
        ArrayList<Customer> list = new ArrayList<>();
        try {
            SqlDataAccess acc = new SqlDataAccess();
            ResultSet rs = acc.Query("SELECT * FROM [KHACHHANG]");
            while(rs.next()){
                Customer customer = new Customer(rs.getInt("MAKH"),rs.getString("TENKH"),rs.getDate("NGAYSINH"),rs.getString("SDT"),rs.getString("DIACHI"),rs.getString("EMAIL"));
                list.add(customer);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    
    }
    public int AddNewRecord(String tenkh, Date ngaysinh, String sdt, String diachi, String email){
        int rowCount = 0;
        try{            
            //Định dạng ngay sinh
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");    
            String strDate = formatter.format(ngaysinh); 
            System.out.println("Date Format with yyyy-MM-dd : "+ ngaysinh );
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO KHACHHANG (TENKH,NGAYSINH,SDT,DIACHI,EMAIL) VALUES("  
                    +"N'"+tenkh
                    +"',N'"+strDate
                    +"','"+sdt
                    +"',N'"+diachi
                    +"','"+email                   
                    +"')";                    
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
        public int UpdateRecord(int makh, String tenkh, Date ngaysinh, String sdt, String diachi, String email){
        int rowCount = 0;
        try{            
            //Định dạng ngay sinh
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");    
            String strDate = formatter.format(ngaysinh); 
            System.out.println("Date Format with yyyy-MM-dd : "+ ngaysinh );
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "UPDATE KHACHHANG SET TENKH = "
                    +"N'"+ tenkh
                    +"',NGAYSINH = "+strDate
                    +",SDT = '"+sdt
                    +"', DIACHI = N'"+diachi
                    +"', EMAIL = N'"+email
                    +"' WHERE MAKH = "+makh;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
     public int DeleteRecord(int makh){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM KHACHHANG WHERE MAKH = " + makh;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }   
}
