import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;

public class Company
{
    private File directory; 
    private ArrayList<Department> departmentsList = new ArrayList<Department>();
    private String fileSeparator = System.getProperty("file.separator");
    private String name;
    public Company(File directory, String name)
    {
        this.directory = directory;
        name = name;
    }
    
    public Company(File directory)
    {
        this.directory = directory;
        File[] directories = directory.listFiles(File::isDirectory);
        for (int i = 0; i<directories.length; i++)
        {
            if (directories[i].getName().equals("Departments"))
            {
                File[] departments = directories[i].listFiles(File::isDirectory);
                
                for(int j = 0; j<departments.length; j++)
                { 
                    departmentsList.add(new Department(departments[j]));
                }
            }
        }
    }
    public void createFile()
    {
        FileCreator fileCreator = new FileCreator(this, directory);
        fileCreator.generateFile();
    }
    
    public ArrayList<Department> getDepartmentsList()
    {
        return departmentsList;
    }
    
    public File getDirectory()
    {
        return directory;
    }
    
    public void addDepartment(String department)
    {
        departmentsList.add(new Department());
        departmentsList.get(departmentsList.size()-1).setName(department);
    }
}
