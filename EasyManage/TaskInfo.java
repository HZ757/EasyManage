import java.io.*;
import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class TaskInfo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TaskInfo extends JFrame implements ActionListener
{
    private Task task;
    
    private Container container;
    
    private JLabel name;
    private JLabel description;
    private JLabel status;
    private JLabel deadline;
    
    
    private JTextField newName;
    private JTextField newDescription;
    private JTextField newStatus;
    private JTextField newDeadline;
    
    private String nName;
    private String nDescription;
    private String nStatus;
    private String nDeadline;
    
    
    private JButton save;
    
    private Overview overview;

    /**
     * Constructor for objects of class TaskInfo
     */
    public TaskInfo(Task task, Overview overview)
    {
        this.task = task;
        this.overview = overview;
        
        name = new JLabel("Name: " + task.getName());
        newName = new JTextField(7);
        newName.setText(task.getName());
        
        description = new JLabel("Description: " + task.getDescription());
        newDescription = new JTextField(7);
        newDescription.setText(task.getDescription());
        
        status = new JLabel("Status: " + task.getStatus());
        newStatus = new JTextField(7);
        newStatus.setText(task.getStatus());
        
        deadline = new JLabel("Deadline: " + task.getDeadline());
        newDeadline = new JTextField(7);
        newDeadline.setText(task.getDeadline());
        
        JButton save = new JButton("Save");
        newDeadline.setText(task.getDeadline());
        
        setTitle("Task Overview");
        
        container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        
        container.add(name);
        container.add(newName);
        container.add(description);
        container.add(newDescription);
        container.add(status);
        container.add(newStatus);
        container.add(deadline);
        container.add(newDeadline);
        container.add(save);
        
        save.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent evt) {
        nName = newName.getText();
        nDescription = newDescription.getText();
        nStatus = newStatus.getText();
        nDeadline = newDeadline.getText();
        
        task.setName(nName);
        task.setDescription(nDescription);
        task.setStatus(nStatus);
        task.setDeadline(nDeadline);
        
        setVisible(false);
        
        overview.getFrame().setVisible(false);
        overview.createGUI();
    }
    
}
