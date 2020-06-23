/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.MuaVeDB;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Do Di
 */
public class DieuKhienMuaVe {
    public static ArrayList lay_danh_sach_phim(ArrayList<LichChieu> lc)
    {
        ArrayList<ArrayList> arr=new ArrayList<>();
        int size=lc.size();
        int size_of_arr=-1;
        if(size>0)
        {
            ArrayList<String> phim=new ArrayList<>();
            phim.add(lc.get(0).getPhim().getMaPhim()+"");
            phim.add(lc.get(0).getPhim().getTenPhim());
            phim.add(0+"");
            phim.add(0+"");
            arr.add(phim);
            size_of_arr=0;
        }
        
        for(int i=1;i<size;i++)
        {
            if(lc.get(i).getPhim().getMaPhim()!=lc.get(i-1).getPhim().getMaPhim())
            {
            ArrayList<String> phim=new ArrayList<>();
            phim.add(lc.get(i).getPhim().getMaPhim()+"");
            phim.add(lc.get(i).getPhim().getTenPhim());
            phim.add(i+"");
            phim.add(i+"");
            arr.add(phim);
            size_of_arr++;
            }
            else
            {
                arr.get(size_of_arr).set(3,i+"");
            }
        }
        return arr;
    }
    
    public static ArrayList lay_danh_ngay_chieu(ArrayList<LichChieu> lc,ArrayList<String> phim)
    {
        ArrayList<ArrayList> arr=new ArrayList<>();
        int size=Integer.parseInt(phim.get(3))+1;
        int i=Integer.parseInt(phim.get(2));
        ArrayList<String> NgayChieu=new ArrayList<>();
        
        NgayChieu.add(lc.get(i).getNgayGioChieu().substring(0, 10));
        NgayChieu.add(i+"");
        NgayChieu.add(i+"");
        arr.add(NgayChieu);
        
        
        int size_of_arr=0;
        for(i=i+1;i<size;i++)
        {
            if(lc.get(i).getNgayGioChieu().substring(0, 10).equals
            (lc.get(i-1).getNgayGioChieu().substring(0, 10))==false)
            {
            ArrayList<String> NgayChieu1=new ArrayList<>();
            NgayChieu1.add(lc.get(i).getNgayGioChieu().substring(0, 10));
            NgayChieu1.add(i+"");
            NgayChieu1.add(i+"");
            arr.add(NgayChieu1);
            size_of_arr++;
            }
            else
            {
                arr.get(size_of_arr).set(2, i+"");
            }
            
        }
        return arr;
    }
    
    public static ArrayList Lay_Gio_chieu(ArrayList<LichChieu> lc,ArrayList<String> NgayChieu)
    {
        ArrayList<ArrayList> arr=new ArrayList<>();
        int size=Integer.parseInt(NgayChieu.get(2))+1;
        int i=Integer.parseInt(NgayChieu.get(1));
        for(;i<size;i++)
        {
            ArrayList<String> GioChieu=new ArrayList<>();
            GioChieu.add(lc.get(i).getNgayGioChieu().substring(11,16));
            GioChieu.add(i+"");
            arr.add(GioChieu);
        }
        return arr;
    }
    
         
    
    public static void hien_thi_ghe_trong(JButton arr[],HoaDonVe hd,long MaLC)
    {
        Lam_moi_ghe(arr);
        ArrayList<Integer> ghe_da_mua=MuaVeDB.danh_sach_ghe_da_mua(MaLC);
        int size=ghe_da_mua.size();
        for(int i=0;i<size;i++)
        {
            arr[ghe_da_mua.get(i)].setBackground(new java.awt.Color(153, 153, 153));
        }
        
        ArrayList<Integer> ghe_da_chon=hd.ghe_da_chon(MaLC);
            size=ghe_da_chon.size();
        for(int i=0;i<size;i++)
        {
            arr[ghe_da_chon.get(i)].setBackground(new java.awt.Color(255, 153, 0));
        }
    }
    
    public static void Lam_moi_ghe(JButton arr[])
    {
        for(int i=0;i<150;i++)
            arr[i].setBackground(new java.awt.Color(153, 0, 51));
    }
    public static int kiem_tra_mau_button(JButton a)
    {
        if(a.getBackground().toString().equals("java.awt.Color[r=153,g=0,b=51]"))
            return 1;       
        else if(a.getBackground().toString().equals("java.awt.Color[r=255,g=153,b=0]"))
            return 0;
        return -1;
    }
    
    public static void Xu_ly_chon_ghe(LichChieu lc,HoaDonVe hd,JButton button,JTable table)
    {
        DefaultTableModel dtm= (DefaultTableModel) table.getModel();
       if(kiem_tra_mau_button(button)==1)
       {
           button.setBackground(new java.awt.Color(255, 153, 0));
            
            Object []ob={lc.getPhim().getTenPhim(),button.getText(),
                lc.getNgayGioChieu().substring(0, 10),lc.getNgayGioChieu().substring(11, 16),"chon loai ve",0};
            dtm.addRow(ob); 
            hd.them_cthdve(new CTHDVE(lc, button.getText()));
       }
       else if(kiem_tra_mau_button(button)==0)
       {
           button.setBackground(new java.awt.Color(153, 0, 51));
           int vitri=hd.xoa_cthd(lc, button.getText());
           dtm.removeRow(vitri);
       }
       
    }
    
}
