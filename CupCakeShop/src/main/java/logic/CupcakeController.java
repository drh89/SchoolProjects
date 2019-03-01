/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.CupcakeMapper;
import java.util.List;

/**
 *
 * @author aamandajuhl
 */
public class CupcakeController
{
    CupcakeMapper cm = null;

    public CupcakeController() throws Exception
    {
        cm = new CupcakeMapper();
    }
    
    public List<Bottom> getCupcakeBottoms() throws Exception
    {
        return cm.getAllBottoms();
    }
    
    public List<Topping> getCupcakeToppings() throws Exception 
    {
        return cm.getAllToppings();
    }

}
