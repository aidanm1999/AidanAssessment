package DBManagers;

//@author Aidan Marshall

// <editor-fold defaultstate="collapsed" desc="Imports">
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import models.Staff;
//</editor-fold>


 
public class StaffDBManager
{
    // <editor-fold defaultstate="collapsed" desc="String: connString">
    private final String connString = "jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Documents\\Projects\\AidanAssessment\\AidanAssessment\\database\\ShopDB.accdb"; 
    //</editor-fold>

    
    // <editor-fold defaultstate="collapsed" desc="Method: selectStaff">
    public Staff selectStaff(String usernameIn)
    { 
        try
        {
            //Connects to database and executes query
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff WHERE Username = '" + usernameIn  + "'");
            
            if(!rs.next())
            {
                conn.close();
                return null;
            }
            else
            {
                Staff selectedStaff = new Staff(
                    rs.getString("Username"), 
                    rs.getString("Password"),
                    rs.getString("FirstName"), 
                    rs.getString("LastName"), 
                    rs.getString("Position"), 
                    rs.getDouble("Salary"));
                
                conn.close();
                
                return selectedStaff;
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
}
