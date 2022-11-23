package com.cenfotec.entregable1.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConection {
    public  Connection databaseLink;

    public Connection getConection(){
        String databaseName = "bgv9uf1md2cfkytodvqw";
        String databaseUser = "up173wgembmsauji";
        String databasePassword = "qTsWjPIFNDEPjYOfw5yx";
        String url = "jdbc:mysql://bgv9uf1md2cfkytodvqw-mysql.services.clever-cloud.com:3306/"+databaseName;
         try {
             Class.forName("com.mysql.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
         }catch (Exception e){
            e.printStackTrace();

         }
         return databaseLink;
    }


}
