import java.util.*;
import java.lang.*;
import java.io.*;

public class Employee extends Person
{
    public Employee()
    {
        super();
    }
    
    public Employee(String name, String department, String role, String phoneNumber, String email)
    {
        super(name, department, role, phoneNumber, email);
    }
    
    public Employee(String name)
    {
        super(name);
    }
    
    public Employee(File file)
    {
        super(file);
    }
    
}
