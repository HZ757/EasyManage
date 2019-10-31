import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;
import java.lang.*;
import java.text.*;

public class Overview extends JFrame implements ActionListener
{
    private Company company;
    private Department department;
    
    private JFrame frame;
    
    private JMenuBar menuBar;
    
    private JMenu file;
    private JMenuItem saveFile;
    private JMenuItem saveExistingFile;
    
    
    private JButton editDepartment; //editing department
    
    private JButton newDepartment;//button new department
    
    private JButton newTask; //button new task
    
    private JButton newEmployee; //button new employee
    
    private JButton refresh; //button to refresh page
    
    
    private ArrayList<JButton> departmentButtonList = new ArrayList<JButton>();
    private ArrayList<JButton> departmentButtonOpenList = new ArrayList<JButton>();
    private ArrayList<JButton> departmentButtonRemoveList = new ArrayList<JButton>();
    
    private ArrayList<JButton> taskButtonList = new ArrayList<JButton>();
    private ArrayList<JButton> taskButtonCompleteList = new ArrayList<JButton>();
    
    private ArrayList<JButton> employeeButtonList = new ArrayList<JButton>();
    private ArrayList<JButton> employeeButtonRemoveList = new ArrayList<JButton>();
    
    private JPanel p;
    
    //indicates which department's tasks and employees are about to be shown
    private int departmentNum = 0;
    
    
    public JPanel departmentOverview(Department department)
    {
        JPanel overview = new JPanel();
        JLabel name = new JLabel("Department: " + department.getName()); //fix this
        
        departmentButtonList.add(new JButton("Edit"));    
        departmentButtonList.get(departmentButtonList.size()-1).addActionListener(this);
        
        departmentButtonOpenList.add(new JButton("Open"));        
        departmentButtonOpenList.get(departmentButtonOpenList.size()-1).addActionListener(this);
        
        departmentButtonRemoveList.add(new JButton("Delete"));        
        departmentButtonRemoveList.get(departmentButtonRemoveList.size()-1).addActionListener(this);
        
        JLabel blank = new JLabel("   ");
        overview.setLayout(new BoxLayout(overview, BoxLayout.PAGE_AXIS));
        overview.add(name);
        overview.add(departmentButtonList.get(departmentButtonList.size() - 1));
        overview.add(departmentButtonOpenList.get(departmentButtonOpenList.size()-1));
        overview.add(departmentButtonRemoveList.get(departmentButtonRemoveList.size()-1));
        overview.add(blank);
        
        return overview;
    }
    
    public JPanel taskOverview(Task task)
    {
        JPanel overview = new JPanel();
        JLabel name = new JLabel("Task: " + task.getName());
        JLabel description = new JLabel("<html>" + "Description: " + task.getDescription() + "</html>");
        JLabel deadline = new JLabel("Deadline: " + task.getDeadline());
        JLabel status = new JLabel("Status: " + task.getStatus());
        taskButtonList.add(new JButton("Edit"));
        
        taskButtonList.get(taskButtonList.size()-1).addActionListener(this);
        
        taskButtonCompleteList.add(new JButton("Complete"));
        
        taskButtonCompleteList.get(taskButtonCompleteList.size()-1).addActionListener(this);
        
        overview.setLayout(new BoxLayout(overview, BoxLayout.PAGE_AXIS));
        overview.add(name);
        overview.add(description);
        overview.add(deadline);
        overview.add(status);
        overview.add(taskButtonList.get(taskButtonList.size()-1));
        overview.add(taskButtonCompleteList.get(taskButtonCompleteList.size()-1));
        return overview;
    }
    
