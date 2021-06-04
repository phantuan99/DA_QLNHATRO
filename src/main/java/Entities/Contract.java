/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author PhanTuan
 */
public class Contract {
    private int SOHD,MAKH,O;
    private String TENHD,TU;
    private Date NGAYLAP,NGAYKETTHUC;

    public Contract(int SOHD, String TENHD,  int MAKH, Date NGAYLAP, Date NGAYKETTHUC, String TU, int O) {
        this.SOHD = SOHD;
        this.MAKH = MAKH;
        this.O = O;
        this.TENHD = TENHD;
        this.TU = TU;
        this.NGAYLAP = NGAYLAP;
        this.NGAYKETTHUC = NGAYKETTHUC;
    }

    public int getSOHD() {
        return SOHD;
    }

    public void setSOHD(int SOHD) {
        this.SOHD = SOHD;
    }

    public int getMAKH() {
        return MAKH;
    }

    public void setMAKH(int MAKH) {
        this.MAKH = MAKH;
    }

    public int getO() {
        return O;
    }

    public void setO(int O) {
        this.O = O;
    }

    public String getTENHD() {
        return TENHD;
    }

    public void setTENHD(String TENHD) {
        this.TENHD = TENHD;
    }

    public String getTU() {
        return TU;
    }

    public void setTU(String TU) {
        this.TU = TU;
    }

    public Date getNGAYLAP() {
        return NGAYLAP;
    }

    public void setNGAYLAP(Date NGAYLAP) {
        this.NGAYLAP = NGAYLAP;
    }

    public Date getNGAYKETTHUC() {
        return NGAYKETTHUC;
    }

    public void setNGAYKETTHUC(Date NGAYKETTHUC) {
        this.NGAYKETTHUC = NGAYKETTHUC;
    }
    
}
