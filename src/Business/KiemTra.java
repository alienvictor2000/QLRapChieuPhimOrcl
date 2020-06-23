/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.ThemPhimDB;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Do Di
 */
public class KiemTra {
    public static boolean kiem_tra_so(String str)
    {
        int size=str.length();
        if(size==0)
            return false;
        for(int i=0;i<size;i++)
        {
            if(str.charAt(i)<'0' || str.charAt(i)>'9')
                return false;
        }
        return true;
    }
    public static boolean coppy(String link,long newLink)
    {
        int width=640;
        int height=360;
        BufferedImage image=null;
        File f=null;
        try {
           f=new File(link); 
           image=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
           image=ImageIO.read(f);
        } catch (Exception e) {
            return false;
        }
        try {
            String localDir = System.getProperty("user.dir");
            String str=localDir+"\\src\\HinhAnh\\"
                    +newLink+".jpg";
            f=new File(str);
            ImageIO.write(image, "jpg", f);
        } catch (IOException e) {
            f.delete();
            return false;
        }
        return true;     
    }
    public static String CauLenhSQL(String SDT,String Hoten,String DiaChi,String CMND,String date,String tu,String den)
    {
        String str="select SDT,hoten,cmnd,ngaysinh,diachi,ngaymuagannhat,"
                + "diemtichluy,tongdiemtichluy from khachhang ";
        String str2="";
        int x=0;
        if(SDT.equals("")==false)
        {
            x++;
            str2="SDT='"+SDT+"'";
        }
        if(Hoten.equals("")==false)
        {
            String chuoi="hoten like ('%"+Hoten+"%')";
            if(x==0)
            {
                str2=chuoi;
                x++;
            }
            else
            {
                str2=str2 +" and "+chuoi;
            }
                
        }
        if(DiaChi.equals("")==false)
        {
            String chuoi="diachi = '"+DiaChi+"'";
            if(x==0)
            {
                str2=chuoi;
                x++;
            }
            else
            {
                str2=str2 +" and "+chuoi;
            }
                
        }
        if(CMND.equals("")==false)
        {
            String chuoi="CMND = '"+CMND+"'";
            if(x==0)
            {
                str2=chuoi;
                x++;
            }
            else
            {
                str2=str2+" and "+chuoi;
            }
                
        }
        if(date.equals("")==false)
        {
            String chuoi="NgaySinh = to_date('"+date+"','DD-MM-YYYY')";
            if(x==0)
            {
                str2=chuoi;
                x++;
            }
            else
            {
                str2=str2+" and "+chuoi;
            }
        }
        if(tu.equals("")==false)
        {
            String chuoi="TongDiemTichLuy >= "+tu;
            if(x==0)
            {
                str2=chuoi;
                x++;
            }
            else
            {
                str2=str2+" and "+chuoi;
            }
        }
        if(den.equals("")==false)
        {
            String chuoi="TongDiemTichLuy <= "+den;
            if(x==0)
            {
                str2=chuoi;
                x++;
            }
            else
            {
                str2=str2+" and "+chuoi;
            }
        }
        if(str2.equals("")==false)
            str2="where "+str2;
        str=str+str2;
        return str;
    }
    public static boolean luu_phim(String tenphim,String TheLoai,
            String NhaSX,int DoTuoi,int thoiLuong,String ViTriFileAnh)
    {
        Phim phim = new Phim(-1,tenphim,TheLoai,NhaSX,DoTuoi,thoiLuong);
            long ten_file_anh=phim.luu_phim();
            if(ten_file_anh!=-1)
            {
               if(coppy(ViTriFileAnh,ten_file_anh)==false)
               {
                   ThemPhimDB.xoa_phim(ten_file_anh);
                   return false;
               }
               return true;
            }
            return false;
    }
}
