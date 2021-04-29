package pro_Library;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import pro_Library.sc.BookInfoSearchTablePanel;
import pro_Library.service.BookInformationService;
import pro_Library.service.ProfileService;
import pro_Library.ui.AbstractManagerUI;
import pro_Library.ui.content.BookInformationContentPanel;
import pro_Library.ui.content.ProMasterContentPanel;
import pro_Library.ui.content.PromepContentPanel;
import pro_Library.ui.list.BookInformationTablePanel;
import pro_Library.ui.list.ProfileTablePanel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Main_guest extends JFrame {

	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	private JLabel main_lb_img;
	private JPanel contentPane;
	private JTable table;

	private BookInformationService service;
	private BookInformationContentPanel bcp;
	private BookInformationTablePanel pbookinfo;
	private BookInfoSearchTablePanel scbook;
	private JTextField textField;

	public Main_guest() {
		setTitle("도서관");
		initialize();
//		createFrame();

	}

	private void initialize() {
		
		// 메인 기본설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// 메인 이미지 삽입 panel
		JPanel main_pn_img = new JPanel();
		contentPane.add(main_pn_img, BorderLayout.EAST);

		JPanel mpi_p = new JPanel();
		main_pn_img.add(mpi_p);
		mpi_p.setLayout(new BorderLayout(0, 0));

		// 메인 이미지 삽입 label
		JLabel main_lb_img = new JLabel("");
		mpi_p.add(main_lb_img);

		main_lb_img.setIcon(new ImageIcon(imgPath + "main_1.png"));
		mpi_p.add(main_lb_img);

		// 테이블붙이기
		BookInformationService service = new BookInformationService();

		pbookinfo = new BookInformationTablePanel();
		pbookinfo.setService(service);
		pbookinfo.loadData();
		contentPane.add(pbookinfo);
		
		JPanel panel = new JPanel();
		pbookinfo.add(panel, BorderLayout.NORTH);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC804\uCCB4\uAC80\uC0C9", "\uB3C4\uC11C\uBC88\uD638", "\uB3C4\uC11C\uC81C\uBAA9", "\uB3C4\uC11C\uBD84\uB958"}));
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(25);
		panel.add(textField);
		
		JButton button = new JButton("\uAC80\uC0C9");
		panel.add(button);

	}

}
