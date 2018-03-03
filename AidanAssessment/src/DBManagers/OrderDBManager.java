package DBManagers;


// <editor-fold defaultstate="collapsed" desc="Imports">
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import models.Customer;
import models.Order;
import models.OrderLine;
//</editor-fold>

//@author Aidan Marshall

public class OrderDBManager 
{
    // <editor-fold defaultstate="collapsed" desc="String: connString">
    private final String connString = "jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Documents\\Projects\\AidanAssessment\\AidanAssessment\\database\\ShopDB.accdb"; 
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: selectCustomerOrders">     
    protected HashMap<Integer, Order> selectCustomerOrders(String usernameIn)
    {
        HashMap<Integer, Order> allCustomerOrders = new HashMap<>();
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Orders WHERE Username = '"+ usernameIn +"'");
            OrderLineDBManager oldb = new OrderLineDBManager();
            
            while(rs.next())
            {
                
                String dateString = rs.getString("OrderDate");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                Date date = formatter.parse(dateString);
                
                Order selectedOrder = new Order(
                    rs.getInt("OrderId"),
                    date,
                    rs.getDouble("OrderTotal"),
                    rs.getString("Status"));

                allCustomerOrders.put(rs.getInt("OrderId"), selectedOrder);
                selectedOrder.setOrderLines(oldb.selectCustomerOrderLines(rs.getInt("OrderId")));
            }
            conn.close();
        }
        catch(Exception ex) { String message = ex.getMessage(); }
        finally { return allCustomerOrders; }
    }
    
    // </editor-fold> 
    //Inputs:   String usernameIn
    //Outputs:  HashMap<Integer, Order> allCustomerOrders
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: updateOrder">
    public void updateOrder(Order order)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            
            stmt.executeUpdate("UPDATE Orders SET OrderTotal = '" + order.getOrderTotal() + "', Status = '"+order.getStatus()+"'  WHERE OrderId= '" + order.getOrderId() + "'");
            //+ "' OrderDate = '" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
            conn.close();
            
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    //</editor-fold>
    //Inputs:   Order order
    //Outputs:  
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: insertOrder">   
    public int insertOrder(String customerId, Order newOrder)
    {
        int orderId = 0;
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO Orders (OrderDate, Username, OrderTotal, " +
                    "Status) VALUES ('" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(newOrder.getOrderDate()) +
                    "','" + customerId + "','" + newOrder.getOrderTotal() + "','" +
                    newOrder.getStatus() + "')");
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if(rs.next())
            {
                orderId = rs.getInt(1);
            }
            
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
        
        return orderId;
    }
    
    // </editor-fold> 
    //Inputs:   OrderLine newOrderLine, int orderId
    //Outputs:  
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: selectAllOrders">   
    public HashMap<Integer, Order> selectAllOrders()
    {
        HashMap<Integer, Order> orders = new HashMap<>();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Orders");
            
            while(rs.next())
            {
                
                String dateString = rs.getString("OrderDate");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                Date date = formatter.parse(dateString);
                //Creates an order
                Order loadedOrder = new Order(
                    rs.getInt("OrderId"),
                    date,
                    rs.getDouble("OrderTotal"),
                    rs.getString("Status"));
                orders.put(loadedOrder.getOrderId(), loadedOrder);
            }
        }
        catch(Exception ex)
        {
           String message = ex.getMessage();
        }
        finally
        {
           return orders; 
        }
    }
    // </editor-fold> 
    //Inputs:   
    //Outputs:  HashMap<Integer, Order> orders
    
}
 