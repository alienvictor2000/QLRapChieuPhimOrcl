/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Do Di
 */
public class ChuyenDoiNgayGio {
    public static Date String_sang_Date(String str)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        try {
            Date date = formatter.parse(str);
          
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String Date_sang_String(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateFormat = formatter.format(date);
		return dateFormat;
    }
    
    public static String Lay_gio_phut(Date date)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		String dateFormat = formatter.format(date);
		return dateFormat;
    }
    
}
