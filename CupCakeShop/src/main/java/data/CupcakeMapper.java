/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.Bottom;
import logic.Topping;

/**
 *
 * @author sofieamalielandt
 */
public class CupcakeMapper
{
    private DatabaseConnector dbc = new DatabaseConnector();
    // private DBConnector connector = null;

    public CupcakeMapper() throws Exception
    {
        DataSourceMysql dataSourceMysql = new DataSourceMysql();
        dbc.setDataSource(dataSourceMysql.getDataSource());
        //this.connector = new DBConnector();
    }
    
    public List<Bottom> getAllBottoms()throws Exception{
        
        List<Bottom> bottoms = new ArrayList();
        dbc.open();
        String query = "SELECT * FROM cupcake_Bottoms";
        
        int bottom_id = 0;
        String flavour = "";
        double price = 0.0;
        
        PreparedStatement stmt = dbc.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            bottom_id = rs.getInt("bottom_id");
            flavour = rs.getString("bottom_flavour");
            price = rs.getDouble("bottom_price");
            
            Bottom bottom = new Bottom(bottom_id,flavour, price);
            bottoms.add(bottom);
            
        }
        dbc.close();
        return bottoms;
    }
    
     public List<Topping> getAllToppings()throws Exception{
        
        List<Topping> toppings = new ArrayList();
        dbc.open();
        String query = "SELECT * FROM cupcake_Toppings";
        
        int topping_id = 0;
        String flavour = "";
        double price = 0.0;
        
        PreparedStatement stmt = dbc.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            topping_id = rs.getInt("topping_id");
            flavour = rs.getString("topping_flavour");
            price = rs.getDouble("topping_price");
            
            Topping topping = new Topping(topping_id,flavour, price);
            toppings.add(topping);
            
        }
        dbc.close();
        return toppings;
    }
}
