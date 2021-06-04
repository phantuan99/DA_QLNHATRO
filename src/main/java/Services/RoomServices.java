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
    /**
     * Đây là phương thức lấy toàn bộ danh sách từ bảng phòng trọ trong cơ sở dữ liệu
     * @return trả về danh sách phòng trọ
     */
    public ArrayList<Room> getAllRecords(){
        //khởi tạo một mảng danh sách đối tượng phòng trọ
         ArrayList<Room> list = new ArrayList<>();
         try {
            //Tạo SqlDataAccess kết nối cơ sở dữ liệu
            SqlDataAccess acc = new SqlDataAccess();
            //thực thi câu lệnh SQL đối tượng ResultSet.
            ResultSet rs = acc.Query("SELECT * FROM [PHONGTRO]");
            //duyệt trên kết quả trả về
            while(rs.next()){// di chuyển con trỏ xuống bản ghi kế tiếp
                    //khởi tạo đối tượng phòng trọ với kết quả trả về
                    Room room = new Room(rs.getInt("MAPHONGTRO"),rs.getInt("MAKV"),rs.getInt("MALOAIPHONG"),rs.getBoolean("TRANGTHAI"));
                    //thêm đối tượng phòng trọ vào mảng danh sách
                    list.add(room);
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         //trả về danh sách phòng trọ
         return list;
    }
    /**
     * Đây là phương thức thêm một thông tin phòng trọ vào cơ sở dữ liệu
     * @param makv Đây là tham số mã khu vực
     * @param maloai Đây là tham số mã loại phòng
     * @param trangthai Đây là tham số trạng thái
     */
    public int AddNewRecord(int makv, int maloai, boolean trangthai){
            //khai báo biến rowCount để thực thi câu lệnh sql
            int rowCount = 0;
            try {
                //Tạo SqlDataAccess kết nối cơ sở dữ liệu
                SqlDataAccess acc = new SqlDataAccess();
                //khai báo câu lệnh SQL thêm một phòng trọ vào cơ sở dữ liệu
                String sql = "INSERT INTO PHONGTRO (MAKV,MALOAIPHONG,TRANGTHAI) VALUES("+ makv +","+ maloai +",'"+ trangthai +"')";
                System.out.println(sql);
                //thực thi câu lệnh SQL 
                rowCount = acc.Update(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return rowCount;
        }
    /**
     * Đây là phương thức sửa một thông tin phòng trọ vào cơ sở dữ liệu
     * @param maphong Đây là tham số mã phòng trọ
     * @param makv Đây là tham số mã khu vực
     * @param maloai Đây là tham số mã loại phòng
     * @param trangthai Đây là tham số trạng thái
     */
    public int UpdateRecord(int maphong, int makv, int maloai, boolean trangthai){
            //khai báo biến rowCount để thực thi câu lệnh sql
            int rowCount = 0;
            try {
                //Tạo đối tượng SqlDataAccess kết nối cơ sở dữ liệu
                SqlDataAccess acc = new SqlDataAccess();
                //khai báo câu lệnh SQL sửa một phòng trọ có trong cơ sở dữ liệu với mã phòng trọ
                String sql = "UPDATE PHONGTRO SET MAKV = "+ makv +", MALOAIPHONG = "+ maloai +",TRANGTHAI = '"+ trangthai +"' WHERE MAPHONGTRO = "+ maphong ;
                System.out.println(sql);
                //thực thi câu lệnh SQL 
                rowCount = acc.Update(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return rowCount;
        }
    /**
     * Đây là phương thức xóa một thông tin phòng trọ vào cơ sở dữ liệu
     * @param maphong Đây là tham số mã phòng trọ
     */
    public int DeleteRecord(int maphong){
            //khai báo biến rowCount để thực thi câu lệnh sql
            int rowCount = 0;
            try {
                //Tạo đối tượng SqlDataAccess kết nối cơ sở dữ liệu
                SqlDataAccess acc = new SqlDataAccess();
                //khai báo câu lệnh SQL xóa một phòng trọ với mã phòng trọ
                String sql = "DELETE FROM PHONGTRO WHERE MAPHONGTRO = "+maphong;
                System.out.println(sql);
                //thực thi câu lệnh SQL
                rowCount = acc.Update(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return rowCount;
        }
    
    public ArrayList<Room> getRecordByArea(int makv){
        
         ArrayList<Room> list = new ArrayList<>();
         try {
            
            SqlDataAccess acc = new SqlDataAccess();
            
            ResultSet rs = acc.Query("SELECT * FROM PHONGTRO WHERE MAKV = "+makv);
           
            while(rs.next()){
                    
                    Room room = new Room(rs.getInt("MAPHONGTRO"),rs.getInt("MAKV"),rs.getInt("MALOAIPHONG"),rs.getBoolean("TRANGTHAI"));
                    
                    list.add(room);
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

         return list;
    }
}
