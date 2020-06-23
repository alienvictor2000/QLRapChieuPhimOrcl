/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.LichChieu;
import Business.Phim;
import Business.PhongChieu;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Do Di
 */
public class ThemLichChieuDB {
     public static Connection con=Connect.ket_noi_oracle();
    public static ArrayList<Phim> lay_danh_sach_phim()
    {
        ArrayList<Phim> arr=new ArrayList<>();
        try {
            Statement st=con.createStatement();
            ResultSet rs =st.executeQuery("select * from phim");
            while(rs.next())
            {
                arr.add(new Phim(rs.getLong(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), (int)rs.getLong(5) , (int)rs.getLong(6)));
            }           
        } catch (Exception e) {
            return null;
        }
        return arr;
    }
    
    public static ArrayList<PhongChieu> lay_danh_sach_phong()
    {
        ArrayList<PhongChieu> arr=new ArrayList<>();
        try {
            Statement st=con.createStatement();
            ResultSet rs =st.executeQuery("select * from PhongChieu");
            while(rs.next())
            {
                arr.add(new PhongChieu(rs.getString(1), rs.getString(2), (int)rs.getLong(3)));
            }           
        } catch (SQLException e) {
            return null;
        }
        return arr;
    }
    
    public static long luu_lich_chieu(LichChieu lc)
    {
        if(con!=null)
        {
            try {
                CallableStatement cs= con.prepareCall("{call them_lich_chieu(?,?,?,?)}");
                cs.registerOutParameter(1, Types.INTEGER);
                cs.setString(2, lc.getMaPC());
                cs.setString(3, lc.getNgayGioChieu());
                cs.setLong(4, lc.getPhim().getMaPhim());
                cs.execute();
                lc.setMaLC(cs.getLong(1));
            } catch (SQLException ex) {
                return -1;
            }
            return lc.getMaLC();
        }
        return -1;
    }
    
//    public static void main(String[] args) {
//            Phim phim=new Phim(23,"ddd","ffff","ssss",15,150);
//            LichChieu lc=new LichChieu(-1,"PC001","13-04-2019 8:0", phim);
//            System.out.println(luu_lich_chieu(lc));
//    }
    
}
