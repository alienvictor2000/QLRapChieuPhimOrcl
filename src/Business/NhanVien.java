/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author Do Di
 */
public class NhanVien extends Nguoi{
    private String MaNV;
    private String ViTri;

    public NhanVien(String MaNV, String SDT, String hoten, String CMND, char GioiTinh, Date NgaySinh,String DiaChi,String ViTri) {
        super(SDT, hoten, CMND, GioiTinh, NgaySinh,DiaChi);
        this.MaNV = MaNV;
        this.ViTri = ViTri;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getViTri() {
        return ViTri;
    }
    
    
}
