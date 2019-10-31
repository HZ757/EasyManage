
import java.io.*;
import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;

public class newFile extends JFrame implements ActionListener
{
    private JLabel title;
    private JLabel nameLabel;
    private JLabel departmentLabel;
    
    private JTextField nameField;
    private JTextField departmentField;
    
    private JButton createNewFile;
    
    private String name;
    private String departmentName;
    private JFileChooser fc;
    
    private Company company;
    
    private Overview overview;
    
    public newFile()
    {
        setTitle("Create a New File");
        title = new JLabel("EasyManage: Create a new file");
        nameLabel = new JLabel("Company Name: ");
        departmentLabel = new JLabel("Department name: ");
        
        nameField = new JTextField(20);
        departmentField = new JTextField(20);
        
        createNewFile = new JButton("Create New File");
        fc = new JFileChooser();
        
        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        
        container.add(title);
        container.add(nameLabel);
        container.add(nameField);
        container.add(departmentLabel);
        container.add(departmentField);
        container.add(createNewFile);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        
        createNewFile.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent evt) {
        name = nameField.getText();
        departmentName = departmentField.getText();
        int returnVal = fc.showSaveDialog(newFile.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (!file.exists())
            {
                file.mkdir();
                company = new Company(file, name);
                company.createFile();
                
                company.addDepartment(departmentName);
                 
                overview = new Overview(company, company.getDepartmentsList().get(0));
                
                this.setVisible(false);
            }
            else
                System.out.println("The file already exists, pick a new name");
        }
    }
    
    public static void main (String[] args){
          newFile gui = new newFile();
          gui.setSize( 280, 220 );     
          gui.setVisible( true );         
    }   // end of main
}
