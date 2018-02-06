package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

//@author Aidan Marshall

public class DBManager {
    
     
    public HashMap<String, Customer> loadCustomers()
    {
        HashMap<String, Customer> customers = new HashMap<>();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\AidanAssessment\\V1.1.2\\database\\ShopDB.accdb");
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
    
    
    
    public HashMap<Integer, Product> loadProducts()
    {
        HashMap<Integer, Product> products = new HashMap<>();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\AidanAssessment\\V1.1.2\\database\\ShopDB.accdb");
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
    
    
    
    
    
    //Read sigle row from database
    
    
    public Customer customerLogIn(String usernameIn, String passwordIn)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\AidanAssessment\\V1.1.2\\database\\ShopDB.accdb");
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

    
    
    
    public Staff staffLogIn(String usernameIn, String passwordIn)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\AidanAssessment\\V1.1.2\\database\\ShopDB.accdb");
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
    
    
    
    
    
    
    //Write sigle row to database
    
    
    public boolean registerCustomer(Customer newCustomer)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\AidanAssessment\\V1.1.2\\database\\ShopDB.accdb");
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
     
    
    public boolean registerClothing(Clothing newClothing)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\AidanAssessment\\V1.1.2\\database\\ShopDB.accdb");
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
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\AidanAssessment\\V1.1.2\\database\\ShopDB.accdb");
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



    

    //Updates singe row in database

    public boolean updateCustomer(Customer customer)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\AidanAssessment\\V1.1.2\\database\\ShopDB.accdb");
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

    
    
    
    
    //Deletes singe row in database

    public boolean deleteCustomer(Customer customer)
    {
        try
        {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\AidanAssessment\\V1.1.2\\database\\ShopDB.accdb");
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

}