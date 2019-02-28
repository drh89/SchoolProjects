/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private DBConnector connector = null;

    public CupcakeMapper() throws Exception
    {
        this.connector = new DBConnector();
    }
    
    public List<Bottom> getAllBottoms()throws Exception{
        
        List<Bottom> bottoms = new ArrayList();

        String query = "SELECT * FROM cupcake_Bottoms";
        
        String flavour = "";
        double price = 0.0;
        
        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            flavour = rs.getString("bottom_flavour");
            price = rs.getDouble("bottom_price");
            
            Bottom bottom = new Bottom(flavour, price);
            bottoms.add(bottom);
            
        }
        return bottoms;
    }
    
     public List<Topping> getAllToppings()throws Exception{
        
        List<Topping> toppings = new ArrayList();

        String query = "SELECT * FROM cupcake_Toppings";
        
        String flavour = "";
        double price = 0.0;
        
        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            flavour = rs.getString("topping_flavour");
            price = rs.getDouble("topping_price");
            
            Topping topping = new Topping(flavour, price);
            toppings.add(topping);
            
        }
        return toppings;
    }
}
