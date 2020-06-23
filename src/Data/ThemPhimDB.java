/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Business.Phim;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Do Di
 */
public class ThemPhimDB {
   public static  Connection con=Connect.ket_noi_oracle();
   
   public static long them_phim(Phim phim) 
   {
       if(con!=null)
       {
           try {
           CallableStatement st=con.prepareCall("{ call them_phim(?,?,?,?,?,?) }");
           st.setString(2, phim.getTenPhim());
           st.setString(3, phim.getTheLoai());
           st.setString(4, phim.getNhaSX());
           st.setLong(5, phim.getDoTuoi());
           st.setLong(6, phim.getThoiLuong());
           st.registerOutParameter(1, (int) phim.getMaPhim());
           st.execute();
           phim.setMaPhim(st.getLong(1));
           } catch (Exception e) {
               return -1;
           }
       }
      return  phim.getMaPhim();
   }
   public static boolean xoa_phim(long MaPhim)
   {
       try {
           CallableStatement st=con.prepareCall("{call xoa_phim(?)}");
           st.setLong(1, MaPhim);
           st.execute();
       } catch (SQLException ex) {
           return false;
       }
       return true;
   }
}
