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

    private DatabaseConnector dbc = new DatabaseConnector();
    // private DBConnector connector = null;

    public InvoiceMapper() throws Exception
    {
        DataSourceMysql dataSourceMysql = new DataSourceMysql();
        dbc.setDataSource(dataSourceMysql.getDataSource());
        //this.connector = new DBConnector();
    }
    
    public ShoppingCart getInvoice(int invoice_id) throws SQLException, Exception
    {
        UserMapper um = new UserMapper();
        ShoppingCart invoice = null;
        
        dbc.open();
        String query = "SELECT * FROM invoice"
                + " WHERE invoice_id = " + invoice_id + ";";

        int id = 0;
        int user_id = 0;
        List<LineItem> lineItems;
        User user = null;
        String date;

        PreparedStatement stmt = dbc.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.executeQuery();

        while (rs.next())
        {
            id = rs.getInt("invoice_id");
            user_id = rs.getInt("user_id");
            user = um.getUser(user_id);
            date = rs.getString("order_date");
            lineItems = getLineItems(id);

            invoice = new ShoppingCart(lineItems, user, id, date);
        }
        
        dbc.close();
        return invoice;
    }

    public List<ShoppingCart> getInvoices(String username) throws Exception
    {
        UserMapper um = new UserMapper();
        List<ShoppingCart> invoices = new ArrayList();

        dbc.open();
        String query = "SELECT invoice_id, total_price, order_date FROM Cupcakes.user join invoice on (user.user_id = invoice.user_id)"
                + " WHERE username = '" + username + "';";

        int invoice_id = 0;
        List<LineItem> lineItems;
        User user = um.getUser(username);
        String date;

        PreparedStatement stmt = dbc.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.executeQuery();

        while (rs.next())
        {
            invoice_id = rs.getInt("invoice_id");
            date = rs.getString("order_date");
            lineItems = getLineItems(invoice_id);

            ShoppingCart cart = new ShoppingCart(lineItems, user, invoice_id, date);
            invoices.add(cart);
        }
        
        dbc.close();
        System.out.println("hej");
        return invoices;
    }

    private List<LineItem> getLineItems(int invoice_id) throws Exception
    {
        CupcakeMapper cm = new CupcakeMapper();
        List<LineItem> lineitems = new ArrayList();

        dbc.open();
        String query = "SELECT * FROM invoice_has_items"
                + " WHERE invoice_id = " + invoice_id + ";";

        int id = 0;
        int topping_id = 0;
        int bottom_id = 0;
        int quantity = 0;

        PreparedStatement stmt = dbc.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.executeQuery();

        while (rs.next())
        {
            id = rs.getInt("invoice_id");
            topping_id = rs.getInt("topping_id");
            bottom_id = rs.getInt("bottom_id");
            quantity = rs.getInt("quantity");

            Topping topping = cm.getTopping(topping_id);
            Bottom bottom = cm.getBottom(bottom_id);
            Cupcake cupcake = new Cupcake(bottom, topping);

            LineItem i = new LineItem(cupcake, quantity, id);
            lineitems.add(i);

        }
        //dbc.close();
        return lineitems;
    }

    public void newInvoice(ShoppingCart cart) throws SQLException
    {
        dbc.open();

        String query = "INSERT INTO Cupcakes.invoice"
                + "(`invoice_id`, `user_id`, `total_price`)"
                + "VALUES (?,?,?);";

        int invoice_id = cart.getInvoice_id();
        int user_id = cart.getUser().getId();
        double totalprice = cart.getTotalPrice();

        PreparedStatement statement = dbc.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, invoice_id);
        statement.setInt(2, user_id);
        statement.setDouble(3, totalprice);
        statement.executeUpdate();
        
        for (LineItem i : cart.getLineItems())
        {
            addItem(i);
        }

        dbc.close();

    }

    private void addItem(LineItem i) throws SQLException
    {
        dbc.open();
        String query = "INSERT INTO Cupcakes.invoice_has_items"
                + "(`invoice_id`, `topping_id`, `bottom_id`, `quantity`, `price`)"
                + "VALUES (?,?,?,?,?);";

        PreparedStatement statement = dbc.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);

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

        dbc.close();
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
        //m.newInvoice(cart);

        //List<ShoppingCart> invoices = m.getInvoices(user.getUserName());
        //for (ShoppingCart invoice : invoices)
        //{
           // System.out.println(invoice);
        //}
        
        ShoppingCart invoice = m.getInvoice(cart.getInvoice_id());
        System.out.println(invoice);

    }
}
