/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rania
 */
public class DatabaseHandler {
    private static DatabaseHandler databaseHandler;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement pres;
   
    public DatabaseHandler() throws ClassNotFoundException {
        connect();
       
    }
    public static DatabaseHandler getInstance() throws ClassNotFoundException{
        if(databaseHandler==null)
            databaseHandler=new DatabaseHandler();
        
        return databaseHandler;
    }
    private void connect() throws ClassNotFoundException{
        try {
            //DriverManager.registerDriver(new OracleDriver());
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe","root","root");
            System.out.println("connection succeeded");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void insert(String query){
//        try {
//            pres = connection.prepareStatement(query);
//            pres.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
//        }
          System.out.println("query"+query);
    }
    public void update(String query){
        try {
            pres = connection.prepareStatement(query);
            pres.executeUpdate();
            //statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void delete(String query){
        try {
            pres = connection.prepareStatement(query);
            pres.executeUpdate();
            //statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet select(String query){
        
        try {
           // pres = connection.prepareStatement(query);
         statement=connection.createStatement();
         String queryString = new String(query);
         resultSet =  statement.executeQuery(queryString) ;
         System.out.println("query"+query);
           // resultSet = pres.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }
    /*public void closeConnection(){
        try {
            connection.close();
            databaseHandler=null;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
}
