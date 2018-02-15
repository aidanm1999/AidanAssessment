
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
    
    
    public Clothing(int productIdIn, String productNameIn, double priceIn, int stockLevelIn, String measurementIn)
    {

        super(productIdIn, productNameIn, priceIn, stockLevelIn);
        measurement = measurementIn;

    }
    
}
