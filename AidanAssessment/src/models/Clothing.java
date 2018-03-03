
package models;


public class Clothing extends Product
{
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    private String measurement;
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getMeasurement() { return measurement; }
    public void setMeasurement(String measurementIn) { measurement = measurementIn; }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Empty Constructor">
    public Clothing()
    {
        super();
        measurement = "";
    }
    //</editor-fold>

    
    // <editor-fold defaultstate="collapsed" desc="Overloaded Constructor">
    public Clothing(int productIdIn, String productNameIn, double priceIn, int stockLevelIn, String measurementIn)
    {
        super(productIdIn, productNameIn, priceIn, stockLevelIn);
        measurement = measurementIn;
    }
    //</editor-fold>

}
