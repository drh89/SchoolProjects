/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Dennis
 */
public class DBConnector {
    
     private  Connection connection = null;
  

    //Constants
//    private static final String IP = "142.93.160.41";
//    private static final String PORT = "3306";
//    public static final String DATABASE = "MyCupCakes";
//    private static final String USERNAME = "Dennis";
//    private static final String PASSWORD = "12345";

    /* public DBConnector() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
        
        this.connection = (Connection) DriverManager.getConnection(url, USERNAME, PASSWORD);
    }*/
//    public DBConnector() throws Exception
//    {
//        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//        String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;
//        Properties props = new Properties();
//        props.put("user", USERNAME);
//        props.put("password", PASSWORD);
//        props.put("allowMultiQueries", true);
//        props.put("useUnicode", true);
//        props.put("useJDBCCompliantTimezoneShift", true);
//        props.put("useLegacyDatetimeCode", false);
//        props.put("serverTimezone", "CET");
//        this.connection = DriverManager.getConnection(url, props);
//    }

//    public static Connection getConnection()
//    {
//        return this.connection;
//    }
    
     
     
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://142.93.160.41:3306/MyCupCakes";
    private static String user = "Dennis";
    private static String password = "12345";
    
    private static PreparedStatement stmt;
    private static Connection conn = null;
    
    /**
     *
     * @return
     */
    public static Connection getConnection()
    {
        if (conn == null)
        {
            try
            {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
            }
            catch (ClassNotFoundException | SQLException ex)
            {
            }
        }
        
        return conn;
    }

    /**
     *
     * @param SQLString
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static PreparedStatement preparedStatement(String SQLString) throws ClassNotFoundException, SQLException {
          stmt = DBConnector.getConnection().prepareStatement(SQLString, 0);
          return stmt;
      }

    /**
     *
     * @param SQLString
     * @param i
     * @return 
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static PreparedStatement prepareKeys(String SQLString, int i) throws ClassNotFoundException, SQLException {
          stmt = DBConnector.getConnection().prepareStatement(SQLString, 1);
          return stmt;
      }
}
