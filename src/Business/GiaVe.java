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
public class GiaVe {
    private String MaGV;
    private long Gia;
    private String NgayApDung;
    private String LoaiKH;

    public GiaVe(String MaGV, long Gia, String NgayApDung, String LoaiKH) {
        this.MaGV = MaGV;
        this.Gia = Gia;
        this.NgayApDung = NgayApDung;
        this.LoaiKH = LoaiKH;
    }

    public String getMaGV() {
        return MaGV;
    }

    public long getGia() {
        return Gia;
    }

    public String getNgayApDung() {
        return NgayApDung;
    }

    public String getLoaiKH() {
        return LoaiKH;
    }
    
    
}
