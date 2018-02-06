package models;


public class User 
{
	

    //Attributes
	
    private String username;
    private String password;
    private String firstName;
    private String lastName;
      
    
    
    
    public String getUsername() 
    {
        return username;
    }

    public String getPassword() 
    {
        return password;
    }
    
    public String getFirstName() 
    {
        return firstName;
    }
    
    public String getLastName() 
    {
        return lastName;
    }
    
    
    
    
    public void setUsername(String usernameIn) 
    {
        usernameIn = username;
    }

    public void setPassword(String passwordIn) 
    {
        passwordIn = password;
    }

    public void setFirstName(String firstNameIn) 
    {
        firstNameIn = firstName;
    }

    public void setLastName(String lastNameIn) 
    {
        lastNameIn = lastName;
    }
        
	


    //Constrictor Method

    public User()
    {

    username = "";
    password = "";
    firstName = "";
    lastName = "";


    }
    
    
    //Overloded 
    
    public User(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn)
    {

    username = usernameIn;
    password = passwordIn;
    firstName = firstNameIn;
    lastName = lastNameIn;


    }
    
}