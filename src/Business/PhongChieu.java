/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Do Di
 */
public class PhongChieu {
    private String MaPhong;
    private String TenPhong;
    private int SoLuongGhe;

    public PhongChieu(String MaPhong, String TenPhong, int SoLuongGhe) {
        this.MaPhong = MaPhong;
        this.TenPhong = TenPhong;
        this.SoLuongGhe = SoLuongGhe;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public int getSoLuongGhe() {
        return SoLuongGhe;
    }
    
    
}
