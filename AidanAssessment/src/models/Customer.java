
package models;


public class Customer extends User
{
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    
    
    
    
    public String getAddressLine1() 
    {
        return addressLine1;
    }
    
    public String getAddressLine2() 
    {
        return addressLine2;
    }
    
    public String getTown() 
    {
        return town;
    }
    
    public String getPostcode() 
    {
        return postcode;
    }

    
    
    
    
    
    public void set_address_line_1(String addressLine1In) 
    {
        addressLine1In = addressLine1;
    }
    
    public void setAddressLine_2(String addressLine2In) 
    {
        addressLine2In = addressLine2;
    }

    public void setTown(String townIn) 
    {
        townIn = town;
    }

    public void set_postcode(String postcodeIn) 
    {
        postcodeIn = postcode;
    }
    
    
    
    
  
    
    
    public Customer()
    {
        super();
        
        addressLine1 = "";
        addressLine2 = "";
        town = "";
        postcode = "";

    }
    
    
    public Customer(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn, String addressLine1In, String addressLine2In, String townIn, String postcodeIn)
    {

        super(usernameIn, passwordIn, firstNameIn, lastNameIn);
        
        addressLine1 = addressLine1In;
        addressLine2 = addressLine2In;
        town = townIn;
        postcode = postcodeIn;

    }
}
