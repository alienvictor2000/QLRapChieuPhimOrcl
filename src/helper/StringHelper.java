/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.text.DecimalFormat;

/**
 *
 * @author Vi Yêu
 */
public class StringHelper {
    public static String ChuyenDoi(double tien){
    DecimalFormat formatter = new DecimalFormat("###,###,###"); 
    return formatter.format(tien)+ " VND"; 
    }
}
