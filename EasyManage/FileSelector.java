import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;

public class FileSelector extends JFrame
{
    private JButton open = new JButton();
    private JFileChooser fc = new JFileChooser();
    private File file;
    
    public FileSelector()
    {
        fc.setDialogTitle("Save As");
        if (fc.showSaveDialog(open) == JFileChooser.APPROVE_OPTION)
        {
        }
        file = fc.getSelectedFile();
    }
    
    public File getFile()
    {
        return file;
    }
}
