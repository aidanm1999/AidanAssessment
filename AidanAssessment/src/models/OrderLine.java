package models;

public class OrderLine {
    
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    private int orderLineId;
    private Product product;
    private int quantity;
    private double lineTotal;
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public int getOrderLineId(){return orderLineId;}
    public Product getProduct(){return product;}
    public int getQuantity(){return quantity;}
    public double getLineTotal(){return lineTotal;}
    
    public void setOrderLineId(int lineId){orderLineId = lineId;}
    public void setProduct(Product productIn){product=productIn;}
    public void setQuantity(int quantityIn){quantity = quantityIn;}
    public void setLineTotal(double total){lineTotal = total;}
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Empty Constructor">
    public OrderLine ()
    {
        orderLineId = 0;
        product = new Product();
        quantity = 0;
        lineTotal = 0;
    }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Overloaded Constructor">
    public OrderLine (Order orderIn, Product productIn, int quantityIn)
    {
        orderLineId = orderIn.generateUniqueOrderLineId();
        product = productIn;
        quantity = quantityIn;
        lineTotal = product.getPrice() * quantity;
    }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Overloaded Constructor">
    public OrderLine (int orderLineIdIn, Product productIn, int quantityIn, double lineTotalIn)
    {
        orderLineId = orderLineIdIn;
        product = productIn;
        quantity = quantityIn;
        lineTotal = lineTotalIn;
    }
    //</editor-fold>
      
}