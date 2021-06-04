/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Contract;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author PhanTuan
 */

/**
 *  
 * Hàm chứa các phương thức chứa câu truy vấn CRUD vào SQL Server của bảng Hợp đồng
 */

public class ContractServices {
     /**
     * 
     * Dùng để select dữ liệu từ database
     */
    public ArrayList<Contract> getAllRecords()
    {
       
        ArrayList<Contract> list = new ArrayList<Contract>(); // Khởi tạo danh sách hợp đồng
        try
        {        
            SqlDataAccess acc = new SqlDataAccess(); //  Gọi SQL data access
            ResultSet rs = acc.Query("SELECT * FROM [HOPDONG]");
            while(rs.next())
            {
                Contract HD = new Contract(rs.getInt("SOHD"), rs.getString("TENHD"), rs.getInt("MAKH"), rs.getDate("NGAYLAP"),rs.getDate("NGAYKETTHUC"),rs.getString("TU"),rs.getInt("O"));
                list.add(HD);
            }            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
    /**
     * Phương thức dùng để thêm mới vào database
     * @param SOHD - Số Hợp đồng
     * @param TENHD - Tên Hợp đồng
     * @param MAKH - Mã Khách hàng
     * @param strNgayLap - Ngày lập
     * @param strNgayKetThuc - Ngày kết thúc
     * @param TU - Tủ
     * @param O - Ô
     * @return 
     */
    public int AddNewRecord( String TENHD,  int MAKH, Date NGAYLAP, Date NGAYKETTHUC, String TU, int O){
        int rowCount = 0;
        try{
            //Định dạng ngay sinh
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");    
            String strNgayLap = formatter.format(NGAYLAP); // truyền vào ngày  lập để định dạng
            String strNgayKetThuc = formatter.format(NGAYKETTHUC); //truyền vào ngày kết thúc để định dạng
            System.out.println("Date Format with yyyy-MM-dd : "+ NGAYLAP );
            System.out.println("Date Format with yyyy-MM-dd : "+ NGAYKETTHUC );  
            
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO HOPDONG (TENHD, MAKH, NGAYLAP, NGAYKETTHUC,TU,O) VALUES(" 
                    +"N'"+TENHD
                    +"','"+MAKH
                    +"','"+strNgayLap
                    +"','"+strNgayKetThuc
                    +"','"+TU      
                    +"','"+O
                    +"')";   
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
    /**
     * Phương thức dùng để cập nhật dữ liệu
     * @param SOHD
     * @param TENHD
     * @param MAKH
     * @param NGAYLAP
     * @param NGAYKETTHUC
     * @param TU
     * @param O
     * @return 
     */
     public int UpdateRecord(int SOHD, String TENHD,  int MAKH, Date NGAYLAP, Date NGAYKETTHUC, String TU, int O){
        int rowCount = 0;
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            
            String strNgayLap = formatter.format(NGAYLAP); // truyền vào ngày  lập để định dạng
            String strNgayKetThuc = formatter.format(NGAYKETTHUC); //truyền vào ngày kết thúc để định dạng
            System.out.println("Date Format with yyyy-MM-dd : "+ NGAYLAP );
            System.out.println("Date Format with yyyy-MM-dd : "+ NGAYKETTHUC );  
            
            
            SqlDataAccess acc = new SqlDataAccess();
            
             String sql = "UPDATE HOPDONG SET TENHD = "
                    +"N'"+ TENHD
                    +"',MAKH = "+MAKH
                    +",NGAYLAP = '"+strNgayLap
                    +"', NGAYKETTHUC = N'"+strNgayKetThuc
                    +"', TU = N'"+TU
                    +"', O = N'"+O
                    +"' WHERE SOHD = "+SOHD;
            
            System.out.println(sql);
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
     /**
      * Phương thức dùng để xóa dữ liệu
      * @param SOHD
      * @return 
      */
      public int DeleteRecord(int SOHD){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM HOPDONG WHERE SOHD = " + SOHD;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
