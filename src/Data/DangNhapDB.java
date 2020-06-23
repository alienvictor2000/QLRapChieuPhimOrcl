/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Do Di
 */
public class DangNhapDB {
    public static Connection con=Connect.ket_noi_oracle();
    
    public static boolean Kiem_Tra_MK(String taikhoan,String MatKhau)
    {
        if(con!=null)
        {
            try {
                String sql="select * from taikhoan where TenDangNhap='"+taikhoan+
                    "' and MatKhau='"+MatKhau+"' and MaLoai='NVBV'";
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery(sql);
                if(rs.next())
                    return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
