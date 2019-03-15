/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.CupcakeMapper;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dennis
 */
public class CupcakeMapperFacade {
    
    private CupcakeMapper cm;
    
    /**
     *
     * @throws Exception
     */
    public CupcakeMapperFacade() throws Exception{
        cm = new CupcakeMapper();
    }
    
    /**
     *
     * @return List of Bottoms
     * @throws SQLException
     * @throws ClassNotFoundException
     * 
     * 
     * 
     */
    public List<Bottom> getAllBottoms() throws SQLException, ClassNotFoundException{
        List<Bottom> bottoms = cm.getAllBottoms();
        
        return bottoms;
    }
    
    /**
     *
     * @return List of Toppings
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Topping> getAllToppings() throws SQLException, ClassNotFoundException{
        List<Topping> toppings = cm.getAllToppings();
        
        return toppings;
    }
    
    /**
     *
     * @param bottomId
     * @return price on Bottom that matches bottomId
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public double getBottomPrice(int bottomId) throws ClassNotFoundException, SQLException{
        double result = cm.getBottomPrice(bottomId);
        return result;
        
    }

    /**
     *
     * @param toppingId
     * @return price on Topping that matches toppingId 
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public double getToppingPrice(int toppingId) throws ClassNotFoundException, SQLException{
        double result = cm.getToppingPrice(toppingId);
        return result;
    }

    /**
     *
     * @param bottomId
     * @return Bottom that matches bottomId
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Bottom getBottom(int bottomId) throws ClassNotFoundException, SQLException{
        Bottom bottom = cm.getBottom(bottomId);
        
        return bottom;
    }

    /**
     *
     * @param toppingId
     * @return Topping that matches toppingId
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Topping getTopping(int toppingId) throws ClassNotFoundException, SQLException{
        Topping topping = cm.getTopping(toppingId);
        return topping;
    }
    
}
