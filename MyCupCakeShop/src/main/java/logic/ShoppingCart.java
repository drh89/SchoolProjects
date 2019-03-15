/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dennis
 */
public class ShoppingCart {
    
    private List<OrderLine> orderlines;
    
    /**
     *
     */
    public ShoppingCart(){
        orderlines = new ArrayList();
    }

    /**
     * @return the orderlines
     */
    public List<OrderLine> getOrderlines() {
        return orderlines;
    }

    /**
     * @param orderlines the orderlines to set
     */
    public void setOrderlines(List<OrderLine> orderlines) {
        this.orderlines = orderlines;
    }
    
}
