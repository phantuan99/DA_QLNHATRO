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
public class Bill {
    private int MAHOADON,MAKV,MAPHONG,SOKWDIEN,SOKWNUOC,TIENDIEN,TIENNUOC,THANG,NAM;

    public Bill(int MAHOADON, int MAKV, int MAPHONG, int SOKWDIEN, int SOKWNUOC, int TIENDIEN, int TIENNUOC, int THANG, int NAM) {
        this.MAHOADON = MAHOADON;
        this.MAKV = MAKV;
        this.MAPHONG = MAPHONG;
        this.SOKWDIEN = SOKWDIEN;
        this.SOKWNUOC = SOKWNUOC;
        this.TIENDIEN = TIENDIEN;
        this.TIENNUOC = TIENNUOC;
        this.THANG = THANG;
        this.NAM = NAM;
    }

    public int getMAHOADON() {
        return MAHOADON;
    }

    public void setMAHOADON(int MAHOADON) {
        this.MAHOADON = MAHOADON;
    }

    public int getMAKV() {
        return MAKV;
    }

    public void setMAKV(int MAKV) {
        this.MAKV = MAKV;
    }

    public int getMAPHONG() {
        return MAPHONG;
    }

    public void setMAPHONG(int MAPHONG) {
        this.MAPHONG = MAPHONG;
    }

    public int getSOKWDIEN() {
        return SOKWDIEN;
    }

    public void setSOKWDIEN(int SOKWDIEN) {
        this.SOKWDIEN = SOKWDIEN;
    }

    public int getSOKWNUOC() {
        return SOKWNUOC;
    }

    public void setSOKWNUOC(int SOKWNUOC) {
        this.SOKWNUOC = SOKWNUOC;
    }

    public int getTIENDIEN() {
        return TIENDIEN;
    }

    public void setTIENDIEN(int TIENDIEN) {
        this.TIENDIEN = TIENDIEN;
    }

    public int getTIENNUOC() {
        return TIENNUOC;
    }

    public void setTIENNUOC(int TIENNUOC) {
        this.TIENNUOC = TIENNUOC;
    }

    public int getTHANG() {
        return THANG;
    }

    public void setTHANG(int THANG) {
        this.THANG = THANG;
    }

    public int getNAM() {
        return NAM;
    }

    public void setNAM(int NAM) {
        this.NAM = NAM;
    }
    
   

}
