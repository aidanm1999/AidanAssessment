
package models;


public class Footwear extends Product
{
    
    private int size;

    
    
    public int get_size() 
    {
        return size;
    }

    
    
    public void set_size(int size_in) 
    {
        size_in = size;
    }
    
    
    public Footwear()
    {
        super();
        size = 0;

    }
    
    
    public Footwear(int product_ID_in, String product_name_in, double price_in, int stock_level_in, int size_in)
    {

        super(product_ID_in, product_name_in, price_in, stock_level_in);
        size = size_in;

    }
    
}
