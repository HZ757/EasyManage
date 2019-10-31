import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

/**
 * Write a description of class Task here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Task
{
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    private String name; 
    private String description;
    private String status;
    private Date deadline;
    private String fileSeparator = System.getProperty("file.separator");
    private File directory; //this is the directory of the txt file containing the info
    private Date currentDate = new Date();
    
    public Task()
    {
        name = "undefined";
        description = "undefined";
        status = "undefined";
        deadline = new Date();
    }
    
    public Task(String name, String description, Date deadline)
    {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
    }
    
    public Task(File file)//create from a text file
    {
        try
        {
            FileReader fileReader = new FileReader(file.getParent() + fileSeparator + file.getName());
            BufferedReader br = new BufferedReader(fileReader);
            
            name = br.readLine();
            description = br.readLine();
            deadline = dateFormat.parse(br.readLine());
            status = br.readLine();
            
            br.close();
        }
        catch (Exception E)
        {
            System.out.println(E);
        }
    }
    
    public void createFile(File directory, int id)
    {
        try
        {
            PrintWriter writer = new PrintWriter(directory.getParent() + fileSeparator + directory.getName() + fileSeparator + "task" + id + ".txt", "UTF-8");
            writer.println(name);
            writer.println(description);
            writer.println(getDeadline());
            writer.println(status);
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getDeadline()
    {
        String deadline = dateFormat.format(this.deadline);
        return deadline;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setName(String s)
    {
        name = s;
    }
    
    public void setDescription(String s)
    {
        description = s;
    }
    
    public void setDeadline(String s)
    {
        try
        {
            deadline = dateFormat.parse(s);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void setStatus(String s)
    {
        status = s;
    }
}
