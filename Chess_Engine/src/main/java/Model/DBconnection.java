/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;

/**
 *
 * This class responses for connecting ,execute query and return values from
 * Database
 */
public class DBconnection {

    static String url = "jdbc:sqlserver://localhost:1433;databaseName=Chess;encrypt=false";
    static String unameDB = "sa";
    static String passDB = "sa";

    private java.sql.Connection con;
    private Statement stm;
    private ResultSet resultSet;

    // constructor
    public DBconnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // laod the driver for sql
        } catch (ClassNotFoundException ex) {
        }
        try {
            con = DriverManager.getConnection(url, unameDB, passDB);
            stm = con.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // close after using DBconnection
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            stm.close();
            con.close();
        } catch (SQLException ex) {
        }

    }

    // verify if user exist in DB by username
    public boolean getUserVerify(String usr) {
        String query = "select * from Player where username = '" + usr + "'";
        try {
            resultSet = stm.executeQuery(query);
            return resultSet.next();

        } catch (SQLException ex) {
            return false;
        }
    }

    // the same on but with if usr exits password 
    public boolean getUserVerify(String usr, String pass) {
        String query = "select * from Player where username = '" + usr + "'";
        try {
            resultSet = stm.executeQuery(query);
            if (resultSet.next()) {
                return pass.equals(resultSet.getString("password"));
            } else {
                return false;
            }

        } catch (SQLException ex) {
            return false;
        }
    }

    // get user info except password
    public Player getUser(String usr) {
        String query = "select * from Player where username = '" + usr + "'";
        try {
            resultSet = stm.executeQuery(query);
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String sound = resultSet.getString("sound");
                int soundVl = resultSet.getInt("soundVl");
                String theme = resultSet.getString("theme");
                return new Player(username, sound, soundVl, theme);
            } else {
                return null;
            }

        } catch (SQLException ex) {
            return null;
        }
    }
    //update justf setting 

    public boolean updateUser(String username, String sound, int soundVl, String theme) {
        String query = "update Player "
                + "set sound='" + sound + "', soundVl = " + soundVl + ",theme ='" + theme + "' where username='" + username + "'";
        try {

            return !stm.execute(query);

        } catch (SQLException ex) {
            return false;
        }

    }

    // insert user 
    public boolean insertnewUser(String usr, String pass) {
        String query = "insert into Player values ('" + usr + "','" + pass + "','on',50,'fall')";
        try {
            return !stm.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
