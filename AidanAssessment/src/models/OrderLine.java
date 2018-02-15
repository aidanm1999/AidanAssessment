package models;

public class OrderLine {
    
    private int orderLineId;
    private Product product;
    private int quantity;
    private double lineTotal;
    
    public int getOrderLineId(){return orderLineId;}
    public Product getProduct(){return product;}
    public int getQuantity(){return quantity;}
    public double getLineTotal(){return lineTotal;}
    
    public void setOrderLineId(int lineId){orderLineId = lineId;}
    public void setProduct(Product productIn){product=productIn;}
    public void setQuantity(int quantityIn){quantity = quantityIn;}
    public void setLineTotal(double total){lineTotal = total;}
    
    public OrderLine (Order orderIn, Product productIn)
    {
        orderLineId = orderIn.generateUniqueOrderLineId();
        product = productIn;
        quantity = 1;
        lineTotal = product.getPrice() * quantity;
    }
      
}