
package models;


public class Product 
{
    
    //Attributes
	
    private int product_ID;
    private String product_name;
    private double price;
    private int stock_level;
      
    
    
    
    public int get_product_ID() 
    {
        return product_ID;
    }

    public String get_product_name() 
    {
        return product_name;
    }
    
    public double get_price() 
    {
        return price;
    }
    
    public int get_stock_level() 
    {
        return stock_level;
    }
    
    
    
    
    public void set_product_ID(int product_ID_in) 
    {
        product_ID_in = product_ID;
    }

    public void set_product_name(String product_name_in) 
    {
        product_name_in = product_name;
    }

    public void set_price(double price_in) 
    {
        price_in = price;
    }

    public void set_stock_level(int stock_level_in) 
    {
        stock_level_in = stock_level;
    }
        
	


    //Constrictor Method

    public Product()
    {

    product_ID = 0;
    product_name = "";
    price = 0;
    stock_level = 0;


    }
    
    
    //Overloded 
    
    public Product(int product_ID_in, String product_name_in, double price_in, int stock_level_in)
    {

    product_ID = product_ID_in;
    product_name = product_name_in;
    price = price_in;
    stock_level = stock_level_in;


    }
    
}
