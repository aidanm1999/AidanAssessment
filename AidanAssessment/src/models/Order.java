package models;

import java.util.Date;


public class Order 
{
    
    
    //Attributes
	
    private int order_ID;
    private Date order_date;
    private double order_total;
    private String status;
      
    
    
    
    public int get_order_ID() 
    {
        return order_ID;
    }

    public Date get_order_date() 
    {
        return order_date;
    }
    
    public double get_order_total() 
    {
        return order_total;
    }
    
    public String get_status() 
    {
        return status;
    }
    
    
    
    
    public void set_order_ID(int order_ID_in) 
    {
        order_ID_in = order_ID;
    }

    public void set_order_date(Date order_date_in) 
    {
        order_date_in = order_date;
    }

    public void set_order_total(double order_total_in) 
    {
        order_total_in = order_total;
    }

    public void set_status(String status_in) 
    {
        status_in = status;
    }
        
	


    //Constrictor Method

    public Order()
    {

    order_ID = 0;
    order_date = new Date();
    order_total = 0;
    status = "";


    }
    
    
    //Overloded 
    
    public Order(int order_ID_in, Date order_date_in, double order_total_in, String status_in)
    {

    order_ID = order_ID_in;
    order_date = order_date_in;
    order_total = order_total_in;
    status = status_in;


    }
    
    
}
