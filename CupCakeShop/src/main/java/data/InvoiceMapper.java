/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.Bottom;
import logic.Cupcake;
import logic.LineItem;
import logic.ShoppingCart;
import logic.Topping;
import logic.User;

/**
 *
 * @author sofieamalielandt
 */
public class InvoiceMapper
{

    private DBConnector connector = null;

    public InvoiceMapper() throws Exception
    {
        this.connector = new DBConnector();
    }

    public void newInvoice(ShoppingCart cart) throws SQLException
    {
        String query = "INSERT INTO Cupcakes.invoice"
                + "(`invoice_id`, `user_id`, `total_price`)"
                + "VALUES (?,?,?);";

        int invoice_id = cart.getInvoice_id();
        int user_id = cart.getUser().getId();
        double totalprice = cart.getTotalPrice();

        PreparedStatement statement = connector.getConnection().prepareStatement(query);

        statement.setInt(1, invoice_id);
        statement.setInt(2, user_id);
        statement.setDouble(3, totalprice);
        statement.executeUpdate();

        for (LineItem i : cart.getLineItems())
        {
            addItem(i);
        }

    }

    private void addItem(LineItem i) throws SQLException
    {
        String query = "INSERT INTO Cupcakes.invoice_has_items"
                + "(`invoice_id`, `topping_id`, `bottom_id`, `quantity`, `price`)"
                + "VALUES (?,?,?,?,?);";

        PreparedStatement statement = connector.getConnection().prepareStatement(query);

        int invoice = i.getInvoice_id();
        System.out.println(invoice);
        int topping_id = i.getCupcake().getTopping().getTopping_id();
        int bottom_id = i.getCupcake().getBottom().getBottom_id();
        int quantity = i.getQuantity();
        double price = i.getPrice();

        statement.setInt(1, invoice);
        statement.setInt(2, topping_id);
        statement.setInt(3, bottom_id);
        statement.setInt(4, quantity);
        statement.setDouble(5, price);
        statement.executeUpdate();
    }

    public static void main(String[] args) throws Exception
    {
        UserMapper um = new UserMapper();
        CupcakeMapper cm = new CupcakeMapper();

        User user = um.getUser("amalie");

        List<LineItem> list = new ArrayList<>();

        ShoppingCart cart = new ShoppingCart(list, user);

        List<Bottom> bottoms = cm.getAllBottoms();
        List<Topping> toppings = cm.getAllToppings();
        Cupcake cupcake = new Cupcake(bottoms.get(0), toppings.get(0));
        Cupcake cupcake2 = new Cupcake(bottoms.get(2), toppings.get(3));

        LineItem i = new LineItem(cupcake, 2, cart.getInvoice_id());
        LineItem i2 = new LineItem(cupcake2, 1, cart.getInvoice_id());
        
        cart.addCupcake(i);
        cart.addCupcake(i2);

        InvoiceMapper m = new InvoiceMapper();
        m.newInvoice(cart);
    }
}
