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
public class Muc {

    private ThucPham thucPham;
    private int soLuong;
    private double thanhTien;

    public double getThanhTien() {
        return thanhTien=this.soLuong*this.thucPham.getDonGia();
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Muc() {

    }

    public Muc(ThucPham thucPham) {
        this.thucPham = thucPham;
        this.soLuong = 0;
    }
    
    public Muc(ThucPham thucPham, int soLuong) {
        this.thucPham = thucPham;
        this.soLuong = soLuong;
    }

    public ThucPham getThucPham() {
        return thucPham;
    }

    public void setThucPham(ThucPham thucPham) {
        this.thucPham = thucPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
