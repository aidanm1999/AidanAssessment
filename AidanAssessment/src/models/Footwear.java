
package models;


public class Footwear extends Product
{
    
    private int size;

    
    
    public int getSize() 
    {
        return size;
    }

    
    
    public void setSize(int sizeIn) 
    {
        size = sizeIn;
    }
    
    
    public Footwear()
    {
        super();
        size = 0;

    }
    
    
    public Footwear(int product_ID_in, String product_name_in, double price_in, int stock_level_in, int sizeIn)
    {

        super(product_ID_in, product_name_in, price_in, stock_level_in);
        size = sizeIn;

    }
    
}
