package pro_Library;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pro_Library.service.BookDeinfoService;
import pro_Library.service.BookInformationService;
import pro_Library.service.ProfileService;
import pro_Library.ui.AbstractManagerUI;
import pro_Library.ui.content.BookInformationContentPanel;
import pro_Library.ui.content.ProMasterContentPanel;
import pro_Library.ui.content.PromepContentPanel;
import pro_Library.ui.list.BookInformationTablePanel;
import pro_Library.ui.list.ProfileTablePanel;
import pro_Library.ui.panel.BookDeinfoContentPanel;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Main_master extends JFrame {

	private JPanel contentPane;
	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	
	// 도서관리
	private BookInformationService serviceb;
	private BookInformationContentPanel bcp;
	private BookInformationTablePanel pbookinfo;
	private BookInformationTablePanel pbookinfo_1;
	
	// 회원관리
	private JTable table;
	private ProfileService servicep;
	private ProfileTablePanel prop;
	private ProMasterContentPanel pbcp;
	private AbstractManagerUI abm;
	private PromepContentPanel pmcp;
	private JTextField textField;
	
	// 도서검색
	private BookDeinfoContentPanel bdinfop;
	private BookDeinfoService bdservice;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_master frame = new Main_master();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// 관리자화면
	public Main_master() {
		BookInformationService serviceb = new BookInformationService();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		JTabbedPane tabmaster = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabmaster, BorderLayout.NORTH);
		
		// 도서검색 탭
		JPanel psch = new JPanel();
		tabmaster.addTab("--\uB3C4\uC11C\uAC80\uC0C9--", null, psch, null);
		psch.setLayout(new BorderLayout(0, 0));
		
		JPanel p_scm = new JPanel();
		psch.add(p_scm);
		p_scm.setLayout(new BorderLayout(0, 0));
		
		JPanel p_sc_con = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p_sc_con.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		p_scm.add(p_sc_con, BorderLayout.NORTH);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--도서검색--", "--대출/반납--", "--도서등록/관리--", "--회원관리--", "--관리자설정--"}));
		p_sc_con.add(comboBox);
		
		textField = new JTextField();
		p_sc_con.add(textField);
		textField.setColumns(20);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		p_sc_con.add(btnNewButton);
		
		JPanel p_sc_list = new JPanel();
		p_scm.add(p_sc_list, BorderLayout.CENTER);
		p_sc_list.setLayout(new BorderLayout(0, 0));
		
		pbookinfo = new BookInformationTablePanel();
		pbookinfo.setService(serviceb);
		pbookinfo.loadData();
		p_sc_list.add(pbookinfo, BorderLayout.NORTH);
		
		
		bdinfop = new BookDeinfoContentPanel();
		bdinfop.setService(bdservice);
		bdinfop.loadData();
		p_sc_list.add(bdinfop);
		
		JPanel p_m1tab1 = new JPanel();
		psch.add(p_m1tab1, BorderLayout.EAST);
		
		JLabel lblmt_img1 = new JLabel("");
		p_m1tab1.add(lblmt_img1);
		
		lblmt_img1.setIcon(new ImageIcon(imgPath + "main_3.jpg"));
		p_m1tab1.add(lblmt_img1);
		
		// 도서관리 탭		
		JPanel pbook = new JPanel();
		tabmaster.addTab("--\uB3C4\uC11C\uB4F1\uB85D/\uAD00\uB9AC--", null, pbook, null);
		pbook.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel p_bm = new JPanel();
		pbook.add(p_bm);
		p_bm.setLayout(new BorderLayout(0, 0));
		
		pbookinfo_1 = new BookInformationTablePanel();
		pbookinfo_1.setService(serviceb);
		pbookinfo_1.loadData();
		p_bm.add(pbookinfo_1, BorderLayout.NORTH);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "\uB3C4\uC11C\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pbookinfo_1.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new GridLayout(4, 8, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("\uB3C4\uC11C\uBC88\uD638");
		panel_5.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		panel_5.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("\uB3C4\uC11C\uC81C\uBAA9");
		panel_5.add(lblNewLabel_3_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_5.add(textField_5);
		
		JLabel lblNewLabel_3_2 = new JLabel("\uB3C4\uC11C\uAD6C\uBD84");
		panel_5.add(lblNewLabel_3_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_5.add(textField_6);
		
		JButton btnNewButton_3 = new JButton("\uD45C\uC9C0\uC5C5\uB85C\uB4DC");
		panel_5.add(btnNewButton_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "\uD45C\uC9C0", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel_6.add(lblNewLabel_4);
		
		lblNewLabel_4.setIcon(new ImageIcon(imgPath + "b3.jpg"));
		panel_6.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		p_bm.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_5 = new JButton("\uCD94\uAC00");
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("\uCDE8\uC18C");
		panel_1.add(btnNewButton_4);
		
		// 대출 반납 탭
		JPanel prental = new JPanel();
		tabmaster.addTab("--\uB300\uCD9C/\uBC18\uB0A9--", null, prental, null);
		prental.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel p_rtm = new JPanel();
		prental.add(p_rtm);
		p_rtm.setLayout(new BorderLayout(0, 0));
		
		JPanel p_br_list = new JPanel();
		p_rtm.add(p_br_list, BorderLayout.NORTH);
		
		pbookinfo = new BookInformationTablePanel();
		pbookinfo.setService(serviceb);
		pbookinfo.loadData();
		p_br_list.setLayout(new BorderLayout(0, 0));
		p_br_list.add(pbookinfo);
		
		JPanel p_br_con = new JPanel();
		p_rtm.add(p_br_con, BorderLayout.CENTER);
		
		JPanel p_br_od = new JPanel();
		p_rtm.add(p_br_od, BorderLayout.SOUTH);
		
		// 회원관리 탭
		ProfileService servicep = new ProfileService();
		
		JPanel ppro = new JPanel();
		tabmaster.addTab("--\uD68C\uC6D0\uAD00\uB9AC--", null, ppro, null);
		ppro.setLayout(new GridLayout(0, 1, 0, 0));
				
		JPanel p_mem = new JPanel();
		ppro.add(p_mem);
		p_mem.setLayout(new BorderLayout(0, 0));
		
		// 회원 리스트
		prop = new ProfileTablePanel();
		prop.setService(servicep);
		prop.loadData();
		p_mem.add(prop);
		
		// 회원추가 
		JPanel p_mem_con = new JPanel();
		p_mem.add(p_mem_con, BorderLayout.NORTH);
		p_mem_con.setLayout(new BorderLayout(0, 0));
		
		// 회원목록 폼
		pbcp = new ProMasterContentPanel();
		pbcp.setService(servicep);
		pbcp.loadData();
		p_mem_con.add(pbcp);
		
		JPanel panel = new JPanel();
		p_mem_con.add(panel, BorderLayout.SOUTH);
		
		// 회원추가버튼
		JPanel p_mbt = new JPanel();
		p_mem.add(p_mbt, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("\uC218\uC815");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnNewButton_1) {
					actionPerformedbtnNewButton_1(e);
				}
			}

			private void actionPerformedbtnNewButton_1(ActionEvent e) {
//				ProfileManagerUI frame = new ProfileManagerUI();
//				frame.setVisible(true);
				
			}
		});
		p_mbt.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uCDE8\uC18C");
		p_mbt.add(btnNewButton_2);


		//현재 선택된  회원의 id 회원번호  출력
		pmcp = new PromepContentPanel();
		pmcp.setService(servicep);
		pmcp.loadData();
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(pmcp);
		
		JPanel pp5 = new JPanel();
		tabmaster.addTab("--\uAD00\uB9AC\uC790\uC124\uC815--", null, pp5, null);
		
			
	}
	

}
