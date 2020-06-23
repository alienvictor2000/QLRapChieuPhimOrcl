/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Vi Yêu
 */
public class ChiTietHoaDonThucPham {
    private int soHoaDon;
    private String maThucPham;
    private int soLuong;
    private double thanhTien;

    public ChiTietHoaDonThucPham() {
        
    }
    
    public ChiTietHoaDonThucPham(int soHoaDon, String maThucPham, int soLuong, double thanhTien) {
        this.soHoaDon = soHoaDon;
        this.maThucPham = maThucPham;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    public String getMaThucPham() {
        return maThucPham;
    }

    public void setMaThucPham(String maThucPham) {
        this.maThucPham = maThucPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
