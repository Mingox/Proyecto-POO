package com.cenfotec.entregable1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConection {
    public  Connection databaseLink;

    public Connection getConection(){
        String databaseName = "proyecto";
        String databaseUser = "root";
        String databasePassword = "esmeralda123";
        String url = "jdbc:mysql://localhost/"+databaseName;
         try {
             Class.forName("com.mysql.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
         }catch (Exception e){
            e.printStackTrace();
         }
         return databaseLink;
    }


}
