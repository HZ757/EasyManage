import java.io.*;
import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class EmployeeInfo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EmployeeInfo extends JFrame implements ActionListener
{
    private Employee employee;
    
    private Container container;
    
    private JLabel title;
    private JLabel name;
    private JLabel role;
    private JLabel phoneNumber;
    private JLabel email;
    
    private JTextField newName;
    private JTextField newRole;
    private JTextField newPhoneNumber;
    private JTextField newEmail;
    
    private String nName;
    private String nRole;
    private String nPhoneNumber;
    private String nEmail;
    
    private Integer update = 0;
    
    private JButton save;
    
    private Overview overview;

    /**
     * Constructor for objects of class EmployeeInfo
     */
    public EmployeeInfo(Employee employee, Overview overview)
    {
        this.employee = employee;
        this.overview = overview;
        
        name = new JLabel("Name: " + employee.getName());
        
        newName = new JTextField(7);
        role = new JLabel("Role: " + employee.getRole());
        
        newRole = new JTextField(7);
        phoneNumber = new JLabel("Phone Number: " + employee.getPhoneNumber());
        
        newPhoneNumber = new JTextField(20);
        
        email = new JLabel("Email: " + employee.getEmail());
        
        newEmail = new JTextField(20);
        
        JButton save = new JButton("Save");
        
        setTitle("Employee Overview");
        
        container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        
        container.add(name);
        container.add(new JLabel("New Name:"));
        container.add(newName);
        container.add(role);
        container.add(new JLabel("New Role:"));
        container.add(newRole);
        container.add(phoneNumber);
        container.add(new JLabel("New Phone Number:"));
        container.add(newPhoneNumber);
        container.add(email);
        container.add(new JLabel("New Email:"));
        container.add(newEmail);
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
        nRole = newRole.getText();
        nPhoneNumber = newPhoneNumber.getText();
        nEmail = newEmail.getText();
        
        employee.setName(nName);
        employee.setRole(nRole);
        employee.setPhoneNumber(nPhoneNumber);
        employee.setEmail(nEmail);
        
        setVisible(false);
        
        overview.getFrame().setVisible(false);
        overview.createGUI();
    }
    
    public Employee getEmployee()
    {
        return employee;
    }
    
}
