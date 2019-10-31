import java.io.*;
import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class DepartmentInfo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DepartmentInfo extends JFrame implements ActionListener
{
    private Department department;
    
    private Container container;
    
    private JLabel name;
    
    private JTextField newName;
    
    private String nName;
    
    private JButton save;
    
    private Overview overview;
    /**
     * Constructor for objects of class EmployeeInfo
     */
    public DepartmentInfo(Department department, Overview overview)
    {
        this.department = department;
        this.overview = overview;
        
        name = new JLabel("Name: " + department.getName());
        newName = new JTextField(7);

        JButton save = new JButton("Save");
        
        setTitle("Department Overview");
        
        container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        
        container.add(name);
        container.add(new JLabel("New Name:"));
        container.add(newName);
        container.add(save);
        
        
        save.addActionListener(this);
    }
    
    public void createGUI(Employee employee)
    {
        EmployeeInfo gui = new EmployeeInfo(employee, overview);
        gui.setSize(280, 600);     
        gui.setVisible(true); 
    }
    
    public void actionPerformed(ActionEvent evt) {
        nName = newName.getText();
        
        department.setName(nName);
        
        setVisible(false);
        
        overview.getFrame().setVisible(false);
        overview.createGUI();
    }
    
    public Department getDepartment()
    {
        return department;
    }
}
