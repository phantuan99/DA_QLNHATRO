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
    private int MALOAI;
    private String TENLOAI;
    private int DONGIA;
    private int SUCCHUA;  

    public RoomType(int MALOAI, String TENLOAI, int DONGIA, int SUCCHUA) {
        this.MALOAI = MALOAI;
        this.TENLOAI = TENLOAI;
        this.DONGIA = DONGIA;
        this.SUCCHUA = SUCCHUA;
    }

    public int getMALOAI() {
        return MALOAI;
    }

    public void setMALOAI(int MALOAI) {
        this.MALOAI = MALOAI;
    }

    public String getTENLOAI() {
        return TENLOAI;
    }

    public void setTENLOAI(String TENLOAI) {
        this.TENLOAI = TENLOAI;
    }

    public int getDONGIA() {
        return DONGIA;
    }

    public void setDONGIA(int DONGIA) {
        this.DONGIA = DONGIA;
    }

    public int getSUCCHUA() {
        return SUCCHUA;
    }

    public void setSUCCHUA(int SUCCHUA) {
        this.SUCCHUA = SUCCHUA;
    }
    
    
    
    
    
}
