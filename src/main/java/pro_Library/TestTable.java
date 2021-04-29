package pro_Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pro_Library.sc.BookInfoSearchTablePanel;
import pro_Library.ui.list.BookDeinfoTablePanel;

@SuppressWarnings("serial")
public class TestTable extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestTable frame = new TestTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TestTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		BookDeinfoTablePanel plist = new BookDeinfoTablePanel();
		contentPane.add(plist, BorderLayout.NORTH);
		
		BookInfoSearchTablePanel ppanel = new BookInfoSearchTablePanel();
		contentPane.add(ppanel, BorderLayout.CENTER);
	}

}
