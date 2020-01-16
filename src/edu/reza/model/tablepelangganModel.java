/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reza.model;

import edu.reza.entity.Pelanggan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class tablepelangganModel extends AbstractTableModel {

    private List<Pelanggan> list = new ArrayList<Pelanggan>();

    public void setList(List<Pelanggan> list) {
        this.list = list;
    }
    
    
    @Override
    public int getRowCount() {
        
   return list.size();
        
    }

    @Override
    public int getColumnCount() {
        return 5;                
    }

    public boolean add(Pelanggan e) {
        try {
          return list.add(e);
        } finally {
        
        fireTableRowsInserted(getColumnCount()-1, getRowCount()-1);
    }
    }

    public Pelanggan get(int index) {
        return list.get(index);
    }

    public Pelanggan set(int index, Pelanggan element) {
        try {
           return list.set(index, element); 
        } finally {
            fireTableRowsUpdated(index, index);
        }
        
    }

    public Pelanggan remove(int index) {
        try {
             return list.remove(index); 
        }finally{
        
        fireTableRowsDeleted(index, index);
    }
    }
    

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0 : 
                return "ID";
                case 1: 
                    return "Nama";
                    case 2 :
                        return "Alamat";
                        case 3 :
                            return "Telpon";
                            case 4 :
                                return "Email";
                                default:
                                    return null;
        }
        
        }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
     switch(columnIndex){
         case 0 :
             return list.get(rowIndex).getId();
             case 1 : 
                 return list.get(rowIndex).getNama();
             case 2:
                 return list.get(rowIndex).getAlamat();
             case 3 :
                 return list.get(rowIndex).getTelepon();
             case 4 :
                 return list.get(rowIndex).getEmail();
                 
                 default:
               return null;
     }
    }
    
}
