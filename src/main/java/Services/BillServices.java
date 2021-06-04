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
//    public ArrayList<Bill> getAllRecords()
//    {
//       
//        ArrayList<Bill> list = new ArrayList<Bill>(); // Khởi tạo danh sách hợp đồng
//        try
//        {        
//            SqlDataAccess acc = new SqlDataAccess(); //  Gọi SQL data access
//            ResultSet rs = acc.Query("SELECT * FROM [HOADON]");
//            while(rs.next())
//            {
//                Bill B = new Bill(rs.getInt("SOHD"), rs.getString("TENHD"), rs.getInt("MAKH"), rs.getDate("NGAYLAP"),rs.getDate("NGAYKETTHUC"),rs.getString("TU"),rs.getInt("O"));
//                list.add(B);
//            }            
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null, e);
//        }
//        return list;
//    }
    
//     public ArrayList<Room> getRoom(int MaKV)
//    {
//       
//        ArrayList<Room> list = new ArrayList<Room>(); // Khởi tạo danh sách hợp đồng
//        try
//        {        
//            String sql = "SELECT * FROM PHONGTRO WHERE MAKV = " + MaKV;
//            SqlDataAccess acc = new SqlDataAccess(); //  Gọi SQL data access
//            ResultSet rs = acc.Query(sql);
//            while(rs.next())
//            {
//                Bill B = new Bill(rs.getInt("SOHD"), rs.getString("TENHD"), rs.getInt("MAKH"), rs.getDate("NGAYLAP"),rs.getDate("NGAYKETTHUC"),rs.getString("TU"),rs.getInt("O"));
//                list.add(B);
//            }            
//        }
//        catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null, e);
//        }
//        return list;
//    }
    
    
}
