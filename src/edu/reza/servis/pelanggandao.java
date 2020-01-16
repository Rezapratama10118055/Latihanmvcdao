/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reza.servis;

import edu.reza.entity.Pelanggan;
import edu.reza.eror.pelangganex;
import java.util.List;

/**
 *
 * @author User
 */
public interface pelanggandao {
    public void insertpelanggan(Pelanggan pelanggan)throws pelangganex;
    public void updatepelanggan(Pelanggan pelanggan)throws pelangganex;
    public void delatepelanggan(Integer ID)throws pelangganex;
    public Pelanggan getpelanggan(Integer ID)throws pelangganex;
    public Pelanggan getpelanggan(String email)throws pelangganex;
    public List<Pelanggan>selectAllPelanggan() throws pelangganex;
}
