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
public class Room {
    //khai báo các biến của đối tượng phòng trọ gồm: mã phòng, mã khu vực, mã loại phòng, trạng thái
    private int MAPHONG;
    private int MAKV;
    private int MALOAI;
    private boolean TRANGTHAI;
    //phương thức khởi tạo của đối tượng phòng trọ
    public Room(int MAPHONG, int MAKV, int MALOAI, boolean TRANGTHAI) {
        this.MAPHONG = MAPHONG;
        this.MAKV = MAKV;
        this.MALOAI = MALOAI;
        this.TRANGTHAI = TRANGTHAI;
    }
    //phương thức đọc mã phòng trọ
    public int getMAPHONG() {
        return MAPHONG;
    }
    //phương thức ghi mã phòng trọ
    public void setMAPHONG(int MAPHONG) {
        this.MAPHONG = MAPHONG;
    }
    //phương thức đọc mã khu vực
    public int getMAKV() {
        return MAKV;
    }
    //phương thức ghi mã khu vực
    public void setMAKV(int MAKV) {
        this.MAKV = MAKV;
    }
    //phương thức đọc mã loại phòng trọ
    public int getMALOAI() {
        return MALOAI;
    }
    //phương thức ghi mã loại phòng trọ
    public void setMALOAI(int MALOAI) {
        this.MALOAI = MALOAI;
    }
    //phương thức đọc trạng thái
    public boolean isTRANGTHAI() {
        return TRANGTHAI;
    }
    //phương thức ghi trạng thái
    public void setTRANGTHAI(boolean TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }
    
    
}
