package models;

public class Staff extends User
{
    // <editor-fold defaultstate="collapsed" desc="Attributes">
    private double salary;
    private String position;
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public double getSalary() { return salary; }
    public void setSalary(double salaryIn) { salaryIn = salary; }
    
    public String getPosition() { return position; }
    public void setPosition(String positionIn) { positionIn = position; }
    //</editor-fold>

    
    // <editor-fold defaultstate="collapsed" desc="Empty Constructor">
    public Staff()
    {
        super();
        salary = 0;
        position = "";
    }
    //</editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Overloaded Constructor">
    public Staff(String usernameIn, String passwordIn, String firstNameIn, String lastNameIn, String positionIn, double salaryIn)
    {
        super(usernameIn, passwordIn, firstNameIn, lastNameIn); 
        salary = salaryIn;
        position = positionIn;
    }
    //</editor-fold>
}
