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



public class ContractServices {
     /**
     * 
     * Dùng để truy vấn tất cả dữ liệu của hợp đồng
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
                Contract HD = new Contract(rs.getInt("SOHD"), rs.getString("TENHD"), rs.getInt("MAKH"),rs.getInt("MAKV"),rs.getInt("MAPHONGTRO"), rs.getDate("NGAYLAP"),rs.getDate("NGAYKETTHUC"),rs.getString("TU"),rs.getInt("O"));
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
   * Truyền vào tham số để thêm mới dữ liệu
   * @param TENHD - Tên hợp đồng
   * @param MAKH - Mã khách hàng
   * @param NGAYLAP - Ngày lập
   * @param NGAYKETTHUC - Ngày kết thúc
   * @param TU - Tủ
   * @param O - Ô
   * @param MAKV - Mã khu vực
   * @param MAPHONGTRO - Mã phòng trọ
   * @return 
   */
    public int AddNewRecord( String TENHD,  int MAKH,int MAKV, int MAPHONGTRO , Date NGAYLAP, Date NGAYKETTHUC, String TU, int O){
        int rowCount = 0;
        try{
            //Định dạng ngay sinh
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");    
            String strNgayLap = formatter.format(NGAYLAP); // truyền vào ngày  lập để định dạng
            String strNgayKetThuc = formatter.format(NGAYKETTHUC); //truyền vào ngày kết thúc để định dạng
            System.out.println("Date Format with yyyy-MM-dd : "+ NGAYLAP );
            System.out.println("Date Format with yyyy-MM-dd : "+ NGAYKETTHUC );  
            
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "INSERT INTO HOPDONG (TENHD, MAKH,MAKV,MAPHONGTRO, NGAYLAP, NGAYKETTHUC,TU,O) VALUES(" 
                    +"N'"+TENHD
                    +"','"+MAKH
                    +"','"+MAKV
                    +"','"+MAPHONGTRO
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
    * Phương thúc cập nhật dữ liệu
    * Truyền vào tham số để cập nhật dữ liệu
    * @param SOHD - Số hợp động(Điều kiện)
    * @param TENHD - Tên hợp đồng
    * @param MAKH - Mã khách hàng
    * @param NGAYLAP - Ngày lập
    * @param NGAYKETTHUC - Ngày kết thúc
    * @param TU - Tủ
    * @param O - Ô
    * @param MAKV - Mã khu vực
    * @param MAPHONGTRO - Mã phòng trọ
    * @return 
    */
     public int UpdateRecord(int SOHD, String TENHD,  int MAKH,int MAKV, int MAPHONGTRO, Date NGAYLAP, Date NGAYKETTHUC, String TU, int O){
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
                    +"',MAKH = '"+MAKH
                    +"', MAKV = '"+MAKV
                    +"', MAPHONGTRO = '"+MAPHONGTRO
                    +"',NGAYLAP = '"+strNgayLap
                    +"', NGAYKETTHUC = '"+strNgayKetThuc
                    +"', TU =N'"+TU
                    +"', O = '"+O
                     
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
      * Truyền vào tham số để xóa dữ liệu
      * @param SOHD - Số hóa đơn
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
      public int DeleteRecordKH(int makh){
        int rowCount = 0;
        try{
                
            SqlDataAccess acc = new SqlDataAccess();
            String sql = "DELETE FROM HOPDONG WHERE MAKH = " + makh;
            
            System.out.println(sql);
            
            rowCount = acc.Update(sql);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return rowCount;
    }
}
