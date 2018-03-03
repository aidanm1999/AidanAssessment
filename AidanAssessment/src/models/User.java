package models;


public class User 
{

    // <editor-fold defaultstate="collapsed" desc="Attributes">
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getUsername() { return username; }
    public void setUsername(String usernameIn) { usernameIn = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String passwordIn) { passwordIn = password; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstNameIn) { firstNameIn = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastNameIn) { lastNameIn = lastName; }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Empty Constructor">
    public User()
    {
        username = "";
        password = "";
        firstName = "";
        lastName = "";
    }
    //</editor-fold>
    
     
    // <editor-fold defaultstate="collapsed" desc="Overloaded Construtor">
    public User(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn)
    {
        username = usernameIn;
        password = passwordIn;
        firstName = firstNameIn;
        lastName = lastNameIn;
    }
    //</editor-fold>
}