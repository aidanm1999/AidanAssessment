
package models;



public class Product 
{
    
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    private int productId;
    private String productName;
    private double price;
    private int stockLevel;
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    @Override
    public String toString() { return productName; }
    
    
    public int getProductId() { return productId; }
    public void setProductId(int productIdIn) { productId = productIdIn; }

    public String getProductName() { return productName; }
    public void setProductName(String productNameIn) { productName = productNameIn; }
    
    public double getPrice() { return price; }
    public void setPrice(double priceIn) { price = priceIn; }
    
    public int getStockLevel() { return stockLevel; }
    public void setStockLevel(int stockLevelIn) { stockLevel = stockLevelIn; }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Empty Constructor">
    public Product()
    {
        productId = 0;
        productName = "";
        price = 0;
        stockLevel = 0;
    }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Overloaded Constructor">
    public Product(int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
    {
        productId = productIdIn;
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;
    }
    //</editor-fold>
    
}
