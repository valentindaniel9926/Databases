package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        //Will be automatically closed
        /*try(Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\Java projects\\Databases\\DB\\testjava.db");
            Statement statement =  conn.createStatement()){
            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");*/

        //Manually closed
        try{
                Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\Java projects\\Databases\\DB\\testjava.db");
                Statement statement =  conn.createStatement();
                statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");
                statement.close();
                conn.close();
            //Connection to database
            //Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\Java projects\\Databases\\DB\\testjava.db");
        }catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
