
package models;


public class Clothing extends Product
{
    
    private String measurement;

    
    
    public String getMeasurement() 
    {
        return measurement;
    }

    
    
    public void setMeasurement(String measurementIn) 
    {
        measurementIn = measurement;
    }
    
    
    public Clothing()
    {
        super();
        measurement = "";

    }
    
    
    public Clothing(int product_ID_in, String product_name_in, double price_in, int stock_level_in, String measurement_in)
    {

        super(product_ID_in, product_name_in, price_in, stock_level_in);
        measurement = measurement_in;

    }
    
}
