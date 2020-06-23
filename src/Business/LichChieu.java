/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.ThemLichChieuDB;
import java.util.Date;

/**
 *
 * @author Do Di
 */
public class LichChieu {
    private long MaLC;
    private String MaPC;
    private String NgayGioChieu;
    private Phim phim;

    public LichChieu(long MaLC, String MaPC, String NgayGioChieu, Phim phim) {
        this.MaLC = MaLC;
        this.MaPC = MaPC;
        this.NgayGioChieu = NgayGioChieu;
        this.phim = phim;
    }

    public long getMaLC() {
        return MaLC;
    }

    public void setMaLC(long MaLC) {
        this.MaLC = MaLC;
    }

    public String getMaPC() {
        return MaPC;
    }

    public String getNgayGioChieu() {
        return NgayGioChieu;
    }

    public Phim getPhim() {
        return phim;
    }
    
    public long luu_lich_chieu()
    {
        return ThemLichChieuDB.luu_lich_chieu(this);
    }

    
    public void Xuat_thong_tin()
    {
        System.out.println(this.getMaLC());
        System.out.println(this.getMaPC());
        System.out.println(this.getNgayGioChieu());
    }   
}
