package pro_Library;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import pro_Library.panel.BookInformationPanel;
import pro_Library.panel.ProfilePanel;
import pro_Library.control.ProfileManagement;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import pro_Library.content.BookInformationTablePanel;

@SuppressWarnings("serial")
public class TestFrm extends JFrame{
    public TestFrm() {
    	setTitle("영남인재교육 도서관");
        setSize(800, 600);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        
        JPanel ptab1 = new JPanel();
        tabbedPane.addTab("도서검색", null, ptab1, null);
        ptab1.setLayout(new GridLayout(0, 1, 0, 0));
        
        JPanel panel = new JPanel();
        ptab1.add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        
        BookInformationPanel panel_1 = new BookInformationPanel();
        panel.add(panel_1, BorderLayout.NORTH);
        
        JPanel ptab2 = new JPanel();
        tabbedPane.addTab("대출/반납", null, ptab2, null);
        ptab2.setLayout(new GridLayout(0, 1, 0, 0));
        
        JPanel ptab3 = new JPanel();
        tabbedPane.addTab("회원관리", null, ptab3, null);
        ptab3.setLayout(new GridLayout(0, 1, 0, 0));
        
        JPanel ptab4 = new JPanel();
        tabbedPane.addTab("도서관리", null, ptab4, null);
        setVisible(true);
    }
}