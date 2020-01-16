/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reza.impl;


import edu.reza.entity.Pelanggan;
import edu.reza.eror.pelangganex;
import edu.reza.servis.pelanggandao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class pelanggandaoimpl implements pelanggandao{
    
    private Connection connection;
    
    private final String insertpelanggan ="INSERT INTO pelanggan (NAMA,ALAMAT,TELPON,EMAIL)VALUES(?,?,?,?)";

    private final String updatepelanggan ="UPDATE PELANGGAN SET NAMA=?,ALAMAT=?,TELEPON=?,EMAIL=? WHARE ID=?";
    
    private final String dalatepelanggan ="DELETE PELANGGAN WHERE ID=? ";
    
    private  final String getById = "SELECT* FROM PELANGGAN WHERE ID=?";
    
     private  final String getByEmail = "SELECT* FROM PELANGGAN WHERE EMAIL=?";
    
     private final String selectAll = "SELECT*FROM PELANGGGAN ";
             
    public pelanggandaoimpl(Connection connection) {
        this.connection = connection;
    }
    
    

    @Override
    public void insertpelanggan(Pelanggan pelanggan) throws pelangganex {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            
            statement = connection.prepareStatement(insertpelanggan,statement.RETURN_GENERATED_KEYS);
            statement.setString(1,pelanggan.getNama());
            statement.setString(2,pelanggan.getAlamat());
             statement.setString(3, pelanggan.getTelepon());
            statement.setString(4,pelanggan.getEmail());
            statement.executeUpdate();
            
            ResultSet result  = statement.getGeneratedKeys();
            if (result.next()) {
                pelanggan.setId(result.getInt(1));
            }
            
            connection.commit();
                    
            
        } catch (SQLException exception) {
            try {
                connection.rollback();
                
            } catch (SQLException ex) {
            }
           throw  new pelangganex(exception.getMessage()); 
            
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
          if(statement!=null){  
        try {
                statement.close();
                
            } catch (SQLException exception) {
            }
          }
        }
    }

    @Override
    public void updatepelanggan(Pelanggan pelanggan) throws pelangganex {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            
            statement = connection.prepareStatement(updatepelanggan);
            statement.setString(1,pelanggan.getNama());
            statement.setString(2,pelanggan.getAlamat());
             statement.setString(3, pelanggan.getTelepon());
            statement.setString(4,pelanggan.getEmail());
            statement.setInt(5,pelanggan.getId());
            statement.executeUpdate();
                  connection.commit();     
            
        }  catch (SQLException e) {
            try {
                connection.rollback();
                
            } catch (SQLException ex) {
            }
             
            throw  new pelangganex(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
          if(statement!=null){  
        try {
                statement.close();
                
            } catch (SQLException e) {
            }
          }
        }
    }

    

    @Override
    public void delatepelanggan(Integer ID) throws pelangganex {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(dalatepelanggan);
            statement.setInt(1,ID);
           
            statement.executeUpdate();
                 connection.commit();      
            
        }  catch (SQLException e) {
            try {
                connection.rollback();
                
            } catch (SQLException ex) {
            }
            
            
            
            throw  new pelangganex(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
          if(statement!=null){  
        try {
                statement.close();
                
            } catch (SQLException e) {
            }
          }
        }
    }
  
    

    @Override
    public Pelanggan getpelanggan(Integer id) throws pelangganex {
     PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(getById);
         
            statement.setInt(1,id);
            ResultSet result = statement.executeQuery();
            Pelanggan pelanggan = null;
            
            if(result.next()){
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
               pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
            }else{
                throw new pelangganex("pelanggan dengan id "+id+"tidak di temukan");
            }
               connection.commit();
           return pelanggan;
            
        } catch (SQLException e) {
            try {
                connection.rollback();
                
            } catch (SQLException ex) {
            }
            
            
            
            throw  new pelangganex(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
          if(statement!=null){  
        try {
                statement.close();
                
            } catch (SQLException e) {
            }
          }
        }
    }


    @Override
    public Pelanggan getpelanggan(String Email) throws pelangganex {
     PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(getByEmail);
            statement.setString(1,Email);
            ResultSet result = statement.executeQuery();
            Pelanggan pelanggan = null;
            
            if(result.next()){
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
            }else{
                throw new pelangganex("pelanggan dengan email "+Email+"tidak di temukan");
            }
               connection.commit();
           return pelanggan;
            
        } catch (SQLException e) {
            try {
                connection.rollback();
                
            } catch (SQLException ex) {
            }
            
            
            
            throw  new pelangganex(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
          if(statement!=null){  
        try {
                statement.close();
                
            } catch (SQLException e) {
            }
          }
        }
    }   
    

 @Override
  public List<Pelanggan> selectAllPelanggan() throws pelangganex {
   Statement statement = null;
   List<Pelanggan> list = new ArrayList<Pelanggan>();
   
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
           
            
            while(result.next()){
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                list.add(pelanggan);
            }
               connection.commit();
           return list;
            
        }  catch (SQLException e) {
            try {
                connection.rollback();
                
            } catch (SQLException ex) {
            }
            
           throw  new pelangganex(e.getMessage());
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
          if(statement!=null){  
        try {
                statement.close();
                
            } catch (SQLException e) {
            }
          }
        }   
  }

   
        
    }

    
   

