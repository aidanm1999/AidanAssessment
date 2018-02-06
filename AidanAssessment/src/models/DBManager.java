package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;

/**
 * @author 30207717
 */
public class DBManager {
    
    public HashMap<String, Customer> loadCustomers()
    {
        HashMap<String, Customer> customers = new HashMap<>();
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://H:\\AidanAssessment\\V1.1.1\\database\\ShopDB.accdb");
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
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://H:\\AidanAssessment\\V1.1.1\\database\\ShopDB.accdb");
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
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://H:\\AidanAssessment\\V1.1.1\\database\\ShopDB.accdb");
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
    
    
    
    public boolean registerCustomer(Customer newCustomer)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://H:\\AidanAssessment\\V1.1.1\\database\\ShopDB.accdb");
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff WHERE Username = '" + newCustomer.getUsername()  + "' AND Password = '" + newCustomer.getPassword() + "'");
            
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
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://H:\\AidanAssessment\\V1.1.1\\database\\ShopDB.accdb");
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products WHERE ProductName = '" + newClothing.get_product_name()  + "'");
            
            if (rs.next())
            {
                return false;
                
            }
            else
            {
                
                stmt.executeUpdate("INSERT INTO Products (ProductName, Price, StockLevel, Measurement)" +
                    "VALUES ('"+newClothing.get_product_name()+"','"+newClothing.get_price()+"','"+newClothing.get_stock_level()+"','"+newClothing.get_measurement()+"')");
                
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
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://H:\\AidanAssessment\\V1.1.1\\database\\ShopDB.accdb");
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products WHERE ProductName = '" + newFootwear.get_product_name()  + "'");
            
            if (rs.next())
            {
                return false;
                
            }
            else
            {
                
                stmt.executeUpdate("INSERT INTO Products (ProductName, Price, StockLevel, Size)" +
                    "VALUES ('"+newFootwear.get_product_name()+"','"+newFootwear.get_price()+"','"+newFootwear.get_stock_level()+"','"+newFootwear.get_size()+"')");
                
                return true;
            }
            
            
            
        }
        catch (Exception ex)
        {
            String message = ex.getMessage();
            return false;
            
        }
        
    }
}





