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
public class CTHDVE {
    private LichChieu Lich_chieu;
    private String MaGhe;
    private GiaVe Gia_Ve;

    public CTHDVE(LichChieu Lich_chieu, String MaGhe,GiaVe Gia_VE) {
        this.Lich_chieu = Lich_chieu;
        this.MaGhe = MaGhe;
        this.Gia_Ve = Gia_Ve;
    }
    public CTHDVE(LichChieu Lich_chieu, String MaGhe) {
        this.Lich_chieu = Lich_chieu;
        this.MaGhe = MaGhe;
        this.Gia_Ve = new GiaVe("0", 0, "0", "0");
    }

    public void setGia_Ve(GiaVe Gia_Ve) {
        this.Gia_Ve = Gia_Ve;
    }
    
    public GiaVe getGia_Ve() {
        return Gia_Ve;
    }
    
    public LichChieu getLich_chieu() {
        return Lich_chieu;
    }

    public String getMaGhe() {
        return MaGhe;
    }

    public String getMaVe()
    {
        return this.Gia_Ve.getMaGV();
    }
    public Long Tien_ve()
    {
        return this.Gia_Ve.getGia();
    }
    
}
