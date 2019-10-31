import java.io.*;
import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Person
{
    private String name;
    private String department;
    private String role;
    private String phoneNumber;
    private String email;
    private String fileSeparator = System.getProperty("file.separator");
    
    public Person()
    {
        name = "undefined";
        department = "undefined";
        role = "undefined";
        phoneNumber = "undefined";
        email = "undefined";
    }
    
    public Person(String name)
    {
        this.name = name;
        department = "undefined";
        role = "undefined";
        phoneNumber = "undefined";
        email = "undefined";
    }
    
    public Person (String name, String department, String role, String phoneNumber, String email)
    {
        this.name = name;
        this.department = department;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getRole()
    {
        return role;
    }
    
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setName(String s)
    {
        name = s;
    }
    
    public void setRole(String s)
    {
        role = s;
    }
    
    public void setPhoneNumber(String s)
    {
        phoneNumber = s;
    }
    
    public void setEmail(String s)
    {
        email = s;
    }
    
    public void createFile(File directory, int id) //creates a directory
    {
        try
        {
            PrintWriter writer = new PrintWriter(directory.getParent() + fileSeparator + directory.getName() + fileSeparator + "employee" + id + ".txt", "UTF-8");
            writer.println(name);
            writer.println(department);
            writer.println(role);
            writer.println(phoneNumber);
            writer.println(email);
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println("an exception has occured");
        }
    }
    public Person(File file)
    {
        try
        {//works
            FileReader fileReader = new FileReader(file.getParent() + fileSeparator + file.getName());
            BufferedReader br = new BufferedReader(fileReader);
            
            name = br.readLine();
            department = br.readLine();
            role = br.readLine();
            phoneNumber = br.readLine();
            email = br.readLine();
            
            br.close();
        }
        catch(Exception E) //Add more specific exceptions
        {
            System.out.println("An Exception has occured");
        }
    }
}
