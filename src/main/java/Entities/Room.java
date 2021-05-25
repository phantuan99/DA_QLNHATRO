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
    private int MAPHONG;
    private int MAKV;
    private int MALOAI;
    private boolean TRANGTHAI;

    public Room(int MAPHONG, int MAKV, int MALOAI, boolean TRANGTHAI) {
        this.MAPHONG = MAPHONG;
        this.MAKV = MAKV;
        this.MALOAI = MALOAI;
        this.TRANGTHAI = TRANGTHAI;
    }

    public int getMAPHONG() {
        return MAPHONG;
    }

    public void setMAPHONG(int MAPHONG) {
        this.MAPHONG = MAPHONG;
    }

    public int getMAKV() {
        return MAKV;
    }

    public void setMAKV(int MAKV) {
        this.MAKV = MAKV;
    }

    public int getMALOAI() {
        return MALOAI;
    }

    public void setMALOAI(int MALOAI) {
        this.MALOAI = MALOAI;
    }

    public boolean isTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(boolean TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }
    
    
}
