package models;


public class OrderLine 
{
    
    
    //Attributes
	
    private int orderLineId;
    private int orderLineQuantity;
    private double orderLineTotal;
    private Product product;
      
    
    
    
    public int getOrderLineId() 
    {
        return orderLineId;
    }

    public int getOrderLineQuantity() 
    {
        return orderLineQuantity;
    }
    
    public double getLineTotal() 
    {
        return orderLineTotal;
    }
    
    
    
    
    
    public void setOrderLineId(int orderLineIdIn) 
    {
        orderLineIdIn = orderLineId;
    }

    public void setOrderLineQuantity(int orderLineQuantityIn) 
    {
        orderLineQuantityIn = orderLineQuantity;
    }

    public void setOrderLineTotal(double orderLineTotalIn) 
    {
        orderLineTotalIn = orderLineTotal;
    }


        
	


    //Constrictor Method

    public OrderLine()
    {

    orderLineId = 0;
    orderLineQuantity = 1;
    orderLineTotal = 0;


    }
    
    
    //Overloded 
    
    public OrderLine(int orderLineIdIn, int orderLineQuantityIn, double orderLineTotalIn)
    {

    orderLineId = orderLineIdIn;
    orderLineQuantity = orderLineQuantityIn;
    orderLineTotal = orderLineTotalIn;


    }
    
    
    public OrderLine (Order orderIn, Product productIn)
    {
        orderLineId = orderIn.generateUniqueOrderLineId();
        product = productIn;
        orderLineQuantity = 1;
        orderLineTotal = product.getCost() * quantity;
    }
    
    
}
