
package models;

import DBManagers.OrderDBManager;
import java.util.HashMap;
import java.util.Map;


public class Customer extends User
{
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private HashMap <Integer, Order> orders;
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getAddressLine1() { return addressLine1; }
    public void setAddressLine1(String addressLine1In) { addressLine1 = addressLine1In; }
    
    public String getAddressLine2() { return addressLine2; }
    public void setAddressLine2(String addressLine1In) { addressLine2 = addressLine1In; }
    
    public String getTown() { return town; }
     public void setTown(String townIn) { town = townIn; }
    
    public String getPostcode() { return postcode; }
    public void setPostcode(String postcodeIn) { postcode = postcodeIn; }
    
    public HashMap<Integer, Order> getOrders() { return orders; }
    public void setOrders(HashMap<Integer, Order> ordersIn) { orders = ordersIn; }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Empty Constructor">
    public Customer()
    {
        super();
        addressLine1 = "";
        addressLine2 = "";
        town = "";
        postcode = "";
    }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Overloaded Constructor">
    public Customer(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn, String addressLine1In, String addressLine2In, String townIn, String postcodeIn)
    {
        super(usernameIn, passwordIn, firstNameIn, lastNameIn);
        addressLine1 = addressLine1In;
        addressLine2 = addressLine2In;
        town = townIn;
        postcode = postcodeIn;
    }
    //</editor-fold>
    
    
    
    // <editor-fold defaultstate="collapsed" desc="findLatestOrder">
    public Order findLatestOrder(Customer customer)
    {
        Order lastOrder = new Order();
        
        //Loads all orders that belong to a customer
        orders = customer.getOrders();
        
        //Checks to see if the customer has an order 
        if (orders.isEmpty())
        {
            //If the customer does not have any orders, creates a new order
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
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="addOrder">
    public void addOrder(Order newOrder)
    {
        
        orders.put(newOrder.getOrderId(), newOrder);
        OrderDBManager odb = new OrderDBManager();
        int orderId = odb.insertOrder(this.getUsername(), newOrder);
        orders.get(newOrder.getOrderId()).setOrderId(orderId);
    }
    //</editor-fold>
    //Inputs:   Order newOrder
    //Outputs:  
}
