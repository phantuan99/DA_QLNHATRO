/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author PhanTuan
 */

/**
 * 
 * Chứa Constructor và Getter, Setter của khu vực
 */
public class Area {  
    //Tạo biến
   private int MAKV, MANV;
   private String TENKV,DIACHIKV;
//Constructor
    public Area(int MAKV, int MANV, String TENKV, String DIACHIKV) {
        this.MAKV = MAKV;
        this.MANV = MANV;
        this.TENKV = TENKV;
        this.DIACHIKV = DIACHIKV;
    }
    
//Khởi tạo Get,Set
    public int getMAKV() {
        return MAKV;
    }

    public void setMAKV(int MAKV) {
        this.MAKV = MAKV;
    }

    public int getMANV() {
        return MANV;
    }

    public void setMANV(int MANV) {
        this.MANV = MANV;
    }

    public String getTENKV() {
        return TENKV;
    }

    public void setTENKV(String TENKV) {
        this.TENKV = TENKV;
    }

    public String getDIACHIKV() {
        return DIACHIKV;
    }

    public void setDIACHIKV(String DIACHIKV) {
        this.DIACHIKV = DIACHIKV;
    }
}
