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
            
            stmt.executeUpdate("UPDATE Orders SET OrderTotal= OrderTotal + '" + lineTotal+ "' WHERE OrderId= '" + orderId + "'");
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
            
            stmt.executeUpdate("INSERT INTO Orders (OrderDate, ZooKeeper, OrderTotal, " +
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
    
    
    
    
    
    
    
    
    //Order Line -------------------------------------------------------------------------------
    
    
    public void deleteOrderLine(int orderId, int productId)
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection conn = DriverManager.getConnection(connString);
            Statement stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE FROM OrderLines WHERE OrderId = '" + 
                    orderId + " AND Username = '"+ productId +"'");
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
            
            stmt.executeUpdate("INSERT INTO OrderLines (OrderLineId, AnimalId, Quantity, LineTotal, " +
                    "OrderId) VALUES ('" + newOrderLine.getOrderLineId() +
                    "','" + newOrderLine.getAnimal().getAnimalId() + "','" + newOrderLine.getQuantity()+ "','" +
                    newOrderLine.getLineTotal()+ "','" + orderId + "')");
            conn.close();
            
            updateOrderTotal(orderId, newOrderLine.getLineTotal());
        }
        catch(Exception ex)
        {
            String message = ex.getMessage();
        }
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




//    //ANIMALS-------------------------------------------------------------------
//    public HashMap<Integer, Animal> loadAnimals()
//    {
//        HashMap<Integer, Animal> animals = new HashMap();
//        
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM Animals");
//            
//            while(rs.next())
//            {
//                int animalId = rs.getInt("AnimalId");
//                String name = rs.getString("AnimalName");
//                int age = rs.getInt("Age");
//                String type = rs.getString("Type");
//                char gender = rs.getString("Gender").charAt(0);
//                String location = rs.getString("Location");
//                    
//                String waterType = rs.getString("WaterType");
//                
//                boolean availability = rs.getBoolean("Availability");
//                double cost = rs.getDouble("Cost");
//                    
//                if(waterType != null && !waterType.isEmpty())
//                {
//                    Fish loadedFish = new Fish(animalId, location, name, age, type, gender, waterType, availability, cost);
//                    animals.put(animalId, loadedFish);
//                }
//                else
//                {
//                    boolean canFly = rs.getBoolean("CanFly");
//                    Bird loadedBird = new Bird(animalId, location, name, age, type, gender, canFly, availability, cost);
//                    animals.put(animalId, loadedBird);
//                }
//            }
//            conn.close();
//            return animals;
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//            return null;
//        }
//    }
//    
//    
//    
//    public void updateAnimal(Animal updateAnimal)
//    {
//        String canFly = "NULL";
//        String waterType = "";
//        
//        if(updateAnimal.getClass().getName().equals("models.Bird"))
//        {
//            Bird updateBird = (Bird)updateAnimal;
//            canFly = String.valueOf(updateBird.getCanFly());
//        }
//        else
//        {
//            Fish updateFish = (Fish)updateAnimal;
//            waterType = updateFish.getWaterType();
//        }
//        
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            
//            stmt.executeUpdate("UPDATE Animals SET AnimalName= '" + updateAnimal.getName() + "', "
//                    + "Age= '" + updateAnimal.getAge() + "', Type= '" + updateAnimal.getType() + "', "
//                    + "Gender= '" + updateAnimal.getGender() + "', Location= '" + updateAnimal.getLocation() + "', "
//                    + "CanFly= " + canFly + ", WaterType= '" + waterType + "', Cost= '" + updateAnimal.getCost() + "' "
//                            + "WHERE AnimalId= '" + updateAnimal.getAnimalId() + "'");
//            conn.close();
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//        }
//    }
//    
//    
//    
//    public void addAnimal(Animal newAnimal)
//    {
//        //boolean canFly = false;
//        String canFly = "NULL";
//        String waterType = "";
//        
//        if(newAnimal.getClass().getName().equals("models.Bird"))
//        {
//            Bird newBird = (Bird)newAnimal;
//            canFly = String.valueOf(newBird.getCanFly());
//        }
//        else
//        {
//            Fish newFish = (Fish)newAnimal;
//            waterType = newFish.getWaterType();
//        }
//        
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            
//            stmt.executeUpdate("INSERT INTO Animals (AnimalName, Age, Type, Gender, " +
//                    "Location, CanFly, WaterType, Availability, Cost) VALUES ('" + newAnimal.getName() +
//                    "','" + newAnimal.getAge() + "','" + newAnimal.getType() + "','" +
//                    newAnimal.getGender() + "','" + newAnimal.getLocation() + "'," +
//                    canFly + ",'" + waterType + "',true,'" + newAnimal.getCost() + "')");
//            conn.close();
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//        }
//    }
//    
//    
//    
//    public void deleteAnimal(Animal newAnimal)
//    {
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            
//            stmt.executeUpdate("DELETE FROM Animals WHERE AnimalId = '" + 
//                    newAnimal.getAnimalId() + "'");
//            conn.close();
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//        }
//    }
//    
//    
//    
//    public void updateAnimalAvailablility(Animal animal)
//    {
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            
//            stmt.executeUpdate("UPDATE Animals SET Availability = "+animal.getIsAvailable()+ " WHERE AnimalId= '" + animal.getAnimalId() + "'");
//            conn.close();
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//        }
//    }
//    
//    
//    
//    
//    
//    
//    
//    
//    //ORDERS--------------------------------------------------------------------
//    public void updateOrderTotal(int orderId, double lineTotal)
//    {
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            
//            stmt.executeUpdate("UPDATE Orders SET OrderTotal= OrderTotal + '" + lineTotal+ "' WHERE OrderId= '" + orderId + "'");
//            conn.close();
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//        }
//    }
//    
//    
//    
//    public int addOrder(String personId, Order newOrder)
//    {
//        int orderId = 0;
//        
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            
//            stmt.executeUpdate("INSERT INTO Orders (OrderDate, ZooKeeper, OrderTotal, " +
//                    "Status) VALUES ('" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(newOrder.getOrderDate()) +
//                    "','" + personId + "','" + newOrder.getOrderTotal() + "','" +
//                    newOrder.getStatus() + "')");
//            
//            ResultSet rs = stmt.getGeneratedKeys();
//            
//            if(rs.next())
//            {
//                orderId = rs.getInt(1);
//            }
//            
//            conn.close();
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//        }
//        
//        return orderId;
//    }
//    
//    
//    
//    public void completeOrder(int orderId)
//    {
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            
//            stmt.executeUpdate("UPDATE Orders SET Status = 'Complete', OrderDate = '"+ 
//                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "'  WHERE OrderId= '" + orderId + "'");
//            conn.close();
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//        }
//    }
//    
//    
//    
//    
//    
//    
//    
//    //ORDER LINES---------------------------------------------------------------
//    public void deleteOrderLine(int orderId, int animalId)
//    {
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            
//            stmt.executeUpdate("DELETE FROM OrderLines WHERE AnimalId = '" + 
//                    orderId + " AND AnimalId = '"+ animalId +"'");
//            conn.close();
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//        }
//    }
//    
//    
//    
//    public void addOrderLine(OrderLine newOrderLine, int orderId)
//    {
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            
//            stmt.executeUpdate("INSERT INTO OrderLines (OrderLineId, AnimalId, Quantity, LineTotal, " +
//                    "OrderId) VALUES ('" + newOrderLine.getOrderLineId() +
//                    "','" + newOrderLine.getAnimal().getAnimalId() + "','" + newOrderLine.getQuantity()+ "','" +
//                    newOrderLine.getLineTotal()+ "','" + orderId + "')");
//            conn.close();
//            
//            updateOrderTotal(orderId, newOrderLine.getLineTotal());
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//        }
//    }
//    
//    
//    
//    
//    
//    
//    
//    
//    //ZOO KEEPERS---------------------------------------------------------------
//    public ZooKeeper zooKeeperLogIn(String idIn, int pinNoIn)
//    {
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM ZooKeepers WHERE PersonId = '" + idIn  + "' AND PinNo = '" + pinNoIn + "'");
//            
//            if(!rs.next())
//            {
//                conn.close();
//                return null;
//            }
//            else
//            {
//                String personId = rs.getString("PersonId");
//                String name = rs.getString("PersonName");
//                Date dateHired = rs.getDate("DateHired");
//                double salary = rs.getDouble("Salary");
//                int pinNo = rs.getInt("PinNo");
//                String telephoneNo = rs.getString("TelephoneNo");
//                String emailAddress = rs.getString("EmailAddress");
//                
//                conn.close();
//                ZooKeeper keeper = new ZooKeeper(personId, name, dateHired, 
//                        salary, pinNo, telephoneNo, emailAddress);
//                return keeper;
//            }
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//            return null;
//        }
//    }
//    
//    public void updateZooKeeper(ZooKeeper updateKeeper)
//    {      
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            
//            stmt.executeUpdate("UPDATE ZooKeepers SET PersonName= '" + updateKeeper.getName() + "', "
//                    + "DateHired= '" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(updateKeeper.getDateHired()) + "', " 
//                    + "Salary= '" + updateKeeper.getSalary()+ "', "
//                    + "PinNo= '" + updateKeeper.getPinNo()+ "', TelephoneNo= '" + updateKeeper.getTelephoneNo() + "', "
//                    + "EmailAddress= '" + updateKeeper.getEmailAddress() + "' "
//                            + "WHERE PersonId= '" + updateKeeper.getPersonId() + "'");
//            conn.close();
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//        }
//    }
//    
//    public HashMap<String, ZooKeeper> loadZooKeepers()
//    {
//        HashMap<String, ZooKeeper> keepers = new HashMap<>();
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = 
//                    DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM ZooKeepers");
//            
//
//            while(rs.next())
//            {
//                conn.close();
//                String personId = rs.getString("PersonId");
//                String name = rs.getString("PersonName");
//                Date dateHired = rs.getDate("DateHired");
//                double salary = rs.getDouble("Salary");
//                int pinNo = rs.getInt("PinNo");
//                String telephoneNo = rs.getString("TelephoneNo");
//                String emailAddress = rs.getString("EmailAddress");
//                
//                ZooKeeper keeper = new ZooKeeper(personId, name, dateHired, 
//                        salary, pinNo, telephoneNo, emailAddress);
//                
//                keepers.put(personId, keeper);
//            }
//        }
//        catch(Exception ex)
//        {
//           String message = ex.getMessage();
//        }
//        finally
//        {
//           return keepers; 
//        }
//    }
//    
//    public boolean registerZooKeeper(ZooKeeper newKeeper)
//    {
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            
//            ResultSet rs = stmt.executeQuery("SELECT * FROM ZooKeepers WHERE PersonId = '" + newKeeper.getPersonId() + "'");
//            if(rs.next())
//            {
//                conn.close();
//                return false;
//            }
//            else
//            {
//                stmt.executeUpdate("INSERT INTO ZooKeepers (PersonId, PersonName, DateHired, Salary, PinNo, TelephoneNo, EmailAddress) " +
//                    "VALUES ('" + newKeeper.getPersonId() + "','" + newKeeper.getName() + "','" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(newKeeper.getDateHired()) + "','" +
//                            newKeeper.getSalary() + "','" + newKeeper.getPinNo() + "','" + newKeeper.getTelephoneNo() + "','" + 
//                            newKeeper.getEmailAddress() + "')");
//                conn.close();
//                return true;
//            }
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//            return false;
//        }
//    }
//    
//    public void deleteZooKeeper(ZooKeeper keeper)
//    {
//        try
//        {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Aidan Marshall\\Desktop\\Projects\\ZooProject\\V1.5\\Data\\Database1.accdb");
//            Statement stmt = conn.createStatement();
//            
//            stmt.executeUpdate("DELETE FROM ZooKeepers WHERE PersonId = '" + 
//                    keeper.getPersonId() + "'");
//            conn.close();
//        }
//        catch(Exception ex)
//        {
//            String message = ex.getMessage();
//        }
//    }
//}