    public JPanel employeeOverview(Employee employee)
    {
        JPanel overview = new JPanel();
        overview.setLayout(new BoxLayout(overview, BoxLayout.PAGE_AXIS));
        JLabel name = new JLabel("Name: " + employee.getName());
        JLabel role = new JLabel("Role: " + employee.getRole());
        JLabel phoneNumber = new JLabel("Phone #: " + employee.getPhoneNumber());
        JLabel email = new JLabel("Email: " + employee.getEmail());
        employeeButtonList.add(new JButton("Edit"));
        employeeButtonRemoveList.add(new JButton("Remove"));
        
        employeeButtonList.get(employeeButtonList.size()-1).addActionListener(this);
        employeeButtonRemoveList.get(employeeButtonList.size()-1).addActionListener(this);
        
        overview.add(name);
        overview.add(role);
        overview.add(phoneNumber);
        overview.add(email);
        overview.add(employeeButtonList.get(employeeButtonList.size()-1));
        overview.add(employeeButtonRemoveList.get(employeeButtonList.size()-1));
        overview.add(new JLabel("\n"));
        return overview;
    }
    
    /**
     * Constructor for objects of class Overview
     */
    public Overview(Company company, Department department)
    {
        this.company = company;
        this.department = department;
        createGUI();
    }
    
    public void createGUI()
    {
        
        frame = new JFrame("Menu");
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        departmentButtonList.clear();
        departmentButtonOpenList.clear();
        departmentButtonRemoveList.clear();
        taskButtonList.clear();
        taskButtonCompleteList.clear();
        employeeButtonList.clear();
        employeeButtonRemoveList.clear();
        
        //MENUBAR-----------------------------------------------------------------
        menuBar = new JMenuBar();
        
        file = new JMenu("File");
        menuBar.add(file);
        //exit = new JMenuItem("Exit");
        saveFile = new JMenuItem("Save as");
        saveExistingFile = new JMenuItem("Save");
        //file.add(exit);
        file.add(saveFile);
        file.add(saveExistingFile);
        
        frame.setJMenuBar(menuBar);
        //--------------------------------------------------------------------------
        saveFile.addActionListener(this);
        saveExistingFile.addActionListener(this);
        //DEPARTMENT OVERVIEW-LEFT SIDE GUI------------------------------------------------------
        p = new JPanel();
        frame.add(p, BorderLayout.WEST);
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setBorder(BorderFactory.createLineBorder(Color.black));//change later
        
        for(int i = 0; i<company.getDepartmentsList().size(); i++)
        {
            p.add(departmentOverview(company.getDepartmentsList().get(i)));
        }
        
        p.add(new JLabel(" "));
        
        newDepartment = new JButton("Create Department");
        p.add(new JLabel("\n"));
        p.add(newDepartment);
        
        p.add(new JLabel("\n"));
        refresh = new JButton("Refresh Overview");
        p.add(refresh);
        
        newDepartment.addActionListener(this);
        refresh.addActionListener(this);
        
        //DEPARTMENT OVERVIEW CENTRE, TASK OVERVIEW
        JPanel j = new JPanel();
        j.setLayout(new BoxLayout(j, BoxLayout.PAGE_AXIS));
        j.setBorder(BorderFactory.createLineBorder(Color.black));
        j.add(new JLabel("Department: " + company.getDepartmentsList().get(departmentNum).getName())); //change this shiet late
        j.add(new JLabel("\n"));
        
        
        for (int i = 0; i < department.getTaskList().size(); i++)
        {
                j.add(taskOverview(company.getDepartmentsList().get(departmentNum).getTaskList().get(i)));
                j.add(new JLabel("\n"));
        }
        
        
        
        newTask = new JButton("New Task");
        editDepartment = new JButton("Edit Department");
        
        newTask.addActionListener(this);
        editDepartment.addActionListener(this);
        
        j.add(newTask);
        
        
        frame.add(j, BorderLayout.CENTER);
        
        //DEPEARTMENT OVERVIEW RIGHT, EMPLOYEE OVERVIEW
        JPanel k = new JPanel();
        k.setLayout(new BoxLayout(k, BoxLayout.PAGE_AXIS));
        k.setBorder(BorderFactory.createLineBorder(Color.black));
        k.add(new JLabel("Employees"));
        k.add(new JLabel("\n"));
        
        for (int i = 0; i < department.getEmployeeList().size(); i++)
        {
            //FIXLater
            k.add(employeeOverview(company.getDepartmentsList().get(departmentNum).getEmployeeList().get(i)));
            k.add(new JLabel("\n"));
        }
        
        k.add(new JLabel("\n"));
        
        newEmployee = new JButton("New Employee");
        k.add(newEmployee);
        
        newEmployee.addActionListener(this);
        
        frame.add(k, BorderLayout.EAST);        
    }
    
