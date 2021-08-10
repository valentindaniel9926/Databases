package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        //Will be automatically closed
        /*try(Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\Java projects\\Databases\\DB\\testjava.db");
            Statement statement =  conn.createStatement()){
            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");*/

        //Manually closed
        try{
                Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\Java projects\\Databases\\JDBC Insert,Update,Delete\\testjava.db");
                //conn.setAutoCommit(false);
                Statement statement =  conn.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS contacts" +
                        "(name TEXT, phone INTEGER, email TEXT)");
            /*statement.execute("INSERT INTO contacts (name, phone, email) " +
//                              "VALUES('VALENTIN', 0764234965, 'valentin@gmail.com')");
//           statement.execute("INSERT INTO contacts(name, phone, email)" +
//                    "VALUES('Eliza' , 0765218427 , 'elizamarina@gmail.com')");*/
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Jon Snow', 3452345 , 'jonsnow67@somewhere.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Joe', 45623, 'jow@anywhere.com')");
            /*statement.execute("UPDATE contacts SET phone=231123 WHERE name='Joe'");
            statement.execute("DELETE FROM contacts WHERE name='Joe'");*/
            //statement.execute("DELETE FROM contacts WHERE email='valentin@gmail.com'");
            statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();
            while (results.next()){
                System.out.println(results.getString("name") + " " +
                        results.getInt("phone") + " " +
                        results.getString("email"));
            }
            results.close();
                statement.close();
                conn.close();
            //Connection to database
            //Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\Java projects\\Databases\\DB\\testjava.db");
        }catch (SQLException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
