/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Do Di
 */
public class Connect {
    public static Connection con=null;
    public static Connection ket_noi_oracle() {
        try {
        String sql="jdbc:oracle:thin:@localhost:1521:orcl";
        con=DriverManager.getConnection(sql,"QuanLyRapChieuPhimOrcl","QuanLyRapChieuPhimOrcl");

         } catch (SQLException e) {
        }
        return con;
    }
    public static boolean close_data(Connection con)
    {
        try {
            con.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
}
