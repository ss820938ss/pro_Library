package pro_Library.maintest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import pro_Library.dto.BookInformation;
import pro_Library.service.BookInformationService;
import pro_Library.ui.list.BookInformationTablePanel;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class BookSchPanel extends JPanel implements ActionListener {
	private JTextField tfSC;
	private JButton btnSC;
	private BookInformationService service;
	private JComboBox<String> com;
	private BookInformationTablePanel booktb;
	private List<BookInformation> bookinfo;

	public BookSchPanel() {
		initialize();
		booktb = new BookInformationTablePanel();
		bookinfo = new ArrayList<BookInformation>();
//		com.setSelectedIndex(-1);
	}

	private void initialize() {
		JComboBox combo = new JComboBox();
		combo.setModel(new DefaultComboBoxModel(new String[] {"전체검색", "도서번호", "도서제목", "도서구분"}));
		add(combo);
		
		tfSC = new JTextField();
		add(tfSC);
		tfSC.setColumns(20);
		
		JButton btnSC = new JButton("검색");
		btnSC.addActionListener(this);
		add(btnSC);
		
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


}
