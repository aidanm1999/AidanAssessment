package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

//@author Aidan Marshall

public class DBManager {
    
    private final String connString = "jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Documents\\Projects\\AidanAssessment\\AidanAssessment\\database\\ShopDB.accdb"; 
    
    
    
    
    //Customer ---------------------------------------------------------------------------------
    
    public HashMap<String, Customer> loadCustomers()
    {

        HashMap<String, Customer> customers = new HashMap<>();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");
            
            if(!rs.next())
            {
                conn.close();
                return null;
            }
            else
            {
                while(rs.next())
                {
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    String firstName = rs.getString("FirstName");
                    String lastName = rs.getString("LastName");
                    String addressLine1 = rs.getString("AddressLine1");
                    String addressLine2 = rs.getString("AddressLine2");
                    String town = rs.getString("Town");
                    String postcode = rs.getString("Postcode"); 
                    
                    Customer customer = new Customer(username, password, firstName, 
                        lastName, addressLine1, addressLine2, town, postcode);
                
                    customers.put(username, customer);
                }
                
            }
            
        }
        catch(Exception ex)
        {
           String message = ex.getMessage();
        }
        finally
        {
           return customers; 
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public Customer customerLogIn(String usernameIn, String passwordIn)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers WHERE Username = '" + usernameIn  + "' AND Password = '" + passwordIn + "'");
            
            if(!rs.next())
            {
                conn.close();
                return null;
            }
            else
            {
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String addressLine1 = rs.getString("AddressLine1");
                String addressLine2 = rs.getString("AddressLine2");
                String town = rs.getString("Town");
                String postcode = rs.getString("Postcode"); 
                
                conn.close();
                Customer customer = new Customer(username, password, firstName, 
                        lastName, addressLine1, addressLine2, town, postcode);
                return customer;
            }
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return null;
        }
    } 
    
    
    
    
    
    
    
    
    
    
    
    public boolean registerCustomer(Customer newCustomer)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers WHERE Username = '" + newCustomer.getUsername()  + "' AND Password = '" + newCustomer.getPassword() + "'");
            
            if (rs.next())
            {
                return false;
                
            }
            else
            {
                stmt.executeUpdate("INSERT INTO Customers (Username, Password, FirstName, LastName, AddressLine1, AddressLine2, Town, Postcode)" +
                    "VALUES ('"+newCustomer.getUsername()+"','"+newCustomer.getPassword()+"','"+newCustomer.getFirstName()+"',"
                            + "'"+newCustomer.getLastName()+"','"+newCustomer.getAddressLine1()+"','"+newCustomer.getAddressLine2()+"',"
                            + "'"+newCustomer.getTown()+"','"+newCustomer.getPostcode()+"')");
                
                return true;
            }
            
            
            
        }
        catch (Exception ex)
        {
            String message = ex.getMessage();
            return false;
            
        }
        
    }
    
    
    
    
    
    
    
    
    
        public boolean updateCustomer(Customer customer)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            
            stmt.executeUpdate("UPDATE Customers "
                    + "SET Username = '" +customer.getUsername()+ "', Password = '"+customer.getPassword()+"', FirstName = '"+customer.getFirstName()+"', LastName = '"+customer.getLastName()+"', AddressLine1 = '"+customer.getAddressLine1()+"', AddressLine2 = '"+customer.getAddressLine2()+"', Town = '"+customer.getTown()+"', Postcode = '"+customer.getPostcode()+"' "
                    + "WHERE Username = '"+customer.getUsername()+"'");

            return true;
            
            
            
            
        }
        catch (Exception ex)
        {
            String message = ex.getMessage();
            return false;
            
        }
        
    }

    
    
    
    
        
        
        
        
        
        

    public boolean deleteCustomer(Customer customer)
    {
        try
        {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            
            stmt.executeUpdate("DELETE FROM Customers WHERE Username ='" + customer.getUsername() + "'");

            return true; 
            
        }
        catch (Exception ex)
        {
            String message = ex.getMessage();
            return false;
            
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    //Order ------------------------------------------------------------------------------------
    
    public void updateOrderTotal(int orderId, double lineTotal)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            
            stmt.executeUpdate("UPDATE Orders SET OrderTotal= OrderTotal+ " + lineTotal +
                    " WHERE OrderId= '" + orderId + "'");
            conn.close();
            
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    
    
    public int addOrder(String personId, Order newOrder)
    {
        int orderId = 0;
        
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO Orders (OrderDate, Username, OrderTotal, " +
                    "Status) VALUES ('" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(newOrder.getOrderDate()) +
                    "','" + personId + "','" + newOrder.getOrderTotal() + "','" +
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
    
    
    
    public void completeOrder(int orderId)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Orders SET Status = 'Complete', OrderDate = '"+ 
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "'  WHERE OrderId= '" + orderId + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    public void dispatchOrder(int orderId)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("UPDATE Orders SET Status = 'Dispatched', OrderDate = '"+ 
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "'  WHERE OrderId= '" + orderId + "'");
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    
    

    
    public HashMap<Integer, Order> loadCustomerOrders(Customer customer)
    {
        HashMap<Integer, Order> customerOrders = new HashMap<>();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Orders WHERE Username = '"+customer.getUsername()+"'");
            
            while(rs.next())
            {
                
                String dateString = rs.getString("OrderDate");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                Date date = formatter.parse(dateString);
                Order loadedOrder = new Order(rs.getInt("OrderId"),date,rs.getDouble("OrderTotal"),rs.getString("Status"));
                customerOrders.put(loadedOrder.getOrderId(), loadedOrder);
            }
        }
        catch(Exception ex)
        {
           String message = ex.getMessage();
        }
        finally
        {
           return customerOrders; 
        }
    }
    
    
    
    
    
    
    
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Order Line -------------------------------------------------------------------------------
    
    
    public void deleteOrderLine(int orderId, int productId)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE FROM OrderLines WHERE "
                    + "OrderId = '"+orderId+"' AND "
                    + "ProductId='"+productId+"'");
            
            
            conn.close();
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
    
    
    
    public void addOrderLine(OrderLine newOrderLine, int orderId)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("INSERT INTO OrderLines (OrderLineId, ProductId, Quantity, LineTotal, OrderId) VALUES ('" + newOrderLine.getOrderLineId() +
                    "','" + newOrderLine.getProduct().getProductId() + "','" + newOrderLine.getQuantity()+ "','" +
                    newOrderLine.getLineTotal()+ "','" + orderId + "')");
            conn.close();
            
            updateOrderTotal(orderId, newOrderLine.getLineTotal());
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
    }
   
    
    
    
    
    
    
    public HashMap<Integer, Integer> loadCustomerProductQuantities(Customer customer)
    {

        HashMap<Integer, Integer> customerProductQuantities = new HashMap<>();
        try
        {
            Order loadedOrder = customer.findLatestOrder();
        
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM OrderLines WHERE OrderId = '"+loadedOrder.getOrderId()+"'");
            
            while(rs.next())
            {
                customerProductQuantities.put(rs.getInt("ProductId"), rs.getInt("Quantity"));
            }
            
        }
        catch(Exception ex)
        {
           String message = ex.getMessage();
        }
        finally
        {
           return customerProductQuantities; 
        }
    }
    
    
    
    

    
    public HashMap<Integer, OrderLine> loadCustomerOrderLines(Customer customer, Order order)
    {
        HashMap<Integer, OrderLine> customerOrderLines = new HashMap<>();
        try
        {
            
            HashMap<Integer, Product> products = loadProducts();
            
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM OrderLines WHERE OrderId = '"+order.getOrderId()+"'");
            
            
            
            while(rs.next())
            {
                //Construct orderLine
                    //Order
                    //Product 
                    //Quantity
                OrderLine oLine = new OrderLine(order, products.get(rs.getInt("ProductId")),rs.getInt("Quantity"));
                
                //Add orderLine to customerOrderLines
                customerOrderLines.put(rs.getInt("OrderLineId"), oLine);
            }
        }
        catch(Exception ex) {String message = ex.getMessage();}
        finally {return customerOrderLines;}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Product ----------------------------------------------------------------------------------
    
    
    public HashMap<Integer, Product> loadProducts()
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
                int productId = rs.getInt("ProductId");
                String productName = rs.getString("ProductName");
                int price = rs.getInt("Price");
                int stockLevel = rs.getInt("StockLevel");
                
                String measurement = rs.getString("Measurement");
                int size = rs.getInt("Size");
                
                    
                if(measurement != null && measurement != "")
                {
                    Clothing loadedClothing = new Clothing(productId, productName, price, stockLevel, measurement);
                    products.put(productId, loadedClothing);
                }
                else
                {
                    Footwear loadedFootwear = new Footwear(productId, productName, price, stockLevel, size);
                    products.put(productId, loadedFootwear);
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
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean registerClothing(Clothing newClothing)
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
    
    
    
    
    
    
    
    
    
    
    
        public boolean registerFootwear(Footwear newFootwear)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products WHERE ProductName = '" + newFootwear.getProductName()  + "'");
            
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
    
    
    
    
    
    
        public boolean deleteProduct(Product product)
    {
        try
        {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            
            stmt.executeUpdate("DELETE FROM Products WHERE ProductId ='" + product.getProductId() + "'");

            return true; 
            
        }
        catch (Exception ex)
        {
            String message = ex.getMessage();
            return false;
            
        }
        
    }
        
        
        
        
        
        
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
        
        
        
        
        
        
        
        
        
        
        
    
    
    
    
    //Staff ------------------------------------------------------------------------------------
    
    public Staff staffLogIn(String usernameIn, String passwordIn)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff WHERE Username = '" + usernameIn  + "' AND Password = '" + passwordIn + "'");
            
            if(!rs.next())
            {
                conn.close();
                return null;
            }
            else
            {
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String position = rs.getString("Position");
                Double salary = rs.getDouble("Salary");
                
                conn.close();
                Staff staff = new Staff(username, password, firstName, lastName, position, salary);
                return staff;
            }
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return null;
        }
    }  
    
    
    
}