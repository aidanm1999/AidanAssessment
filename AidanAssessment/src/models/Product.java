
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
        productId = productIdIn;
    }

    public void setProductName(String productNameIn) 
    {
        productName = productNameIn;
    }

    public void setPrice(double priceIn) 
    {
        price = priceIn;
    }

    public void setStockLevel(int stockLevelIn) 
    {
        stockLevel = stockLevelIn;
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
