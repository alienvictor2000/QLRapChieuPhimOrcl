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
public class ThucPham {
    private String maThucPham;
    private String tenThucPham;
    private String donViTinh;
    private double donGia;

    public ThucPham() {
        
    }
    
    public ThucPham(String maThucPham, String tenThucPham, String donViTinh, double donGia) {
        this.maThucPham = maThucPham;
        this.tenThucPham = tenThucPham;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
    }
        
    public String getMaThucPham() {
        return maThucPham;
    }

    public void setMaThucPham(String maThucPham) {
        this.maThucPham = maThucPham;
    }

    public String getTenThucPham() {
        return tenThucPham;
    }

    public void setTenThucPham(String tenThucPham) {
        this.tenThucPham = tenThucPham;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    
    
}
