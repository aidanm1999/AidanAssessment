package models;


// <editor-fold defaultstate="collapsed" desc="Imports">
    import java.util.Date;
    import java.util.HashMap;
    import java.util.Map;
    //</editor-fold>


public class Order 
{
    
    
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    private int orderId;
    private Date orderDate;
    private double orderTotal;
    private String status;
    private HashMap<Integer, OrderLine> orderLines;
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
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
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Empty Constructor">
    public Order()
    {
        orderId = 0;
        orderDate = new Date();
        orderTotal = 0;
        status = "Opened";
        orderLines = new HashMap<>();
    }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Overloaded Constructor">
    public Order(int orderIdIn, Date orderDateIn, double orderTotalIn, String orderStatusIn)
    {
        orderId = orderIdIn;
        orderDate = orderDateIn;
        orderTotal = orderTotalIn;
        status = orderStatusIn;
        orderLines = new HashMap<>();
    }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: addOrderLine">
    public void addOrderLine (OrderLine orderLine)
    {
        //Adds the orderline to the HashMap
        orderLines.put(orderLine.getOrderLineId(), orderLine);
    }
    //</editor-fold>
    //Inputs:   OrderLine orderLine
    //Outputs:  
    
    
    // <editor-fold defaultstate="collapsed" desc="Method: generateUniqueOrderLineId">
    public int generateUniqueOrderLineId()
    {
        //Creates a new unique OrderLineId
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
    //</editor-fold>
    //Inputs:   
    //Outputs:  int orderLineid
    
    
  
}
