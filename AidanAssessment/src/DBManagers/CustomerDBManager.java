package DBManagers;

//@author Aidan Marshall

// <editor-fold defaultstate="collapsed" desc="Imports">
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import models.Customer;
//</editor-fold>


 
public class CustomerDBManager
{
    // <editor-fold defaultstate="collapsed" desc="String: connString">
    private final String connString = "jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Documents\\Projects\\AidanAssessment\\AidanAssessment\\database\\ShopDB.accdb"; 
    //</editor-fold>

    
    // <editor-fold defaultstate="collapsed" desc="Method: selectCustomer">
    public Customer selectCustomer(String usernameIn)
    { 
        try
        {
            //Connects to database and executes query
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers WHERE Username = '" + usernameIn  + "'");
            
            if(!rs.next())
            {
                conn.close();
                return null;
            }
            else
            {
                Customer selectedCustomer = new Customer(
                    rs.getString("Username"), 
                    rs.getString("Password"),
                    rs.getString("FirstName"), 
                    rs.getString("LastName"), 
                    rs.getString("AddressLine1"), 
                    rs.getString("AddressLine2"), 
                    rs.getString("Town"), 
                    rs.getString("Postcode"));
                
                conn.close();
                
                OrderDBManager odb = new OrderDBManager();
                
                selectedCustomer.setOrders(odb.selectCustomerOrders(rs.getString("Username")));
                
                return selectedCustomer;
            }
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
            return null;
        }
    } 
    //</editor-fold>
    //Inputs:   String username, String password
    //Outputs:  Customer selectedCustomer
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: selectAllCustomers">     
    private HashMap<String, Customer> selectAllCustomers()
    {
        HashMap<String, Customer> allCustomers = new HashMap<>();
        
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
                
                    allCustomers.put(username, customer);
                }
            }
        }
        catch(Exception ex) { String message = ex.getMessage(); }
        finally { return allCustomers; }
    }
    
    // </editor-fold> 
    //Inputs:   String username, String password
    //Outputs:  HashMap<String, Customer> allCustomers
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: insertCustomer">     
    public boolean insertCustomer(Customer newCustomer)
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
    
    // </editor-fold> 
    //Inputs:   Customer newCustomer
    //Outputs:  boolean
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: updateCustomer">     
    public boolean updateCustomer(Customer customer)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            
            stmt.executeUpdate("UPDATE Customers SET "
                    + "Username = '" +customer.getUsername()+ "', "
                    + "Password = '"+customer.getPassword()+"', "
                    + "FirstName = '"+customer.getFirstName()+"', "
                    + "LastName = '"+customer.getLastName()+"', "
                    + "AddressLine1 = '"+customer.getAddressLine1()+"', "
                    + "AddressLine2 = '"+customer.getAddressLine2()+"', "
                    + "Town = '"+customer.getTown()+"', "
                    + "Postcode = '"+customer.getPostcode()+"' "
                    + "WHERE Username = '"+customer.getUsername()+"'");

            return true;
        }
        catch (Exception ex)
        {
            String message = ex.getMessage();
            return false;
        }
        
    }
    // </editor-fold> 
    //Inputs:   Customer customer
    //Outputs:  boolean
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: deleteCustomer">     
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
    // </editor-fold> 
    //Inputs:   Customer customer
    //Outputs:  boolean
    
    
}
