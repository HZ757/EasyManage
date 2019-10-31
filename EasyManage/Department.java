import java.util.*;
import java.lang.*;
import java.io.*;

public class Department
{
    private String name;
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private File directory;
    private File employeesFile;//directory conatining employee info
    private File tasksFile;//directory containing task info
    public Department() 
    {
        name = "unnamed department";
    }
    
    public Department(File directory)//This one is for creating the class from the file
    {
        
        File[] directories = directory.listFiles(File::isDirectory);
        name = directory.getName();
        for (int i = 0; i<directories.length; i++)
        {
            if (directories[i].getName().equals("Employees"))
            {
                employeesFile = directories[i];
                
            }
            else if (directories[i].getName().equals("Tasks"))
            {
                tasksFile = directories[i];
            }
        }
        
        File[] employeesDirectories = employeesFile.listFiles(); //getting all the textfiles in the employees directory
        
        for (int i = 0; i < employeesDirectories.length; i++)
        {
            employees.add(new Employee(employeesDirectories[i]));
        }
        
        File[] tasksDirectories = tasksFile.listFiles(); //getting all the textfiles in the tasks directory
        for (int i = 0; i < tasksDirectories.length; i++)
        {
            tasks.add(new Task(tasksDirectories[i]));
        }
        
    }
    
    public Department(File directory, String name)  //This one is for creating one from scratch using GUI
    {
        this.directory = directory;
        name = name;
        employees.add(new Employee());
    }
    
    public void addEmployee(String name, String department, String role, String phoneNumber, String email)
    {
        employees.add(new Employee(name, department, role, phoneNumber, email) );
        employees.get(employees.size()-1).createFile(directory, employees.size());//probably directory wrong, check
        
        //add to the file
    }
    
    public void createFile(File directory)
    {
        File directoryTask = new File(directory.getParent() + "\\" + directory.getName() + "\\" + "Tasks");
        File directoryEmployees = new File(directory.getParent() + "\\" + directory.getName() + "\\" + "Employees");
        directoryTask.mkdir();
        directoryEmployees.mkdir();
        
        for (int i = 0; i<employees.size(); i++)
        {
            employees.get(i).createFile(directoryEmployees, i);
        }
        for (int i = 0; i<tasks.size(); i++)
        {
            tasks.get(i).createFile(directoryTask, i);
        }
    }
    
    
    //Accesor methods
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public ArrayList<Task> getTaskList()
    {
        return tasks;
    }
    
    public ArrayList<Employee> getEmployeeList()
    {
        return employees;
    }
}
