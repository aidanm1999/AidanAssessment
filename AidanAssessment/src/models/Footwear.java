
package models;


public class Footwear extends Product
{
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    private int size;
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public int getSize() { return size; }
    public void setSize(int sizeIn) { size = sizeIn; }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Empty Constructor">
    public Footwear()
    {
        super();
        size = 0;
    }
    //</editor-fold>

    
    // <editor-fold defaultstate="collapsed" desc="Overloaded Constructor">
    public Footwear(int productIdIn, String productNameIn, double priceIn, int stockLevelIn, int sizeIn)
    {
        super(productIdIn, productNameIn, priceIn, stockLevelIn);
        size = sizeIn;
    }
    //</editor-fold>

}
