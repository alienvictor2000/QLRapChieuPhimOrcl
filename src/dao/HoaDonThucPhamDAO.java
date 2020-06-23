
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
import model.HoaDonThucPham;

public class HoaDonThucPhamDAO {
     public void insert(HoaDonThucPham model) {
        String sql = "INSERT INTO HoaDonTP(SoHD, MaNV, TongTien, ThoiGian) VALUES(SoHD_HDTP_seq.nextval, ?, ?, sysdate)";
        JdbcHelper.executeUpdate(sql, model.getMaNhanVien(), model.getTongTien());
        try {
            String sql1="SELECT MAX(SoHD) AS LastID FROM HoaDonTP";
            ResultSet rs = JdbcHelper.executeQuery(sql1);
            while (rs.next()){
                int SoHD= rs.getInt(1);
                model.setSoHoaDon(SoHD);
            }
        }
      catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void update(HoaDonThucPham model) {
        String sql = "UPDATE HoaDonTP SET SoHD=?, MaNV=?, TongTien=?, ThoiGian=? WHERE MaHV=?";
        JdbcHelper.executeUpdate(sql, model.getSoHoaDon(), model.getMaNhanVien(), model.getThoiGian());
    }

    public void delete(String maTP) {
        String sql = "DELETE FROM HoaDonTPWHERE SoHD=?";
        JdbcHelper.executeUpdate(sql, maTP);
    }

    public List<HoaDonThucPham> select() {
        String sql = "SELECT * FROM HoaDonTP";
        return select(sql);
    }

    public HoaDonThucPham findById(String maTP) {
        String sql = "SELECT * FROM HoaDonTP WHERE SoHD=?";
        List<HoaDonThucPham> list = select(sql, maTP);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<HoaDonThucPham> select(String sql, Object... args) {
        List<HoaDonThucPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDonThucPham model = readFromResultSet(rs);
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

    private HoaDonThucPham readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonThucPham model = new HoaDonThucPham();
        model.setSoHoaDon(rs.getInt("SoHD"));
        model.setMaNhanVien(rs.getString("MaNV"));
        model.setTongTien(rs.getDouble("TongTien"));
        model.setThoiGian(rs.getString("ThoiGian"));
        return model;
    }
}

