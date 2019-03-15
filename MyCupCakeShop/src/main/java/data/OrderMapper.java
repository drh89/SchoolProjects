/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import logic.Order;
import logic.OrderLine;
import logic.ShoppingCart;
import logic.User;

/**
 *
 * @author Dennis
 */
public class OrderMapper {

    private DBConnector dbc;
    private CupcakeMapper cm;

    /**
     *
     * @throws Exception
     */
    public OrderMapper() throws Exception {
        dbc = new DBConnector();
        cm = new CupcakeMapper();
    }

    /**
     *
     * @param order
     * @return Order with the matching id of parameter (order)
     * @throws SQLException
     */
    public Order getOrder(Order order) throws SQLException {
        Order result = null;
        int orderId = order.getId();

        String query = "SELECT * FROM Orders WHERE id = '" + orderId + "';";

        PreparedStatement stmt = dbc.getConnection().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            int id = rs.getInt("id");
            int userId = rs.getInt("userId");
            Timestamp dateAndTime = rs.getTimestamp("orderDate");

            result = new Order(id, userId, dateAndTime);

        }

        return result;

    }

    /**
     *
     * @return List of Orders from DB
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Order> getAllOrders() throws SQLException, ClassNotFoundException {

        List<Order> orders = new ArrayList();
        Order order = null;

        String query = "SELECT * FROM Orders;";

        PreparedStatement stmt = dbc.preparedStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            int id = rs.getInt("id");
            int userId = rs.getInt("userId");
            Timestamp dateAndTime = rs.getTimestamp("orderDate");

            order = new Order(id, userId, dateAndTime);
            orders.add(order);
        }

        return orders;

    }
   
    /**
     *
     * @return List of OrderLines from DB
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<OrderLine> getAllOrderLines() throws SQLException, ClassNotFoundException {
        List<OrderLine> orderLines = new ArrayList();
        OrderLine orderLine = null;

        String query = "SELECT * FROM GetOrderLines;";

        PreparedStatement stmt = dbc.preparedStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            String bottomName = rs.getString("bottomName");
            String toppingName = rs.getString("toppingName");
            int amount = rs.getInt("amount");
            double price = rs.getDouble("price");
            int userId = rs.getInt("userId");
            int _orderId = rs.getInt("orderId");
            
            Timestamp temp =rs.getTimestamp("orderDate");
            String orderDate = temp.toString();
                    
            orderLine = new OrderLine(bottomName, toppingName, amount, price, userId, _orderId, orderDate);
            orderLines.add(orderLine);

        }

        return orderLines;

    }

    /**
     *
     * @param order
     * @return List of OrderLines that matches the id of parameter ( order )
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<OrderLine> getOrderLinesByOrderId(Order order) throws SQLException, ClassNotFoundException {

        List<OrderLine> orderLines = new ArrayList();
        OrderLine orderLine = null;
        int orderId = order.getId();

        String query = "SELECT * FROM GetOrderLines WHERE orderId = (?);";

        PreparedStatement stmt = dbc.preparedStatement(query);
        stmt.setInt(1, orderId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            String bottomName = rs.getString("bottomName");
            String toppingName = rs.getString("toppingName");
            int amount = rs.getInt("amount");
            double price = rs.getDouble("price");
            int userId = rs.getInt("userId");
            int _orderId = rs.getInt("orderId");
            Timestamp temp = rs.getTimestamp("orderDate");
            String orderDate = temp.toString();

            orderLine = new OrderLine(bottomName, toppingName, amount, price, userId, _orderId, orderDate);
            orderLines.add(orderLine);

        }

        return orderLines;

    }

    /**
     *
     * @param order
     * @param cart
     * @throws SQLException
     * @throws ClassNotFoundException
     * 
     * Writes the Order to the DB and writes the OrderLines from the ShoppingCart to the DB .
     * 
     */
    public void createOrder(Order order, ShoppingCart cart) throws SQLException, ClassNotFoundException {

        int userId = order.getUserId();

        String query = "INSERT INTO Orders(userId) VALUES(?);";

        PreparedStatement stmt = dbc.prepareKeys(query, Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, userId);

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();

        while (rs.next()) {
            int orderId = rs.getInt(1);

            for (OrderLine orderLine : cart.getOrderlines()) {

                PreparedStatement ols = dbc.preparedStatement("INSERT INTO OrderLines (amount, price, orderId, bottomId, toppingId)VALUES(?,?,?,?,?);");
                int amount = orderLine.getAmount();
                double price = cm.getBottomPrice(orderLine.getBottomId()) + cm.getToppingPrice(orderLine.getToppingId());
                int bottomId = orderLine.getBottomId();
                int toppingId = orderLine.getToppingId();

                ols.setInt(1, amount);
                ols.setDouble(2, price);
                ols.setInt(3, orderId);
                ols.setInt(4, bottomId);
                ols.setInt(5, toppingId);

                ols.executeUpdate();
                
            }
            

        }
        removeUnfinishedOrderLineByUserId(userId);
    }

    /**
     *
     * @param cart
     * @param user
     * @return List of OrderLines that matches the parameter (user)'s id. 
     * @throws SQLException
     * @throws Exception
     * 
  
     */
    public List<OrderLine> getUnfinishedOrderLines(ShoppingCart cart, User user) throws SQLException, Exception {
        List<OrderLine> result = cart.getOrderlines();
        OrderLine orderLine = null;
        int userId = user.getUserId();

        String query = "SELECT * FROM UnfinishedOrders WHERE userId = (?);";

        PreparedStatement stmt = dbc.preparedStatement(query);
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            int amount = rs.getInt("amount");
            double price = rs.getDouble("price");
            int bottomId = rs.getInt("bottomId");
            int toppingId = rs.getInt("toppingId");

            orderLine = new OrderLine(id, amount, price, bottomId, toppingId);
            result.add(orderLine);
        }

        return result;

    }

    /**
     *
     * @param orderLine
     * @param user
     * @throws ClassNotFoundException
     * @throws SQLException
     * 
     * Writes the OrderLines from the ShoppingCart to the DB.
     */
    public void writeUnfinishedOrderLine(OrderLine orderLine, User user) throws ClassNotFoundException, SQLException {

        String query = "INSERT INTO UnfinishedOrders(amount, price, bottomId, toppingId, userId)"
                + "VALUES(?,?,?,?,?);";
        int amount = orderLine.getAmount();
        double price = orderLine.getPrice();
        int bottomId = orderLine.getBottomId();
        int toppingId = orderLine.getToppingId();
        int userId = user.getUserId();

        PreparedStatement stmt = dbc.preparedStatement(query);

        stmt.setInt(1, amount);
        stmt.setDouble(2, price);
        stmt.setInt(3, bottomId);
        stmt.setInt(4, toppingId);
        stmt.setInt(5, userId);

        stmt.executeUpdate();

    }

    /**
     *
     * @param id
     * @throws ClassNotFoundException
     * @throws SQLException
     * Removes OrderLine from ShoppingCart where the OrderLines id matches the parameter (id)
     */
    public void removeUnfinishedOrderLine(int id) throws ClassNotFoundException, SQLException {

        String query = "DELETE FROM UnfinishedOrders WHERE id = (?);";
        PreparedStatement stmt = dbc.preparedStatement(query);

        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    /**
     *
     * @param userId
     * @throws ClassNotFoundException
     * @throws SQLException
     * 
     * Removes OrderLine from users ShoppingCart 
     */
    public void removeUnfinishedOrderLineByUserId(int userId) throws ClassNotFoundException, SQLException {
        
        String query = "DELETE FROM UnfinishedOrders WHERE userId = (?);";
        PreparedStatement stmt = dbc.preparedStatement(query);

        stmt.setInt(1, userId);
        stmt.executeUpdate();
    }

    public static void main(String[] args) throws Exception {
        OrderMapper om = new OrderMapper();
        Order order = new Order(2);

        System.out.println(om.getAllOrderLines().toString());

    }

}
