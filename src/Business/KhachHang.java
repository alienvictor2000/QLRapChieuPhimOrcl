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
public class KhachHang extends Nguoi{
    private Date NgayMuaGanNhat;
    private long DiemTichLuy;
    private long TongDiemTichLuy;

    public KhachHang( String SDT, String hoten, String CMND, char GioiTinh, Date NgaySinh,
            String DiaChi,Date NgayMuaGanNhat, long DiemTichLuy, long TongDiemTichLuy) {
        super(SDT, hoten, CMND, GioiTinh, NgaySinh,DiaChi);
        this.NgayMuaGanNhat = NgayMuaGanNhat;
        this.DiemTichLuy = DiemTichLuy;
        this.TongDiemTichLuy = TongDiemTichLuy;
    }

    public KhachHang(String SDT,long DiemTichLuy) {
        this.SDT=SDT;
        this.DiemTichLuy=DiemTichLuy;
        this.TongDiemTichLuy = 0;
        this.NgayMuaGanNhat = null;
    }
    


    public Date getNgayMuaGanNhat() {
        return NgayMuaGanNhat;
    }

    public long getDiemTichLuy() {
        return DiemTichLuy;
    }

    public long getTongDiemTichLuy() {
        return TongDiemTichLuy;
    }
    
   
    
}
