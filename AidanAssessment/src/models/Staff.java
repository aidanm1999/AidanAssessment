package models;

public class Staff extends User
{
    private double salary;
    private String position;

    
    
    
    
    public double get_salary() 
    {
        return salary;
    }
    
    public String get_position() 
    {
        return position;
    }
    


    
    
    
    
    
    public void set_salary(double salary_in) 
    {
        salary_in = salary;
    }
    
    public void set_address_line_2(String position_in) 
    {
        position_in = position;
    }
    
    
    
    
  
    
    
    public Staff()
    {
        super();
        
        salary = 0;
        position = "";

    }
    
    
    public Staff(String username_in, String password_in, String first_name_in, String last_name_in, String position_in, double salary_in)
    {

        super(username_in, password_in, first_name_in, last_name_in);
        
        salary = salary_in;
        position = position_in;


    }
}
