/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.RoomType;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author vuhuynh
 */
    public class RoomTypeServices {
        public ArrayList<RoomType> getAllRecords(){
            ArrayList<RoomType> list = new ArrayList<>();
            try {
                SqlDataAccess acc = new SqlDataAccess();
                ResultSet rs = acc.Query("SELECT * FROM [LOAIPHONGTRO]");
                while(rs.next()){
                    RoomType roomType = new RoomType(rs.getInt("MALOAIPHONG"),rs.getString("TENLOAI"),rs.getInt("DONGIA"),rs.getInt("SUCCHUA"));
                    list.add(roomType);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return list;

        }

        public int AddNewRecord( String tenloai, int dongia, int succhua){
            int rowCount = 0;
            try {
                SqlDataAccess acc = new SqlDataAccess();
                String sql = "INSERT INTO LOAIPHONGTRO (TENLOAI,DONGIA,SUCCHUA) VALUES(N'"+ tenloai +"',"+ dongia +","+ succhua +")";
                System.out.println(sql);
                rowCount = acc.Update(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return rowCount;
        }

        public int UpdateRecord(int maloai, String tenloai, int dongia, int succhua){
            int rowCount = 0;
            try {
                SqlDataAccess acc = new SqlDataAccess();
                String sql = "UPDATE LOAIPHONGTRO SET TENLOAI = N'"+ tenloai +"',DONGIA ="+ dongia +",SUCCHUA ="+ succhua +" WHERE MALOAIPHONG = "+maloai;
                System.out.println(sql);
                rowCount = acc.Update(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return rowCount;
        }

        public int DeleteRecord(int maloai){
            int rowCount = 0;
            try {
                SqlDataAccess acc = new SqlDataAccess();
                String sql = "DELETE FROM LOAIPHONGTRO WHERE MALOAIPHONG = "+maloai;
                System.out.println(sql);
                rowCount = acc.Update(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return rowCount;
        }
}
