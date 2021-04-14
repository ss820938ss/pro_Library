package pro_Library;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import pro_Library.panel.BookInformationPanel;

@SuppressWarnings("serial")
public class TestFrm extends JFrame{
    public TestFrm() {
    	setTitle("영남인재교육 도서관");
        setSize(800, 600);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        getContentPane().add(tabbedPane, BorderLayout.NORTH);
        
        JPanel ptab1 = new JPanel();
        tabbedPane.addTab("도서검색", null, ptab1, null);
        ptab1.setLayout(new GridLayout(0, 1, 0, 0));
        
        BookInformationPanel ptab1_1 = new BookInformationPanel();
        ptab1.add(ptab1_1);
        
        JPanel ptab2 = new JPanel();
        tabbedPane.addTab("대출/반납", null, ptab2, null);
        ptab2.setLayout(new GridLayout(0, 1, 0, 0));
        
        JPanel ptab2_1 = new JPanel();
        ptab2.add(ptab2_1);
        
        JPanel ptab3 = new JPanel();
        tabbedPane.addTab("회원관리", null, ptab3, null);
        ptab3.setLayout(new GridLayout(0, 1, 0, 0));
        
        JPanel ptab3_1 = new JPanel();
        ptab3.add(ptab3_1);
        
        JPanel ptab4 = new JPanel();
        tabbedPane.addTab("도서관리", null, ptab4, null);
        
        JPanel ptab4_1 = new JPanel();
        ptab4.add(ptab4_1);
        setVisible(true);
    }
}