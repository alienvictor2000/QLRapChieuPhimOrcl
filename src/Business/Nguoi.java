/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author Do Di
 */
public class Nguoi {
     protected String SDT;
    protected String hoten;
    protected String CMND;
    protected char GioiTinh;
    protected Date NgaySinh;
    protected String diachi;  

    public Nguoi(String SDT, String hoten, String CMND, char GioiTinh, Date NgaySinh, String diachi) {
        this.SDT = SDT;
        this.hoten = hoten;
        this.CMND = CMND;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.diachi = diachi;
    }

    public Nguoi() {
        this.SDT = null;
        this.hoten = null;
        this.CMND = null;
        this.GioiTinh = 'F';
        this.NgaySinh = null;
        this.diachi = null;
    }
    
    
    

   

    

    public String getHoten() {
        return hoten;
    }
    
    public String getCMND() {
        return CMND;
    }

    public String getSDT() {
        return SDT;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public char getGioiTinh() {
        return GioiTinh;
    }

    public String getDiachi() {
        return diachi;
    }
     
}
