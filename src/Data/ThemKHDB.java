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
public class ThemKHDB {
    public static Connection con=Connect.ket_noi_oracle();
    public static boolean themKH(String sdt,String password,String diachi,char gioitinh,String hoten,String ngSinh,String CMND) throws SQLException
    {
        if(con!=null)
        {
            
            try {
                con.setAutoCommit(false);
                con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                String sql1="insert into TaiKhoan values('"+sdt+"','"+password+"','kh')";
                String sql="insert into KhachHang values('"+sdt+"','"+hoten+"','"+CMND+"','"+gioitinh+"',to_date('"
                        +ngSinh+"','DD-MM-YYYY'),'"+diachi+"',NULL,0,0)";
                Statement st=con.createStatement();
                st.executeUpdate(sql1);
                st.executeUpdate(sql);
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                con.rollback();
                return false;
            }
            return true;
        }
        return false;
    }
    
}
