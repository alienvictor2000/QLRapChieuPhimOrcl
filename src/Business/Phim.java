/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.ThemPhimDB;

/**
 *
 * @author Do Di
 */
public class Phim {
    private long MaPhim;
    private String TenPhim;
    private String TheLoai;
    private String NhaSX;
    private int DoTuoi;
    private int ThoiLuong;

    public Phim(long MaPhim, String TenPhim, String TheLoai, String NhaSX, int DoTuoi, int ThoiLuong) {
        this.MaPhim = MaPhim;
        this.TenPhim = TenPhim;
        this.TheLoai = TheLoai;
        this.NhaSX = NhaSX;
        this.DoTuoi = DoTuoi;
        this.ThoiLuong = ThoiLuong;
    }

    public long getMaPhim() {
        return MaPhim;
    }

    public String getTenPhim() {
        return TenPhim;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public String getNhaSX() {
        return NhaSX;
    }

    public int getDoTuoi() {
        return DoTuoi;
    }

    public void setMaPhim(long MaPhim) {
        this.MaPhim = MaPhim;
    }

    public int getThoiLuong() {
        return ThoiLuong;
    }
    
    public long luu_phim()
    {
        return ThemPhimDB.them_phim(this);
    }
    public void Xuat_thong_tin()
    {
        System.out.println(this.getMaPhim());
        System.out.println(this.getTenPhim());
        System.out.println(this.getTheLoai());
        System.out.println(this.getNhaSX());
        System.out.println(this.getDoTuoi());
        System.out.println(this.getThoiLuong());
    }
}
