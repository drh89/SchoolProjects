/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.OrderMapper;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Dennis
 */
public class OrderMapperFacade {
    
    private OrderMapper om;

    /**
     *
     * @throws Exception
     */
    public OrderMapperFacade() throws Exception {
        om = new OrderMapper();
    }
    
    /**
     *
     * @param order
     * @return Order with the matching id of order
     * @throws SQLException
     */
    public Order getOrder(Order order) throws SQLException{
        Order result = om.getOrder(order);
        
        return result;
    }
    
    /**
     *
     * @return List of Orders from DB
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Order> getAllOrders() throws SQLException, ClassNotFoundException{
        List <Order> orders = om.getAllOrders();
        return orders;
    }
    
    /**
     *
     * @return List of OrderLines from DB
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<OrderLine> getAllOrderLines() throws SQLException, ClassNotFoundException{
        List<OrderLine> orderLines = om.getAllOrderLines();
        return orderLines;
    }
    
    /**
     *
     * @param order
     * @return List of OrderLines that matches the id of order
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<OrderLine> getOrderLinesByOrderId(Order order) throws SQLException, ClassNotFoundException{
        List<OrderLine> orderLines = om.getOrderLinesByOrderId(order);
        return orderLines;
    }
    
    /**
     *
     * @param order
     * @param cart
     * @throws SQLException
     * @throws ClassNotFoundException
     * 
     *  Writes the Order to the DB and writes the OrderLines from the ShoppingCart to the DB .
     * 
     */
    public void createOrder(Order order, ShoppingCart cart) throws SQLException, ClassNotFoundException{
        om.createOrder(order, cart);
    }
    
    /**
     *
     * @param cart
     * @param user
     * @return List of OrderLines that matches the userId
     * @throws Exception
     */
    public List<OrderLine> getUnfinishedOrderLines(ShoppingCart cart, User user) throws Exception{
        List<OrderLine> orderLines = om.getUnfinishedOrderLines(cart, user);
        return orderLines;
    }
    
    /**
     *
     * @param orderLine
     * @param user
     * @throws ClassNotFoundException
     * @throws SQLException
     * 
     * Writes the OrderLines from the ShoppingCart to the DB.
     * 
     */
    public void writeUnfinishedOrderLine(OrderLine orderLine, User user) throws ClassNotFoundException, SQLException{
        om.writeUnfinishedOrderLine(orderLine, user);
    }

    /**
     *
     * @param id
     * @throws ClassNotFoundException
     * @throws SQLException
     * 
     * Removes OrderLine from ShoppingCart
     * 
     */
    
    
    
    public void removeUnfinishedOrderLine(int id) throws ClassNotFoundException, SQLException{
        om.removeUnfinishedOrderLine(id);
    }
}
