package models;


public class OrderLine 
{
    
    
    //Attributes
	
    private int order_line_ID;
    private int quantity;
    private double line_total;
      
    
    
    
    public int get_order_line_ID() 
    {
        return order_line_ID;
    }

    public int get_quantity() 
    {
        return quantity;
    }
    
    public double get_line_total() 
    {
        return line_total;
    }
    
    
    
    
    
    public void set_order_line_ID(int order_line_ID_in) 
    {
        order_line_ID_in = order_line_ID;
    }

    public void set_quantity(int quantity_in) 
    {
        quantity_in = quantity;
    }

    public void set_line_total(double line_total_in) 
    {
        line_total_in = line_total;
    }


        
	


    //Constrictor Method

    public OrderLine()
    {

    order_line_ID = 0;
    quantity = 0;
    line_total = 0;


    }
    
    
    //Overloded 
    
    public OrderLine(int order_line_ID_in, int quantity_in, double line_total_in)
    {

    order_line_ID = order_line_ID_in;
    quantity = quantity_in;
    line_total = line_total_in;


    }
    
}
