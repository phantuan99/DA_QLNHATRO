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
     /**
     * Đây là phương thức lấy toàn bộ danh sách từ bảng loại phòng trọ trong cơ sở dữ liệu
     * @return trả về danh sách loại phòng trọ
     */
        public ArrayList<RoomType> getAllRecords(){
            //khởi tạo một mảng danh sách đối tượng loại phòng trọ
            ArrayList<RoomType> list = new ArrayList<>();
            try {
                //Tạo SqlDataAccess kết nối cơ sở dữ liệu
                SqlDataAccess acc = new SqlDataAccess();
                //thực thi câu lệnh SQL đối tượng ResultSet.
                ResultSet rs = acc.Query("SELECT * FROM [LOAIPHONGTRO]");
                //duyệt trên kết quả trả về
                while(rs.next()){// di chuyển con trỏ xuống bản ghi kế tiếp
                    //khởi tạo đối tượng loại phòng trọ với kết quả trả về
                    RoomType roomType = new RoomType(rs.getInt("MALOAIPHONG"),rs.getString("TENLOAI"),rs.getInt("DONGIA"),rs.getInt("SUCCHUA"));
                    //thêm đối tượng loại phòng trọ vào mảng danh sách
                    list.add(roomType);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return list;

        }
        /**
         * Đây là phương thức thêm một thông tin loại phòng trọ vào cơ sở dữ liệu
         * @param tenloai Đây là tham số tên loại phòng
         * @param dongia Đây là tham số đơn giá
         * @param succhua Đây là tham số sức chứa
         */
        public int AddNewRecord( String tenloai, int dongia, int succhua){
            //khai báo biến rowCount để thực thi câu lệnh sql
            int rowCount = 0;
            try {
                //Tạo SqlDataAccess kết nối cơ sở dữ liệu
                SqlDataAccess acc = new SqlDataAccess();
                //khai báo câu lệnh SQL thêm một loại phòng trọ vào cơ sở dữ liệu
                String sql = "INSERT INTO LOAIPHONGTRO (TENLOAI,DONGIA,SUCCHUA) VALUES(N'"+ tenloai +"',"+ dongia +","+ succhua +")";
                System.out.println(sql);
                //thực thi câu lệnh SQL 
                rowCount = acc.Update(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return rowCount;
        }
        /**
         * Đây là phương thức sửa một thông tin loại phòng trọ vào cơ sở dữ liệu
         * @param maloai Đây là tham số mã loại phòng
         * @param tenloai Đây là tham số tên loại phòng
         * @param dongia Đây là tham số đơn giá
         * @param succhua Đây là tham số sức chứa
         * @return 
         */
        public int UpdateRecord(int maloai, String tenloai, int dongia, int succhua){
            //khai báo biến rowCount để thực thi câu lệnh sql
            int rowCount = 0;
            try {
                //Tạo đối tượng SqlDataAccess kết nối cơ sở dữ liệu
                SqlDataAccess acc = new SqlDataAccess();
                //khai báo câu lệnh SQL sửa một loại phòng trọ có trong cơ sở dữ liệu với mã loại phòng trọ
                String sql = "UPDATE LOAIPHONGTRO SET TENLOAI = N'"+ tenloai +"',DONGIA ="+ dongia +",SUCCHUA ="+ succhua +" WHERE MALOAIPHONG = "+maloai;
                System.out.println(sql);
                //thực thi câu lệnh SQL 
                rowCount = acc.Update(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return rowCount;
        }
        /**
         * Đây là phương thức xóa một thông tin loại phòng trọ vào cơ sở dữ liệu
         * @param maloai Đây là tham số mã loại phòng
         */
        public int DeleteRecord(int maloai){
            //khai báo biến rowCount để thực thi câu lệnh sql
            int rowCount = 0;
            try {
                //Tạo đối tượng SqlDataAccess kết nối cơ sở dữ liệu
                SqlDataAccess acc = new SqlDataAccess();
                //khai báo câu lệnh SQL xóa một loại phòng trọ với mã phòng trọ
                String sql = "DELETE FROM LOAIPHONGTRO WHERE MALOAIPHONG = "+maloai;
                System.out.println(sql);
                //thực thi câu lệnh SQL
                rowCount = acc.Update(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return rowCount;
        }
}
