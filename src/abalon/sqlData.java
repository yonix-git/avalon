package abalon;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

    Connection conn;

    public sqlData() {
        try {
            //Create Connection
            //String connectionUrl = "jdbc:sqlserver://localhost:1433;"
            //       + "databaseName=avalonData;";
            String DB_URL = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=avalonData;"
                    + "integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL);

            /*System.out.println("yaaaaa");
            
            // declare of statement and resultSet
            Statement statement;
            ResultSet rs;
            
            // the statement to be execute
            String query = "select * from players";
            
            statement = conn.createStatement();
            
            // execute and get the result set.
            rs = statement.executeQuery(query);
            
            // run over the resultSet
            while (rs.next()) {
            
            System.out.print(rs.getInt("ID") + " ");
            System.out.print(rs.getString("name") + " ");
            System.out.print(rs.getString("nickName") + " ");
            System.out.println("");
            }
            
            //getLastGame("1", 0);
            // close the resorces
            rs.close();
            statement.close();*/
        } catch (SQLException ex) {
            System.out.println("cant connect!_1");
            Logger.getLogger(sqlData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("cant connect!_2");
            Logger.getLogger(sqlData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean chackNameAndPass(String name, String password) throws SQLException {

        String query = "declare @res int exec @res = getNameAndPassword ?, ?"
                + " select @res as res";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        if (rs.next() && rs.getInt("res") == 1) {
            return true;
        } else {
            return false;
        }

    }

    public boolean newPlayer(String name, String nickName, String password, String email) throws SQLException {
        String query = "declare @res int exec @res = setNewPlayer ?, ?, ?, ?"
                + " select @res as res";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, nickName);
        ps.setString(3, password);
        ps.setString(4, email);
        ResultSet rs = ps.executeQuery();

        if (rs.next() && rs.getInt("res") == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int setNewGame(String name1, String name2) throws SQLException {
        String query = "declare @res int exec @res = setNewGame ?, ?"
                + " select @res as res";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name1);
        ps.setString(2, name2);
        ResultSet rs = ps.executeQuery();

        rs.next();
        return rs.getInt("res");
    }

    public ArrayList getLastGames(String S, int num) throws SQLException {
        String query = "select * from getlastgame(?, ?)";
        String str = "";
        ArrayList<String> A = new ArrayList<>();

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, S);
        ps.setString(2, "" + num);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            str += rs.getString("name1");
            str += "   ";
            str += rs.getString("name2");
            str += "   ";
            str += rs.getString("date");
            str += "   ";
            str += rs.getString("time");

            A.add(str);
            str = "";
        }
        return A;
    }

    public void setWinner(String name, int IDgame) throws SQLException{
        String query = "declare @res int exec @res = setWinner ?, ?"
                + " select @res as res";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, IDgame);
        ResultSet rs = ps.executeQuery();

        rs.next();
        System.out.println(rs.getInt("res"));
    }
}
