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
    
    /**
     * Đây là phương thức lấy toàn bộ danh sách từ bảng khách hàng trong cơ sở dữ liệu
     * @return trả về danh sách khách hàng
     */
    public ArrayList<Customer> getAllRecords(){
        //khởi tạo một mảng danh sách đối tượng khách hàng
        ArrayList<Customer> list = new ArrayList<>();
        try {
            //Tạo SqlDataAccess kết nối cơ sở dữ liệu
            SqlDataAccess acc = new SqlDataAccess();
            //thực thi câu lệnh SQL đối tượng ResultSet.
            ResultSet rs = acc.Query("SELECT * FROM [KHACHHANG]");
            //duyệt trên kết quả trả về
            while(rs.next()){ // di chuyển con trỏ xuống bản ghi kế tiếp
                //khởi tạo đối tượng khách hàng với kết quả trả về
                Customer customer = new Customer(rs.getInt("MAKH"),rs.getString("TENKH"),rs.getDate("NGAYSINH"),rs.getString("SDT"),rs.getString("DIACHI"),rs.getString("EMAIL"));
                //thêm đối tượng khách hàng vào mảng danh sách
                list.add(customer);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //trả về danh sách khách hàng
        return list;
    
    }
    /**
     * Đây là phương thức thêm một thông tin khách hàng vào cơ sở dữ liệu
     * @param tenkh Đây là tham số tên khách hàng
     * @param ngaysinh Đây là tham số ngày sinh khách hàng
     * @param sdt Đây là tham số số điện thoại khách hàng
     * @param diachi Đây là tham số địa chỉ khách hàng
     * @param email Đây là tham số email khách hàng
     * @return nothing
     */
    public int AddNewRecord(String tenkh, Date ngaysinh, String sdt, String diachi, String email){
        //khai báo biến rowCount để thực thi câu lệnh sql
        int rowCount = 0;
        try{            
            //Định dạng ngày sinh
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");    
            String strDate = formatter.format(ngaysinh); 
            System.out.println("Date Format with yyyy-MM-dd : "+ ngaysinh );
            //Tạo SqlDataAccess kết nối cơ sở dữ liệu
            SqlDataAccess acc = new SqlDataAccess();
            //khai báo câu lệnh SQL thêm một khách hàng vào cơ sở dữ liệu
            String sql = "INSERT INTO KHACHHANG (TENKH,NGAYSINH,SDT,DIACHI,EMAIL) VALUES("  
                    +"N'"+tenkh
                    +"',N'"+strDate
                    +"','"+sdt
                    +"',N'"+diachi
                    +"','"+email                   
                    +"')";                    
            
            System.out.println(sql);
            //thực thi câu lệnh SQL 
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    /**
     * Đây là phương thức sửa thông tin một khách hàng vào cơ sở dữ liệu
     * @param makh Đây là tham số mã khách hàng
     * @param tenkh Đây là tham số tên khách hàng
     * @param ngaysinh Đây là tham số ngày sinh khách hàng
     * @param sdt Đây là tham số số điện thoại khách hàng
     * @param diachi Đây là tham số địa chỉ khách hàng
     * @param email Đây là tham số email khách hàng
     */
    public int UpdateRecord(int makh, String tenkh, Date ngaysinh, String sdt, String diachi, String email){
        //khai báo biến rowCount để thực thi câu lệnh sql
        int rowCount = 0;
        try{            
            //Định dạng ngay sinh
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");    
            String strDate = formatter.format(ngaysinh); 
            System.out.println("Date Format with yyyy-MM-dd : "+ ngaysinh );
            //Tạo đối tượng SqlDataAccess kết nối cơ sở dữ liệu
            SqlDataAccess acc = new SqlDataAccess();
            //khai báo câu lệnh SQL sửa một khách hàng có trong cơ sở dữ liệu với mã khách hàng
            String sql = "UPDATE KHACHHANG SET TENKH = "
                    +"N'"+ tenkh
                    +"',NGAYSINH = "+strDate
                    +",SDT = '"+sdt
                    +"', DIACHI = N'"+diachi
                    +"', EMAIL = N'"+email
                    +"' WHERE MAKH = "+makh;
            
            System.out.println(sql);
            //thực thi câu lệnh SQL 
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    /**
     * Đây là phương thức xóa một thông tin khách hàng trong cơ sỡ dữ liệu
     * @param makh Đây là tham số mã khách hàng
     */
     public int DeleteRecord(int makh){
        //khai báo biến rowCount để thực thi câu lệnh sql
        int rowCount = 0;
        try{
            //Tạo đối tượng SqlDataAccess kết nối cơ sở dữ liệu
            SqlDataAccess acc = new SqlDataAccess();
            //khai báo câu lệnh SQL xóa một khách hàng với mã khách hàng
            String sql = "DELETE FROM KHACHHANG WHERE MAKH = " + makh;
            
            System.out.println(sql);
            //thực thi câu lệnh SQL
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }   
}
