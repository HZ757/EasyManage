import java.io.*;
import java.awt.* ;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class ChooseFile extends JFrame implements ActionListener
{
    private JLabel title;
    private JButton openFile;
    private JButton newFile;
    
    private JFileChooser fc;
    
    private File file;
    
    public ChooseFile()
    {
        title = new JLabel("EasyManager: Company Manager");
        openFile = new JButton("Open existing file");
        newFile = new JButton("Create New File");
        
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        setTitle("EasyManager");
        Container container = getContentPane();                                 
        container.setLayout(new FlowLayout());
        
        container.add(title);
        container.add(openFile);
        container.add(newFile);
        
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );  
        
        openFile.addActionListener(this);
        newFile.addActionListener(this);
    }
    
    
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() == openFile)
        {
            int returnVal = fc.showOpenDialog(ChooseFile.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                Company company = new Company(file);//where the company is created
                Overview overview = new Overview(company, company.getDepartmentsList().get(0));
                setVisible(false);
            }
        }
        else if (evt.getSource() == newFile)
        {
            newFile gui2 = new newFile();
            gui2.setSize(280,220);
            gui2.setVisible(true);
            setVisible(false);
        }
    }
    
    public static void main ( String[] args ){
          ChooseFile gui = new ChooseFile() ;
          gui.setSize(280, 150);     
          gui.setVisible(true);         
    }   // end of main
}