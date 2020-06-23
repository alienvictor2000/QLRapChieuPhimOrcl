/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.GiaVe;
import Business.HoaDonVe;
import Business.KhachHang;
import Business.LichChieu;
import Business.Phim;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Do Di
 */
public class MuaVeDB {
    public static Connection con=Connect.ket_noi_oracle();
    
    public static ArrayList<LichChieu> lay_lich_chieu()
    {
        ArrayList<LichChieu> arr=new ArrayList<>();
        if(con!=null)
        {
            try {
                String sql="select lc.malc,lc.mapc,to_char(lc.ngaygiochieu,'DD-MM-YYYY hh24:mi'),p.MaPhim,p.TenPhim,p.THELOAI,p.NhaSX,p.DoTuoi,p.thoiluong\n" +
    "from lichchieu lc , phim p\n" +
    "where lc.maphim=p.maphim and to_char(lc.ngaygiochieu,'YYYY-MM-DD hh24:mi') < to_char(SYSdate,'YYYY-MM-DD hh24:mi')\n" +
    "order by p.MaPhim ASC, lc.ngaygiochieu";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
                while(rs.next())
                {
                   Phim p=new Phim(rs.getLong(4), rs.getString(5), rs.getString(6).trim(),
                           rs.getString(7),(int) rs.getLong(8),(int) rs.getLong(9));
                   arr.add(new LichChieu(rs.getLong(1),rs.getString(2),rs.getString(3),p));
                }
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            return arr;
        }
            return null;
    }
    
    public static ArrayList<GiaVe> Lay_danh_sach_gia_ve()
    {
        ArrayList<GiaVe> arr=new ArrayList<>();
        if(con!=null)
        {
            try {
                String sql="Select * from GiaVe";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
                while(rs.next())
                {
                    arr.add(new GiaVe(rs.getString(1),rs.getLong(2),rs.getString(3),rs.getString(4)));
                }
                System.out.println("Lấy giá vé từ dtb");
            } catch (Exception e) {
                return null;
            }
            
            return arr;
        }
        return null;
    }
    
    public static int Lay_vi_tri_cho_ngoi(String str)
    {
        int x=-1;
        x=x+(str.charAt(0)-'A')*15;
        x=x+Integer.parseInt(str.substring(1, 3));
        return x;
    }
    
    public static ArrayList<Integer> danh_sach_ghe_da_mua(long MaLC)
    {
        if(con!=null)
        {
            ArrayList<Integer> arr=new ArrayList<>();
            try {
            String sql="Select Maghe from CTHDVE where MaLC= "+MaLC;
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                arr.add(Lay_vi_tri_cho_ngoi(rs.getString(1).trim()));
            }
            } catch (Exception e) {
                return null;
            }
            return arr;           
        }
        return null;
    }
    public static KhachHang lay_diem_tich_luy(String SDT)
    {
        try {
            String sql="select SDT,DiemTichLuy from khachhang where SDT='"+SDT+"'";
            Statement st=con.createStatement();
           
            ResultSet rs=st.executeQuery(sql);
            if(rs.next())
            {
                return new KhachHang(rs.getString(1),rs.getLong(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static long them_hoa_don(HoaDonVe hoadon)
    {
        long x=-1;
        if(con!=null)
        {
            try {
                con.setAutoCommit(false);
                con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                CallableStatement cs;
               
                if(hoadon.getKhachhang()!=null)
                {   
                    System.out.println("Lấy được KH");
                    cs=con.prepareCall("{call Them_Hoa_Don_ve(?,?,?,?,?)}");
                    cs.registerOutParameter(1, Types.INTEGER);
                    cs.setString(2, hoadon.getMaNV());
                    cs.setString(3, hoadon.getKhachhang().getSDT());
                    cs.setLong(4, hoadon.getTong_tien());
                    cs.setLong(5, hoadon.getGiamGia()); 
                }
                else
                {
                    System.out.println("Ko lấy được KH");
                    cs=con.prepareCall("{call Them_Hoa_Don_ve2(?,?,?,?)}");
                    cs.registerOutParameter(1, Types.INTEGER);
                    cs.setString(2, hoadon.getMaNV());
                    cs.setLong(3, hoadon.getTong_tien());
                    cs.setLong(4, hoadon.getGiamGia()); 
                }
                 System.out.println("Ra khỏi if chuẩn bị exec");
                 cs.execute();
                 x=cs.getLong(1);
                
                 int size=hoadon.getCthdve().size();
                 System.out.println(size);
                 cs=con.prepareCall("{call them_cthdve(?,?,?,?)}");
               
                 for(int i=0;i<size;i++)
                 {  
                    System.out.println("Thêm cthdve");
                     cs.setLong(1, x);
                     cs.setLong(2, hoadon.getCthdve().get(i).getLich_chieu().getMaLC());
                     cs.setString(3, hoadon.getCthdve().get(i).getMaGhe());
                     cs.setString(4, hoadon.getCthdve().get(i).getMaVe());
                     cs.execute();
                     System.out.println("Đã thêm cthdve");
                 }        
                 System.out.println("Commit");
                 con.commit();               
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    System.out.println("Bị rollback");
                    con.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(MuaVeDB.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Exception");
                return -1;
            }
        }
        return x;
    }
        
  
}
