package models;

import java.util.Date;
import java.util.Map;


public class Order 
{
    
    
    //Attributes
	
    private int orderId;
    private Date orderDate;
    private double orderTotal;
    private String orderStatus;
      
    
    public int generateUniqueOrderLineId()
    {
        int orderLineId = 0;
        for(Map.Entry<Integer, OrderLine> orderLineEntry : orderLines.entrySet())
        {
            if (orderLines.containsKey(orderLineId))
            {
                orderLineId++;
            }
        }
        
        return orderLineId;
    }
    
    public int getOrderId() 
    {
        return orderId;
    }

    public Date getOrderDate() 
    {
        return orderDate;
    }
    
    public double getOrderTotal() 
    {
        return orderTotal;
    }
    
    public String getOrderStatus() 
    {
        return orderStatus;
    }
    
    
    
    
    public void setOrderId(int orderIdIn) 
    {
        orderIdIn = orderId;
    }

    public void setOrderDate(Date orderDateIn) 
    {
        orderDateIn = orderDate;
    }

    public void setOrderTotal(double orderTotalIn) 
    {
        orderTotalIn = orderTotal;
    }

    public void setOrderStatus(String orderStatusIn) 
    {
        orderStatusIn = orderStatus;
    }
        
	


    //Constrictor Method

    public Order()
    {

    orderId = 0;
    orderDate = new Date();
    orderTotal = 0;
    orderStatus = "Pending";


    }
    
    
    //Overloded 
    
    public Order(int orderIdIn, Date orderDateIn, double orderTotalIn, String orderStatusIn)
    {

    orderId = orderIdIn;
    orderDate = orderDateIn;
    orderTotal = orderTotalIn;
    orderStatus = orderStatusIn;


    }
    
    
}
