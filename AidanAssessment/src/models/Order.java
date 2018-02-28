package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Order 
{
    
    
    //Attributes
    
    private int orderId;
    private Date orderDate;
    private Customer customer;
    private double orderTotal;
    private String status;
    private HashMap<Integer, OrderLine> orderLines;
      
    
    public void addOrderLine (OrderLine orderLine)
    {
        orderTotal = orderTotal + orderLine.getLineTotal();
        orderLines.put(orderLine.getOrderLineId(), orderLine);
        DBManager db = new DBManager();
        db.addOrderLine(orderLine, orderId);
    }
    
    public void removeOrderLine(int productId)
    {
        Iterator<Map.Entry<Integer, OrderLine>> iter = orderLines.entrySet().iterator();
        while(iter.hasNext())
        {
            Map.Entry<Integer, OrderLine> entry = iter.next();
            if(entry.getValue().getProduct().getProductId() == productId)
            {
                iter.remove();
                orderTotal = orderTotal - entry.getValue().getLineTotal();
                DBManager db = new DBManager();
                
                db.deleteOrderLine(orderId, productId);
                db.updateOrderTotal(orderId, -entry.getValue().getLineTotal());
            }
        }
    }
    
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
    
    public int getOrderId(){return orderId;}
    public void setOrderId(int oId){orderId = oId;}
    
    public Date getOrderDate(){return orderDate;}
    public void setOrderDate(Date oDate){orderDate = oDate;}
    
    public double getOrderTotal(){return orderTotal;}
    public void setOrderTotal(double oTotal){orderTotal = oTotal;}
    
    public String getStatus(){return status;}
    public void setStatus(String oStatus){status = oStatus;}
    
    public HashMap<Integer, OrderLine> getOrderLines(){return orderLines;}
    public void setOrderLines(HashMap<Integer, OrderLine> oLines){orderLines = oLines;}

    public Customer getCustomer(){return customer;}
    public void setOrderLines(Customer cust){customer = cust;}
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    //Constrictor Method

    public Order()
    {
        orderId = 0;
        orderDate = new Date();
        orderTotal = 0;
        status = "Opened";
        orderLines = new HashMap<>();
    }
    
    
    //Overloded 
    
    public Order(int oId, Date oDate, double oTotal, String oStatus)
    {
        orderId = oId;
        orderDate = oDate;
        orderTotal = oTotal;
        status = oStatus;
        orderLines = new HashMap<>();
    }
    
    
    
    
    
    public Order(int oId, Date oDate, double oTotal) //For complete orders ONLY
    {
        DBManager db = new DBManager();
        orderId = oId;
        orderTotal = oTotal;
        orderDate = oDate;
        status = "Complete";
    }
    
}
