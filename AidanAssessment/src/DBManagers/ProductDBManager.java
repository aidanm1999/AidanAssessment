package DBManagers;


// <editor-fold defaultstate="collapsed" desc="Imports">
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import models.Clothing;
import models.Footwear;
import models.Order;
import models.OrderLine;
import models.Product;
//</editor-fold>

//@author Aidan Marshall

public class ProductDBManager 
{
    // <editor-fold defaultstate="collapsed" desc="Connection String: connString">
    private final String connString = "jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Documents\\Projects\\AidanAssessment\\AidanAssessment\\database\\ShopDB.accdb"; 
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: selectProductFromOrderLine">     
    protected Product selectProductFromOrderLine(int productIdIn)
    {
        Product selectedProduct = new Product();
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products WHERE ProductId = '"+ productIdIn +"'");
            ProductDBManager pdb = new ProductDBManager();
            
            if(rs.next())
            {
                selectedProduct = new Product(
                    rs.getInt("ProductId"),
                    rs.getString("ProductName"),
                    rs.getDouble("Price"),
                    rs.getInt("StockLevel"));

            }
            conn.close();
        }
        catch(Exception ex) { String message = ex.getMessage(); }
        finally { return selectedProduct; }
    }
    
    // </editor-fold> 
    //Inputs:   String productIdIn
    //Outputs:  Product selectedProduct
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: selectAllProducts">     
    public HashMap<Integer, Product> selectAllProducts()
    {
        HashMap<Integer, Product> products = new HashMap<>();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
            
            while(rs.next())
            {
                if(rs.getString("Measurement") != null && rs.getString("Measurement") != "")
                {
                    Clothing loadedClothing = new Clothing(
                        rs.getInt("ProductId"), 
                        rs.getString("ProductName"), 
                        rs.getInt("Price"), 
                        rs.getInt("StockLevel"), 
                        rs.getString("Measurement"));
                    
                    products.put(rs.getInt("ProductId"), loadedClothing);
                }
                else
                {
                    Footwear loadedFootwear = new Footwear(
                        rs.getInt("ProductId"), 
                        rs.getString("ProductName"), 
                        rs.getInt("Price"), 
                        rs.getInt("StockLevel"), 
                        rs.getInt("Size"));
                    products.put(rs.getInt("ProductId"), loadedFootwear);
                }
            } 
        }
        catch(Exception ex)
        {
           String message = ex.getMessage();
        }
        finally
        {
           return products; 
        }
    }
    // </editor-fold> 
    //Inputs:   
    //Outputs:  HashMap<Integer, Product> selectedProducts
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: updateProducts">
    public void updateProducts(Order order)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            for(Map.Entry<Integer, OrderLine> orderLineEntry : order.getOrderLines().entrySet())
            {
                int newStockLevel = orderLineEntry.getValue().getProduct().getStockLevel() - orderLineEntry.getValue().getQuantity();
                stmt.executeUpdate("UPDATE Products SET StockLevel = '" + newStockLevel + "'  WHERE ProductId= '" + orderLineEntry.getValue().getProduct().getProductId()+ "'");
                conn.close();
            }
            
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    //</editor-fold>
    //Inputs:   Order order
    //Outputs: 
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: deleteProduct">   
    public void deleteProduct(int productId)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE * FROM Products WHERE ProductId ='" + productId + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    // </editor-fold> 
    //Inputs:   int productId
    //Outputs: 
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: insertClothing"> 
    public boolean insertClothing(Clothing newClothing)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products WHERE ProductName = '" + newClothing.getProductName()+ "'");
            
            if (rs.next())
            {
                return false;
            }
            else
            {
                stmt.executeUpdate("INSERT INTO Products (ProductName, Price, StockLevel, Measurement)" +
                    "VALUES ('"+newClothing.getProductName()+"','"+newClothing.getPrice()+"','"+newClothing.getStockLevel()+"','"+newClothing.getMeasurement()+"')");
                
                return true;
            }
        }
        catch (Exception ex)
        {
            String message = ex.getMessage();
            return false;   
        }
    }
    // </editor-fold> 
    //Inputs:   Clothing newClothing
    //Outputs: 
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: insertFootwear"> 
    public boolean insertFootwear(Footwear newFootwear)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products WHERE ProductName = '" + newFootwear.getProductName()+ "'");
            
            if (rs.next())
            {
                return false;
            }
            else
            {
                stmt.executeUpdate("INSERT INTO Products (ProductName, Price, StockLevel, Size)" +
                    "VALUES ('"+newFootwear.getProductName()+"','"+newFootwear.getPrice()+"','"+newFootwear.getStockLevel()+"','"+newFootwear.getSize()+"')");
                
                return true;
            }
        }
        catch (Exception ex)
        {
            String message = ex.getMessage();
            return false;   
        }
    }
    // </editor-fold> 
    //Inputs:   Footwear newFootwear
    //Outputs: 
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: updateFootwear"> 
    public void updateFootwear(Product product, int size)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Products SET ProductName = '"+product.getProductName()+"', Price = '"+product.getPrice()+"', StockLevel = '"+product.getStockLevel()+"', Size = '"+size+"', WHERE ProductId= '" + product.getProductId() + "'");
            conn.close(); 
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    // </editor-fold> 
    //Inputs:   Product product, int size
    //Outputs: 
    
        
    // <editor-fold defaultstate="collapsed" desc="Method: updateClothing"> 
    public void updateClothing(Product product, String measurement)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Products SET ProductName = '"+product.getProductName()+"', Price = '"+product.getPrice()+"', StockLevel = '"+product.getStockLevel()+"', Measurement = '"+measurement+"', WHERE ProductId= '" + product.getProductId() + "'");
            conn.close(); 
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    // </editor-fold> 
    //Inputs:   Product product, String measurement
    //Outputs: 
}
