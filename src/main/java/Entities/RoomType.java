/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author vuhuynh
 */
public class RoomType {
    //khai báo các biến của đối tượng loại phòng trọ gồm: mã loại, tên loại, đơn giá, sức chứa
    private int MALOAI;
    private String TENLOAI;
    private int DONGIA;
    private int SUCCHUA;  
    //phương thức khởi tạo đối tượng loại phòng trọ
    public RoomType(int MALOAI, String TENLOAI, int DONGIA, int SUCCHUA) {
        this.MALOAI = MALOAI;
        this.TENLOAI = TENLOAI;
        this.DONGIA = DONGIA;
        this.SUCCHUA = SUCCHUA;
    }
    //phương thức đọc mã loại phòng
    public int getMALOAI() {
        return MALOAI;
    }
    //phương thức ghi mã loại phòng
    public void setMALOAI(int MALOAI) {
        this.MALOAI = MALOAI;
    }
    //phương thức đọc tên loại phòng
    public String getTENLOAI() {
        return TENLOAI;
    }
    //phương thức ghi tên loại phòng
    public void setTENLOAI(String TENLOAI) {
        this.TENLOAI = TENLOAI;
    }
    //phương thức đọc đơn giá
    public int getDONGIA() {
        return DONGIA;
    }
    //phương thức ghi đơn giá
    public void setDONGIA(int DONGIA) {
        this.DONGIA = DONGIA;
    }
    //phương thức đọc sức chứa
    public int getSUCCHUA() {
        return SUCCHUA;
    }
    //phương thức ghi sức chứa
    public void setSUCCHUA(int SUCCHUA) {
        this.SUCCHUA = SUCCHUA;
    }
    
    
    
    
    
}
