/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.time.LocalDate;

/**
 *
 * @author Vi Yêu
 */
public class HoaDonThucPham {
    private int soHoaDon;
    private String maNhanVien="NV001";
    private double tongTien;
    private String thoiGian;

    public HoaDonThucPham() {
        
    }
        
    public HoaDonThucPham(int soHoaDon, String maNhanVien, double tongTien, String thoiGian) {
        this.soHoaDon = soHoaDon;
        this.maNhanVien = maNhanVien;
        this.tongTien = tongTien;
        this.thoiGian = thoiGian;
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
    
    
    
}
