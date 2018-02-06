
package models;


public class Product 
{
    
    //Attributes
	
    private int productId;
    private String productName;
    private double price;
    private int stockLevel;
      
    @Override
    public String toString()
    {
        return productName;
    }
    
    
    public int getProductId() 
    {
        return productId;
    }

    public String getProductName() 
    {
        return productName;
    }
    
    public double getPrice() 
    {
        return price;
    }
    
    public int getStockLevel() 
    {
        return stockLevel;
    }
    
    
    
    
    public void setProductId(int productIdIn) 
    {
        productIdIn = productId;
    }

    public void setProductName(String productNameIn) 
    {
        productNameIn = productName;
    }

    public void setPrice(double priceIn) 
    {
        priceIn = price;
    }

    public void setStockLevel(int stockLevelIn) 
    {
        stockLevelIn = stockLevel;
    }
        
	


    //Constrictor Method

    public Product()
    {

    productId = 0;
    productName = "";
    price = 0;
    stockLevel = 0;


    }
    
    
    //Overloded 
    
    public Product(int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
    {

    productId = productIdIn;
    productName = productNameIn;
    price = priceIn;
    stockLevel = stockLevelIn;


    }
    
}
