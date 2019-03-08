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
public class CupcakeConnector
{

    CupcakeMapper cm = null;

    public CupcakeConnector() throws Exception
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

    public Cupcake getCupCake(String bottom, String topping) throws Exception
    {
        if (bottom == null || topping == null || bottom.equals("Choose bottom") || topping.equals("Choose topping")) return null;
        
        String[] bottomsplit = bottom.split(" ");
        bottom = bottomsplit[0];

        String[] toppingsplit = topping.split(" ");
        if (toppingsplit.length != 4)
        {
            topping = toppingsplit[0];

        } else
        {
            topping = toppingsplit[0] + " " + toppingsplit[1];
        }

        Bottom bResult = null;
        Topping tResult = null;

        List<Bottom> bottoms = getCupcakeBottoms();
        List<Topping> toppings = getCupcakeToppings();

        for (Bottom b : bottoms)
        {
            if (b.getFlavour().equals(bottom))
            {
                bResult = b;
            }
        }

        for (Topping t : toppings)
        {
            if (t.getFlavour().equals(topping))
            {
                tResult = t;
            }
        }
     
        Cupcake cupcake = new Cupcake(bResult, tResult);

        return cupcake;

    }

}