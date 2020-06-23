/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Muc;
import java.util.List;
import java.util.ArrayList;
import model.ThucPham;

public class GioHang extends ArrayList<Muc> {

    public double getTongTien() {
        double tongTien = 0;
        for (Muc muc : this) {
            tongTien = tongTien + muc.getSoLuong() * muc.getThucPham().getDonGia();
        }
        return tongTien;
    }

    public void KiemTraThem(ThucPham thucPham, int soLuong) {
        // kiem tra thuc pham da ton tai hay chua
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getThucPham().getMaThucPham().equals(thucPham.getMaThucPham())) {
                int soLuongHienTai = this.get(i).getSoLuong() + soLuong;
                this.get(i).setSoLuong(soLuongHienTai);
                return;
            }
        }

        // neu tim khong thay thi add vao gio hang
        Muc muc = new Muc(thucPham, soLuong);
        this.add(muc);
    }
}
