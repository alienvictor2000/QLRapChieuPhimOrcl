/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Container;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Do Di
 */
public class ReportView extends JFrame{
    public ReportView(HashMap hs,String filename) throws JRException
    {     
        super("View report");
        Connection con=Data.Connect.ket_noi_oracle();
        JasperReport jsr=JasperCompileManager.compileReport(filename);
        System.out.println("loi");
        
        //int x=5;
        //hs.put("SOHD", BigDecimal.valueOf(x));
        JasperPrint print = JasperFillManager.fillReport(jsr,hs,con);
         System.out.println("loi");
        JRViewer view = new JRViewer(print);
         System.out.println("loi");
        Container c = getContentPane();
        c.add(view);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args) throws JRException {
        String filename="C:\\Users\\nnguy\\Desktop\\Oracle\\RapChieuPhim\\RapChieuPhim\\src\\Report\\newReport1.jrxml";
        HashMap hs=new HashMap();
        hs.put("SoHD",BigDecimal.valueOf(8));
        ReportView p=new ReportView(hs,filename);
        p.setBounds(10, 10, 900, 600);
        p.setResizable(false);
        p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        p.setVisible(true);
    } 
}
