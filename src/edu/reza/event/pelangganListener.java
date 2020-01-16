/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reza.event;

import edu.reza.entity.Pelanggan;
import edu.reza.model.pelangganModel;

/**
 *
 * @author User
 */
public interface pelangganListener {
    public void onChange(pelangganModel model);
    public void onInsert(Pelanggan pelanggan);
    public void onDelate();
    public void onUpdate(Pelanggan pelanggan);

   
    
}
