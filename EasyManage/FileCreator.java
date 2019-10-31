import java.io.*;
import java.lang.*;
import java.util.*;
import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;


/**
 * Write a description of class FileCreator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileCreator
{
    // instance variables - replace the example below with your own

    /**
     * Create a save file from a company class and a directory taken from "new file" or "save file"
     */
    
    private ArrayList<File> departmentList = new ArrayList<File>();
    private File insideDirectory;
    private File directory;
    private Company company;
    
    public FileCreator(Company company, File directory)
    {
        this.directory = directory;
        this.company = company;
    }
    
    public void generateFile()
    {
        if (directory.exists())
        {
            deleteDirectory(directory);
        }
        
        directory.mkdir();
        insideDirectory = new File(directory.getParent() + "\\" + directory.getName() + "\\" + "Departments");
        insideDirectory.mkdir();
        
        for (int i = 0; i<company.getDepartmentsList().size(); i++)
        {
            departmentList.add(new File(directory.getParent() + "\\" + directory.getName() + "\\" + "Departments" + "\\" + company.getDepartmentsList().get(i).getName()));
            departmentList.get(i).mkdir();
            
            company.getDepartmentsList().get(i).createFile(departmentList.get(i));
        }
    }
    
    
    //this method uses recursion
    void deleteDirectory(File file){
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteDirectory(entry);
                    entry.delete();
                }
            }
        }
        else
        {
            file.delete();
        }
    }
}