    public JFrame getFrame()
    {
        return frame;
    }
    
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<employeeButtonList.size(); i++)
        {
            if (e.getSource() == employeeButtonList.get(i))
            {
                EmployeeInfo gui = new EmployeeInfo(department.getEmployeeList().get(i), this);
                gui.setSize(280, 600);
                gui.setVisible(true);
            }
        }
        
        for (int i = 0; i<employeeButtonRemoveList.size(); i++)
        {
            if (e.getSource() == employeeButtonRemoveList.get(i))
            {
                frame.setVisible(false);
                department.getEmployeeList().remove(i);
                createGUI();
            }
        }
        
        for (int i = 0; i<taskButtonList.size(); i++)
        {
            if (e.getSource() == taskButtonList.get(i))
            {
                //System.out.println("Task TEST");
                TaskInfo taskGUI = new TaskInfo(department.getTaskList().get(i), this);
                taskGUI.setSize(500, 600);     
                taskGUI.setVisible(true); 
            }
        }
        
        for (int i = 0; i<taskButtonCompleteList.size(); i++)
        {
            if (e.getSource() == taskButtonCompleteList.get(i))
            {
                frame.setVisible(false);
                department.getTaskList().remove(i);
                createGUI();
            }
        }
        
        for (int i = 0; i<departmentButtonList.size(); i++)
        {
            if (e.getSource() == departmentButtonList.get(i))
            {
                //System.out.println("Task TEST");
                DepartmentInfo departmentGUI = new DepartmentInfo(company.getDepartmentsList().get(i), this);
                departmentGUI.setSize(280, 200);     
                departmentGUI.setVisible(true); 
            }
        }
        
        for (int i = 0; i<departmentButtonOpenList.size(); i++)
        {
            if (e.getSource() == departmentButtonOpenList.get(i))
            {
                frame.setVisible(false);
                departmentNum = i;
                
                department = company.getDepartmentsList().get(i);
                createGUI();
                
            }
        }
        
        for (int i = 0; i<departmentButtonRemoveList.size(); i++)
        {
            if (e.getSource() == departmentButtonRemoveList.get(i))
            {
                frame.setVisible(false);
                company.getDepartmentsList().remove(i);
                createGUI();
            }
        }
        
        if (e.getSource() == refresh)
        {
            frame.setVisible(false);
            createGUI();
        }
        
        if(e.getSource() == saveFile)
        {
            FileSelector fileSelector = new FileSelector();
            FileCreator fileCreator = new FileCreator(company, fileSelector.getFile());
            fileCreator.generateFile();
        }
        
        if(e.getSource() == saveExistingFile)
        {
            
            FileCreator fileCreator2 = new FileCreator(company, company.getDirectory());
            
            fileCreator2.generateFile();
            
        }
        
        if(e.getSource() == newDepartment)
        {
            company.getDepartmentsList().add(new Department());
            DepartmentInfo departmentGUI = new DepartmentInfo(company.getDepartmentsList().get(company.getDepartmentsList().size()-1), this);
            departmentGUI.setSize(280, 200);     
            departmentGUI.setVisible(true); 
        }
        if(e.getSource() == newTask)
        {
            department.getTaskList().add(new Task());
            TaskInfo taskGUI = new TaskInfo(department.getTaskList().get(department.getTaskList().size()-1), this);
            taskGUI.setSize(500, 600);     
            taskGUI.setVisible(true); 
        }
        if(e.getSource() == newEmployee)
        {
            department.getEmployeeList().add(new Employee());
            EmployeeInfo employeeGUI = new EmployeeInfo(department.getEmployeeList().get(department.getEmployeeList().size()-1), this);
            employeeGUI.setSize(500, 600);     
            employeeGUI.setVisible(true); 
        }
    }
    
}
