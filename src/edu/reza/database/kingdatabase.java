/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.reza.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import edu.reza.impl.pelanggandaoimpl;
import edu.reza.servis.pelanggandao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class kingdatabase {
    private static Connection connection;
    
    private static pelanggandao pelangganDao;
    
    public static Connection getConnection()throws SQLException{
        if(connection==null){
       
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/kingbarbarshop");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        return connection;
    }
    public static pelanggandao getPelangganDao()throws SQLException{
       if(pelangganDao==null){
         pelangganDao = new pelanggandaoimpl(getConnection());
       } 
       return pelangganDao;
    }
        
 
}
