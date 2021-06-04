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
public class DienNuoc {
    int ID,MaKV,GiaDien,GiaNuoc;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getMaKV() {
        return MaKV;
    }

    public void setMaKV(int MaKV) {
        this.MaKV = MaKV;
    }

    public int getGiaDien() {
        return GiaDien;
    }

    public void setGiaDien(int GiaDien) {
        this.GiaDien = GiaDien;
    }

    public int getGiaNuoc() {
        return GiaNuoc;
    }

    public void setGiaNuoc(int GiaNuoc) {
        this.GiaNuoc = GiaNuoc;
    }

    public DienNuoc(int ID, int MaKV, int GiaDien, int GiaNuoc) {
        this.ID = ID;
        this.MaKV = MaKV;
        this.GiaDien = GiaDien;
        this.GiaNuoc = GiaNuoc;
    }
}
