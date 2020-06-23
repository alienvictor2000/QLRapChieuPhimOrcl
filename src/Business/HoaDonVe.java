/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.MuaVeDB;
import java.util.ArrayList;

/**
 *
 * @author Do Di
 */
public class HoaDonVe {
    private Long SoHD;
    private String MaNV ;
    private KhachHang khachhang;
    private long Tong_Tien_ve;
    private long Tong_tien;
    private long GiamGia;
    private ArrayList<CTHDVE> cthdve;

    public HoaDonVe(Long SoHD, String MaNV, KhachHang khachhang, long Tong_Tien_ve, long Tong_tien, long GiamGia, ArrayList<CTHDVE> cthdve) {
        this.SoHD = SoHD;
        this.MaNV = MaNV;
        this.khachhang = khachhang;
        this.Tong_Tien_ve = Tong_Tien_ve;
        this.Tong_tien = Tong_tien;
        this.GiamGia = GiamGia;
        this.cthdve = cthdve;
    }

    public HoaDonVe(Long SoHD, String MaNV) {
        this.SoHD = SoHD;
        this.MaNV = MaNV;
        GiamGia=0;
        this.Tong_Tien_ve=0;
        this.Tong_tien=0;
        
        this.khachhang=null;
        cthdve=new ArrayList<>();
    }
    
    public Long getSoHD() {
        return SoHD;
    }

    public String getMaNV() {
        return MaNV;
    }

    public KhachHang getKhachhang() {
        return khachhang;
    }

    public long getGiamGia() {
        return GiamGia;
    }
    
    public void them_cthdve(CTHDVE cthd)
    {
        this.cthdve.add(cthd);
        this.cap_nhat_hoadon();
    }
    
    public void xoa_vitri(int x)
    {
        this.cthdve.remove(x);
        if(GiamGia!=0)
            Giam_gia();
        this.cap_nhat_hoadon();
    }
    
    public int xoa_cthd(LichChieu lc,String MaGhe)
    {
        int size=this.cthdve.size();
        for(int i=0;i<size;i++)
        {
            if(cthdve.get(i).getLich_chieu().getMaLC()==lc.getMaLC()
                &&cthdve.get(i).getMaGhe().equals(MaGhe))
            {
                xoa_vitri(i);
                return i;
            }
        }
        return -1;
    }
    
    public void cap_nhat_gia_ve(GiaVe gv,int vitri)
    {
        this.cthdve.get(vitri).setGia_Ve(gv);
        cap_nhat_hoadon();
    }
    
    public void cap_nhat_hoadon()
    {
        long tongtien=0;
        int size=this.cthdve.size();
        for(int i=0;i<size;i++)
        {
            tongtien+=cthdve.get(i).Tien_ve();
        }
        this.Tong_Tien_ve=tongtien;
        if(GiamGia!=0)
        {
            this.Giam_gia();
        }
        this.Tong_tien=this.Tong_Tien_ve-this.GiamGia;
    }

    public void setGiamGia(long GiamGia) {
        this.GiamGia = GiamGia;
    }

    public void setKhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }
    
    public void setTongTienVe(long tien)
    {
        this.Tong_Tien_ve=tien;
    }
    
    public void setTongTien(long tien)
    {
        this.Tong_tien=tien;
    }
    
    public void Giam_gia()
    {
        if(khachhang==null)
            this.setGiamGia(0);
        else if(khachhang.getDiemTichLuy()<this.Tong_Tien_ve)
        {
            this.setGiamGia(khachhang.getDiemTichLuy());
        }
        else
        this.setGiamGia(this.Tong_Tien_ve);
        
        this.Tong_tien=this.Tong_Tien_ve-this.GiamGia;
    }

    public long getTong_Tien_ve() {
        return Tong_Tien_ve;
    }

    public long getTong_tien() {
        return Tong_tien;
    }

    public ArrayList<CTHDVE> getCthdve() {
        return cthdve;
    }
    
    public ArrayList<Integer> ghe_da_chon(long MaLC)
    {
        ArrayList<Integer> arr=new ArrayList<>();
        int size=this.cthdve.size();
        for(int i=0;i<size;i++)
        {
            if(this.cthdve.get(i).getLich_chieu().getMaLC()==MaLC)
            {
                arr.add(MuaVeDB.Lay_vi_tri_cho_ngoi(this.cthdve.get(i).getMaGhe()));
            }
        }
        return arr;
    }
    public int kiem_tra_gia_ve()
    {
        int size=cthdve.size();
        if(size==0)
            return -2;
        for(int i=0;i<size;i++)
        {
            if(cthdve.get(i).getMaVe().equals("0"))
                return -3;
        }
        return 0;
    }
    
    public long Luu_hoa_don_ve()
    {
        int x=this.kiem_tra_gia_ve();
        if(x!=0){
            System.out.println("return x Sai");
            return x;
        }
        else
        {   
            System.out.println("Ko return x Đúng");
            return MuaVeDB.them_hoa_don(this);
        }
    }
    
}
