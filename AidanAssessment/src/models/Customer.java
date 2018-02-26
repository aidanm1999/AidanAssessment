
package models;

import java.util.HashMap;
import java.util.Map;


public class Customer extends User
{
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private HashMap <Integer, Order> orders;
    
    
    
    
    public Order findLatestOrder()
    {
        Order lastOrder = new Order();
        
        DBManager db = new DBManager();
        
        //loads all orders that belong to a customer
        orders = db.loadCustomerOrders(this);
        
        //Checks to see if the customer has an order 
        if (orders.isEmpty())
        {
            //If the customer does not have an order, creates a new order
            addOrder(lastOrder);
        }
        else
        {
            //If the customer does have an order, finds latest order
            lastOrder = orders.entrySet().iterator().next().getValue();
            for(Map.Entry<Integer, Order> newOrderEntry : orders.entrySet())
            {
                if(newOrderEntry.getValue().getOrderDate().after(lastOrder.getOrderDate()))
                {
                    lastOrder = newOrderEntry.getValue();
                }
            }
            
            //If the order is complete, adds new order
            if (lastOrder.getStatus().equals("Complete"))
            {
                lastOrder = new Order();
                addOrder(lastOrder);
            }
        }
        
        return lastOrder;
    }
    
    
    
    public void addOrder(Order newOrder)
    {
        
        orders.put(newOrder.getOrderId(), newOrder);
        DBManager db = new DBManager();
        int orderId = db.addOrder(this.getUsername(), newOrder);
        orders.get(newOrder.getOrderId()).setOrderId(orderId);
    }
    
    
    
    
    
    
    
    public String getAddressLine1() 
    {
        return addressLine1;
    }
    
    public String getAddressLine2() 
    {
        return addressLine2;
    }
    
    public String getTown() 
    {
        return town;
    }
    
    public String getPostcode() 
    {
        return postcode;
    }

    
    
    
    
    
    public void set_address_line_1(String addressLine1In) 
    {
        addressLine1 = addressLine1In;
    }
    
    public void setAddressLine_2(String addressLine2In) 
    {
        addressLine2 = addressLine2In;
    }

    public void setTown(String townIn) 
    {
        town = townIn;
    }

    public void set_postcode(String postcodeIn) 
    {
        postcode = postcodeIn;
    }
    
    
    
    
  
    
    
    public Customer()
    {
        super();
        
        addressLine1 = "";
        addressLine2 = "";
        town = "";
        postcode = "";

    }
    
    
    public Customer(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn, String addressLine1In, String addressLine2In, String townIn, String postcodeIn)
    {

        super(usernameIn, passwordIn, firstNameIn, lastNameIn);
        
        addressLine1 = addressLine1In;
        addressLine2 = addressLine2In;
        town = townIn;
        postcode = postcodeIn;

    }
}
