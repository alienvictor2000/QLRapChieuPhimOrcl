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
import model.ThucPham;

/**
 *
 * @author Vi Yêu
 */
public class ThucPhamDAO {

    public void insert(ThucPham model) {
        String sql = "INSERT INTO ThucPham(MaTP, TenTP, DonViTinh, Gia) VALUES(?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaThucPham(), model.getTenThucPham(), model.getDonViTinh(), model.getDonGia());
    }

    public void update(ThucPham model) {
        String sql = "UPDATE ThucPham SET MaTP=?, TenTP=?, DonViTinh=?, Gia=? WHERE MaHV=?";
        JdbcHelper.executeUpdate(sql, model.getMaThucPham(), model.getTenThucPham(), model.getDonGia());
    }

    public void delete(String maTP) {
        String sql = "DELETE FROM ThucPham WHERE MaTP=?";
        JdbcHelper.executeUpdate(sql, maTP);
    }

    public List<ThucPham> select() {
        String sql = "SELECT * FROM ThucPham";
        return select(sql);
    }

    public ThucPham findById(String maTP) {
        String sql = "SELECT * FROM ThucPham WHERE MaTP=?";
        List<ThucPham> list = select(sql, maTP);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<ThucPham> select(String sql, Object... args) {
        List<ThucPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    ThucPham model = readFromResultSet(rs);
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

    private ThucPham readFromResultSet(ResultSet rs) throws SQLException {
        ThucPham model = new ThucPham();
        model.setMaThucPham(rs.getString("MaTP"));
        model.setTenThucPham(rs.getString("TenTP"));
        model.setDonViTinh(rs.getString("DonViTinh"));
        model.setDonGia(rs.getDouble("Gia"));
        return model;
    }
}
