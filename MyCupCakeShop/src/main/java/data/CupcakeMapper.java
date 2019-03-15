/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.Bottom;
import logic.Cupcake;
import logic.Topping;

/**
 *
 * @author Dennis
 */
public class CupcakeMapper {

    private DBConnector dbc;

    /**
     *
     * @throws Exception
     */
    public CupcakeMapper() throws Exception {
        dbc = new DBConnector();
    }

    /**
     *
     * @return List of Bottoms from DB
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Bottom> getAllBottoms() throws SQLException, ClassNotFoundException {
        List<Bottom> bottoms = new ArrayList();
        Bottom temp = null;

        String query = "SELECT * FROM Bottoms;";

        PreparedStatement stmt = dbc.preparedStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            int id = rs.getInt("id");
            String flavour = rs.getString("flavour");
            double price = rs.getDouble("price");

            temp = new Bottom(id, flavour, price);
            bottoms.add(temp);

        }
        return bottoms;

    }

    /**
     *
     * @return List of Toppings from DB
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Topping> getAllToppings() throws SQLException, ClassNotFoundException {
        List<Topping> toppings = new ArrayList();
        Topping temp = null;

        String query = "SELECT * FROM Toppings;";

        PreparedStatement stmt = dbc.preparedStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String flavour = rs.getString("flavour");
            double price = rs.getDouble("price");

            temp = new Topping(id, flavour, price);
            toppings.add(temp);

        }

        return toppings;
    }

    /**
     *
     * @return List of Cupcakes
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<Cupcake> getAllCupcakes() throws SQLException, ClassNotFoundException {
        List<Cupcake> cupcakes = new ArrayList();
        List<Topping> toppings = getAllToppings();
        List<Bottom> bottoms = getAllBottoms();
        Cupcake cupcake = null;

        for (Bottom bottom : bottoms) {

            for (Topping topping : toppings) {

                int id = 1;

                cupcake = new Cupcake(id, bottom, topping, bottom.getPrice() + topping.getPrice());
                id++;
                cupcakes.add(cupcake);
            }

        }

        return cupcakes;

    }

    /**
     *
     * @param bottomId
     * @return price on Bottom that matches bottomId
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public double getBottomPrice(int bottomId) throws ClassNotFoundException, SQLException {
        String query = "SELECT price FROM Bottoms WHERE id = '" + bottomId + "';";
        double result = 0;

        PreparedStatement stmt = dbc.preparedStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            result = rs.getDouble("price");

        }

        return result;

    }

    /**
     *
     * @param toppingId
     * @return price on Topping that matches toppingId 
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public double getToppingPrice(int toppingId) throws ClassNotFoundException, SQLException {
        String query = "SELECT price FROM Toppings WHERE id = '" + toppingId + "';";
        double result = 0;

        PreparedStatement stmt = dbc.preparedStatement(query);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            result = rs.getDouble("price");

        }

        return result;

    }

    /**
     *
     * @param bottomId
     * @return Bottom that matches bottomId
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Bottom getBottom(int bottomId) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM Bottoms WHERE id = '" + bottomId + "';";
        Bottom result = null;

        PreparedStatement stmt = dbc.preparedStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            
            int id = rs.getInt("id");
            String flavour = rs.getString("flavour");
            double price = rs.getDouble("price");
            result = new Bottom(id, flavour, price);
        }
        return result;
    }

    /**
     *
     * @param toppingId
     * @return Topping that matches toppingId
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Topping getTopping(int toppingId) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM Toppings WHERE id = '" + toppingId + "';";
        Topping result = null;

        PreparedStatement stmt = dbc.preparedStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            
            int id = rs.getInt("id");
            String flavour = rs.getString("flavour");
            double price = rs.getDouble("price");
            result = new Topping(id, flavour, price);
        }
        return result;
    }
    public static void main(String[] args) throws Exception {
        CupcakeMapper cm = new CupcakeMapper();
        System.out.println(cm.getTopping(1).getId());
        System.out.println(cm.getBottom(1).getId());
    }   
}
