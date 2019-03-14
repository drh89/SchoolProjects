/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author aamandajuhl
 */
public class DataSourceMysql
{

    private MysqlDataSource dataSource = new MysqlDataSource();

    /**
     * Initializes the information for connection to database.
     * 
     */
    public DataSourceMysql()
    {
        try
        {
            dataSource.setServerName("142.93.160.41");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("Cupcakes");
            dataSource.setUser("Dennis");
            dataSource.setPassword("12345");
            dataSource.setUseSSL(false);
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * @return a dataSource with the specified information for connection.
     */
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }

}
