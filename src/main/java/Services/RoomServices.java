/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Room;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author vuhuynh
 */
public class RoomServices {
    public ArrayList<Room> getAllRecords(){
         ArrayList<Room> list = new ArrayList<>();
         try {
            SqlDataAccess acc = new SqlDataAccess();
            ResultSet rs = acc.Query("SELECT * FROM [PHONGTRO]");
            while(rs.next()){
                    Room room = new Room(rs.getInt("MAPHONGTRO"),rs.getInt("MAKV"),rs.getInt("MALOAIPHONG"),rs.getBoolean("TRANGTHAI"));
                    list.add(room);
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return list;
    }
    
    public int AddNewRecord(int makv, int maloai, boolean trangthai){
            int rowCount = 0;
            try {
                SqlDataAccess acc = new SqlDataAccess();
                String sql = "INSERT INTO PHONGTRO (MAKV,MALOAIPHONG,TRANGTHAI) VALUES("+ makv +","+ maloai +",'"+ trangthai +"')";
                System.out.println(sql);
                rowCount = acc.Update(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return rowCount;
        }
    
    public int UpdateRecord(int maphong, int makv, int maloai, boolean trangthai){
            int rowCount = 0;
            try {
                SqlDataAccess acc = new SqlDataAccess();
                String sql = "UPDATE PHONGTRO SET MAKV = "+ makv +", MALOAIPHONG = "+ maloai +",TRANGTHAI = '"+ trangthai +"' WHERE MAPHONGTRO = "+ maphong ;
                System.out.println(sql);
                rowCount = acc.Update(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return rowCount;
        }
    
    public int DeleteRecord(int maphong){
            int rowCount = 0;
            try {
                SqlDataAccess acc = new SqlDataAccess();
                String sql = "DELETE FROM PHONGTRO WHERE MAPHONGTRO = "+maphong;
                System.out.println(sql);
                rowCount = acc.Update(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return rowCount;
        }
}
