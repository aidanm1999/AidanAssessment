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

public class OrderLineDBManager 
{
    // <editor-fold defaultstate="collapsed" desc="String: connString">
    private final String connString = "jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Documents\\Projects\\AidanAssessment\\AidanAssessment\\database\\ShopDB.accdb"; 
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: selectCustomerOrderLines">     
    public HashMap<Integer, OrderLine> selectCustomerOrderLines(int orderIdIn)
    {
        HashMap<Integer, OrderLine> orderLines = new HashMap<>();
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM OrderLines WHERE OrderId = '"+ orderIdIn +"'");
            ProductDBManager pdb = new ProductDBManager();
            
            while(rs.next())
            {
                OrderLine selectedOrderLine = new OrderLine(
                    rs.getInt("OrderLineId"),
                    pdb.selectProductFromOrderLine(rs.getInt("ProductId")),
                    rs.getInt("Quantity"),
                    rs.getDouble("LineTotal"));

                orderLines.put(rs.getInt("OrderLineId"), selectedOrderLine);
            }
            conn.close();
        }
        catch(Exception ex) { String message = ex.getMessage(); }
        finally { return orderLines; }
    }
    
    // </editor-fold> 
    //Inputs:   int orderId
    //Outputs:  HashMap<Integer, OrderLine> orderLines


    // <editor-fold defaultstate="collapsed" desc="Method: insertOrderLine">     
    public void insertOrderLine(OrderLine orderLine, int orderId)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO OrderLines (OrderLineId, ProductId, Quantity, " +
                    "LineTotal, OrderId) VALUES ('" + orderLine.getOrderLineId() +
                    "','" + orderLine.getProduct().getProductId() + "','" + orderLine.getQuantity() + "','" +
                    orderLine.getLineTotal() + "','"+orderId+"')");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    // </editor-fold> 
    //Inputs:   String usernameIn
    //Outputs:  HashMap<Integer, Order> allCustomerOrders
    

    // <editor-fold defaultstate="collapsed" desc="Method: updateOrderLine">
    public void updateOrderLine(OrderLine orderLine)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            
            stmt.executeUpdate("UPDATE OrderLines SET Quantity = '" + orderLine.getQuantity() + "', LineTotal = '"+orderLine.getLineTotal()+"'  WHERE OrderLineId= '" + orderLine.getOrderLineId() + "'");
            //+ "' OrderDate = '" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
            conn.close();
            
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    //</editor-fold>
    //Inputs:   OrderLine orderLine
    //Outputs:  
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: deleteOrderLine">   
    public void deleteOrderLine(int orderLineId)
    {
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE FROM OrderLines WHERE OrderLineId ='" + orderLineId + "'");
            
            
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    // </editor-fold> 
    //Inputs:   int orderLineId
    //Outputs:  
    
}
 