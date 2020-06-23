/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Do Di
 */
public class XoaSuaKH {
    public static Connection con=Connect.ket_noi_oracle();
    public static boolean update_kh(String SDT, String Hoten,String DiaChi,String ngay)
    {
       String sql="update khachhang set Hoten='"+Hoten+"',DiaChi='"
               +DiaChi+"',NgaySinh= to_date('"+ngay+"','DD-MM-YYYY') where SDT="+SDT;
       if(con!=null)
       {
           try {
               Statement st=con.createStatement();
               int x=st.executeUpdate(sql);
               if(x==1)
                   return true;
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       return false;
    }
     public static boolean delete_kh(String SDT)
    {
        String sql="delete from khachhang where SDT='"+SDT+"'";
        String sql2="delete from TaiKhoan where TenDangNhap='"+SDT+"'";
          if(con!=null)
       {
           try {
               Statement st=con.createStatement();
               st.executeUpdate(sql2);
               st.executeUpdate(sql);
           } catch (SQLException e) {
               e.printStackTrace();
               return false;
           }
           return true;
       }
       return false;
    }
    
}
