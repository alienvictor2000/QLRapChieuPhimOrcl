/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helper.JasperHelper;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTextField;

/**
 *
 * @author Vi Yêu
 */
public class ThongKeController {
    public static void ThongKeTheoThang(JTextField txt){
     Object x =  txt.getText(); 
       Map<String, Object> parameter = new HashMap<String, Object>();
       parameter.put("THANG", x);
       String localDir = System.getProperty("user.dir");
       JasperHelper.Report(localDir+"\\src\\jasperreport\\ThongKeDoanhThuTheoThang.jrxml",parameter);  
}
}
