/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChiTietHoaDonThucPhamDAO;
import dao.HoaDonThucPhamDAO;
import dao.ThucPhamDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.ChiTietHoaDonThucPham;
import model.GioHang;
import model.HoaDonThucPham;
import model.Muc;
import model.ThucPham;

/**
 *
 * @author Vi Yêu
 */
public class BanThucPhamController {
    public static void HienThi(DefaultTableModel model){
          try {
            // lấy dữ liệu từ CSDL 
            List<ThucPham> list = new ThucPhamDAO().select();

            // thêm tất cả những gì trong danh sách vừa lấy vào mô hình bảng
            for (ThucPham tp : list) {
                Object[] row = {tp.getMaThucPham(), tp.getTenThucPham(), tp.getDonViTinh(), tp.getDonGia()};
                model.addRow(row);
            }
        } catch (Exception e) {
            System.out.println("Lỗi truy vấn dữ liệu! ");
        }
    }
          
    public static void Them(GioHang gioHang, DefaultTableModel model){
    for (Muc muc : gioHang) {
            ThucPham tp = muc.getThucPham();
            Object[] row = {tp.getTenThucPham(), muc.getSoLuong(), tp.getDonGia(), muc.getThanhTien()};
            model.addRow(row);
        }
    }
    
    public static void Luu(GioHang gioHang,String MaNV){
        HoaDonThucPham hoaDonThucPham = new HoaDonThucPham(); 
        hoaDonThucPham.setMaNhanVien(MaNV);
        hoaDonThucPham.setTongTien(gioHang.getTongTien());
        HoaDonThucPhamDAO HDTPDAO = new HoaDonThucPhamDAO();
        HDTPDAO.insert(hoaDonThucPham);
        ArrayList<ChiTietHoaDonThucPham> CTHDTP = new ArrayList<ChiTietHoaDonThucPham>();
        int c = 0;
        for (c = 0; c < gioHang.size(); c++) {
            ChiTietHoaDonThucPham i = new ChiTietHoaDonThucPham();
            ThucPham thucPham = gioHang.get(c).getThucPham();
            i.setMaThucPham(thucPham.getMaThucPham());
            i.setSoLuong(gioHang.get(c).getSoLuong());
            i.setThanhTien(gioHang.get(c).getThanhTien());
            new ChiTietHoaDonThucPhamDAO().insert(i, hoaDonThucPham);
        }
    }
}
