/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reza.model;

import edu.reza.database.kingdatabase;
import edu.reza.entity.Pelanggan;

import edu.reza.eror.pelangganex;
import edu.reza.event.pelangganListener;
import edu.reza.servis.pelanggandao;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class pelangganModel {
    private int id ;
     private String nama ;
      private String alamat ;
       private String telepon ;
       private String email ;
        
   private pelangganListener listener;

    public pelangganListener getListener() {
        return listener;
    }

    public void setListener(pelangganListener listener) {
        this.listener = listener;
    }
   
   
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
        fireOnChange();
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }
        
     protected  void fireOnChange(){
        if(listener != null){ 
            listener.onChange(this);
        }
     }
       protected  void fireonInsert(Pelanggan pelanggan){
           if(listener !=null){
           listener.onInsert(pelanggan);
           }
     }
         protected  void fireonDelate(){
         if(listener != null){ 
            listener.onDelate();
                    }
     }
           protected  void fironUpdate(Pelanggan pelanggan){
          if(listener !=null){
           listener.onUpdate(pelanggan);
                   }
         
     }
           
        public void insertPelanggan() throws SQLException, pelangganex {
        pelanggandao dao = kingdatabase.getPelangganDao();

        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);

        dao.insertpelanggan(pelanggan);
        fireonInsert(pelanggan);

    }

    public void updatePelanggan() throws SQLException, pelangganex{
        pelanggandao dao = kingdatabase.getPelangganDao();

        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);
        pelanggan.setId(id);

        dao.updatepelanggan(pelanggan);
        fironUpdate(pelanggan);
    }

    public void deletePelanggan() throws SQLException, pelangganex {
        
        pelanggandao dao = kingdatabase.getPelangganDao();
        dao.delatepelanggan(id);
        fireonDelate();
    }
    
    public void resetPelanggan(){
        setId(0);
        setNama("");
        setAlamat("");
        setTelepon("");
        setEmail("");
    
    }

}
