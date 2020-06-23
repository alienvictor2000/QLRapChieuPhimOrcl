/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietHoaDonThucPham;
import model.HoaDonThucPham;

    public class ChiTietHoaDonThucPhamDAO {
     public void insert(ChiTietHoaDonThucPham model, HoaDonThucPham model1) {
        String sql = "INSERT INTO CTHDTP (SoHD, MaTP, SL, ThanhTien) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,model1.getSoHoaDon(), model.getMaThucPham(), model.getSoLuong(), model.getThanhTien());
    }

    public void update(ChiTietHoaDonThucPham model) {
        String sql = "UPDATE CTHDTP SET SoHD=?, MaTP=?, SL=?, ThanhTien=? WHERE MaHV=?";
        JdbcHelper.executeUpdate(sql, model.getSoHoaDon(), model.getMaThucPham(), model.getThanhTien());
    }

    public void delete(String maTP) {
        String sql = "DELETE FROM CTHDTP WHERE SoHD=?";
        JdbcHelper.executeUpdate(sql, maTP);
    }

    public List<ChiTietHoaDonThucPham> select() {
        String sql = "SELECT * FROM CTHDTP";
        return select(sql);
    }

    public ChiTietHoaDonThucPham findById(String maTP) {
        String sql = "SELECT * FROM CTHDTP WHERE SoHD=?";
        List<ChiTietHoaDonThucPham> list = select(sql, maTP);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<ChiTietHoaDonThucPham> select(String sql, Object... args) {
        List<ChiTietHoaDonThucPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    ChiTietHoaDonThucPham model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private ChiTietHoaDonThucPham readFromResultSet(ResultSet rs) throws SQLException {
        ChiTietHoaDonThucPham model = new ChiTietHoaDonThucPham();
        model.setSoHoaDon(rs.getInt("SoHD"));
        model.setMaThucPham(rs.getString("MaTP"));
        model.setSoLuong(rs.getInt("SL"));
        model.setThanhTien(rs.getDouble("ThanhTien"));
        return model;
    }
}




