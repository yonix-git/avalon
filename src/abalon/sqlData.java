package abalon;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class sqlData {
        
    
    public sqlData()  {
try {
            //Create Connection
            //String connectionUrl = "jdbc:sqlserver://localhost:1433;"
            //       + "databaseName=avalonData;";
            String DB_URL = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=avalonData;"
                    + "integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(DB_URL);
            
            System.out.println("yaaaaa");
           
            // declare of statement and resultSet
            Statement statement;
            ResultSet rs;
            
            // the statement to be execute
            String query = "select * from players";
            
            statement = conn.createStatement();
            
            // execute and get the result set.
            rs = statement.executeQuery(query);
            
            // run over the resultSet
            while(rs.next()){
                
                System.out.print(rs.getInt("ID")+" ");
                System.out.print(rs.getString("name")+ " ");
                System.out.print(rs.getString("nickName")+" ");
                System.out.println("");
            }
            
            // close the resorces
            rs.close();
            statement.close();
            conn.close();
            
//Create Statment

//Execute
        } catch (SQLException ex) {
            System.out.println("cant connect!_1");
            Logger.getLogger(sqlData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("cant connect!_2");
            Logger.getLogger(sqlData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
