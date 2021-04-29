package pro_Library;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
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

import pro_Library.service.BookInformationService;
import pro_Library.service.ProfileService;
import pro_Library.ui.AbstractManagerUI;
import pro_Library.ui.content.BookInformationContentPanel;
import pro_Library.ui.content.ProMasterContentPanel;
import pro_Library.ui.content.PromepContentPanel;
import pro_Library.ui.list.BookInformationTablePanel;
import pro_Library.ui.list.ProfileTablePanel;

@SuppressWarnings("serial")
public class Main_master extends JFrame {

	private JPanel contentPane;
	
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
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


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
		setBounds(100, 100, 600, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		JTabbedPane tabmaster = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabmaster, BorderLayout.NORTH);
		
		// 도서검색 탭
		JPanel psch = new JPanel();
		tabmaster.addTab("도서검색", null, psch, null);
		psch.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel p_scm = new JPanel();
		psch.add(p_scm);
		p_scm.setLayout(new BorderLayout(0, 0));
		
		JPanel p_sc_con = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p_sc_con.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		p_scm.add(p_sc_con, BorderLayout.NORTH);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC804\uCCB4\uAC80\uC0C9", "\uB3C4\uC11C\uBC88\uD638", "\uB3C4\uC11C\uC81C\uBAA9", "\uB3C4\uC11C\uBD84\uB958"}));
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
		p_sc_list.add(pbookinfo);
		
		// 도서관리 탭		
		JPanel pbook = new JPanel();
		tabmaster.addTab("도서등록/관리", null, pbook, null);
		pbook.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel p_bm = new JPanel();
		pbook.add(p_bm);
		p_bm.setLayout(new BorderLayout(0, 0));
		
		pbookinfo_1 = new BookInformationTablePanel();
		pbookinfo_1.setService(serviceb);
		pbookinfo_1.loadData();
		p_bm.add(pbookinfo_1, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		p_bm.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnNewButton_5 = new JButton("\uC218\uC815");
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("\uCD94\uAC00");
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\uCDE8\uC18C");
		panel_3.add(btnNewButton_4);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C\uBC88\uD638");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel);
		
		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uB3C4\uC11C\uC81C\uBAA9");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uB3C4\uC11C\uBD84\uB958");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		panel_4.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		p_bm.add(panel_2, BorderLayout.SOUTH);
		
		// 대출 반납 탭
		JPanel prental = new JPanel();
		tabmaster.addTab("대출/반납", null, prental, null);
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
		tabmaster.addTab("회원관리", null, ppro, null);
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
		
			
	}
	

}
