package pro_Library.test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pro_Library.dao.BookSearchDao;
import pro_Library.dto.BookDeinfo;
import pro_Library.dto.BookInformation;
import pro_Library.service.BookInformationService;
import pro_Library.ui.content.AbstractContentPanel;
import pro_Library.ui.list.BookInformationTablePanel;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class Maintabletest extends JFrame implements ActionListener {
	private JPanel contentPane;
	
	// 검색창 
	private JTextField tfSC;
	private JButton btnSC;
	private BookInformationService service;
	private JComboBox<String> com;
	private BookInformationTablePanel booktb;
	private List<BookInformation> bookinfo;
	
	// 목록
	private ArrayList<BookInformation> al = new ArrayList<BookInformation>();
	private BookInformationTablePanel pbookinfo;
	private BookSearchDao bsd;
	private JTable table;
	private JTextField tf_bok1;
	private JTextField tf_bok2;
	private JTextField tf_bok3;
	private List<BookInformation> blist;
	private List<BookInformation> list;
	// -- 책표지
	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	private JTextField lbbokimg;
	

	/*
	 * Maintabletest frame = new Maintabletest(); frame.setVisible(true);
	 */

	public Maintabletest() {
		initialize();
		dbinput();
		
		booktb = new BookInformationTablePanel();
		bookinfo = new ArrayList<BookInformation>();
		com.setSelectedIndex(-1);
	}

	private void dbinput() {
		List<BookInformation> bok = service.selectBookInformationByAll();	
		
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// 탭
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		// 탭 검색부분
		JPanel pguestmn = new JPanel();
		tabbedPane.addTab("\uB3C4\uC11C\uAC80\uC0C9", null, pguestmn, null);
		pguestmn.setLayout(new BorderLayout(0, 0));
		
		// 검색탭 메인판넬
		JPanel pgsch = new JPanel();
		pguestmn.add(pgsch, BorderLayout.NORTH);
		pgsch.setLayout(new BorderLayout(0, 0));
		
		// 검색탭 이미지
		JPanel pgsh_img = new JPanel();
		pgsch.add(pgsh_img, BorderLayout.EAST);
		
		// 검색탭 검색파트
		JPanel pgsh_main = new JPanel();
		pgsch.add(pgsh_main, BorderLayout.CENTER);
		pgsh_main.setLayout(new BorderLayout(0, 0));
		
		// 검색탭 검색창
		JPanel pgshbar = new JPanel();
		pgsh_main.add(pgshbar, BorderLayout.NORTH);
		
		JComboBox combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] {"전체검색", "도서번호", "도서제목", "도서구분"}));
		pgshbar.add(combo);
		
		tfSC = new JTextField();
		pgshbar.add(tfSC);
		tfSC.setColumns(20);
		
		JButton btnSC = new JButton("검색");
		btnSC.addActionListener(this);
		pgshbar.add(btnSC);
		
		// 검색탭 도서목록
		
		JPanel pglist = new JPanel();
		pgsh_main.add(pglist, BorderLayout.SOUTH);
		
		// 검색탭 차트(나중구현, 이미지만넣기)
		pbookinfo = new BookInformationTablePanel();
		table = new JTable();
		pbookinfo.setService(service);
		pbookinfo.loadData();
		pgsh_main.add(pbookinfo, BorderLayout.CENTER);
		
		// 탭 반납부분
		JPanel pguestrt = new JPanel();
		tabbedPane.addTab("\uB3C4\uC11C\uBC18\uB0A9", null, pguestrt, null);
		pguestrt.setLayout(new BorderLayout(0, 0));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSC) {
			actionPerformedbtnSC(e);
		}
	}

	private void actionPerformedbtnSC(ActionEvent e) {
		try {
			String selectItem = com.getSelectedItem().toString();
			bookinfo = item(selectItem);
			if (bookinfo != null) {
				booktb.setList(bookinfo);
				booktb.setList();
			} else {
				booktb.setList(bookinfo);
				booktb.loadData();
			}

		} catch (Exception e1) {
			e1.getStackTrace();
		}
		
	}

	private List<BookInformation> item(String selectItem) {
		try {

			if (selectItem.equals("전체검색")) {
				bookinfo = service.showBookInformationList(new BookInformation(tfSC.getText()));
			}
			if (selectItem.equals("도서번호")) {
				bookinfo = service.selectBookInformationBybNo(new BookInformation(tfSC.getText()));
			}
			if (selectItem.equals("도서제목")) {
				bookinfo = service.selectBookInformationBybName(new BookInformation(tfSC.getText()));
			}
			if (selectItem.equals("도서구분")) {
				bookinfo = service.selectBookInformationBybDivision(new BookInformation(tfSC.getText()));
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

		return bookinfo;
	}

	public void setService(BookInformationService service) {
		this.service = service;
	}

	public BookInformationTablePanel getBookInfoList() {
		return booktb;
	}

	public void clearTf() {
		tfSC.setText("");
	}

	public void setItem(BookDeinfo item) {
		// TODO Auto-generated method stub
		
	}

	public BookDeinfo getItem() {
		// TODO Auto-generated method stub
		return null;
	}

	public void validCheck() {
		// TODO Auto-generated method stub
		
	}


}
