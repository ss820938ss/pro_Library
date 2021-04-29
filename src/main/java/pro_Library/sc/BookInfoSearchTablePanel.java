package pro_Library.sc;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RowSorter;

import pro_Library.dao.BookSearchDao;
import pro_Library.dto.BookDeinfo;
import pro_Library.dto.BookInformation;
import pro_Library.service.BookDeinfoService;
import pro_Library.service.BookInformationService;
import pro_Library.ui.content.AbstractContentPanel;
import pro_Library.ui.exception.InvalidCheckException;
import pro_Library.ui.exception.NotSelectedException;
import pro_Library.ui.list.BookInformationTablePanel;
import pro_Library.ui.list.AbstractCustomTablePanel.CustomTableModel;
import pro_Library.ui.list.BookDeinfoTablePanel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class BookInfoSearchTablePanel extends AbstractContentPanel<BookDeinfo> implements MouseListener {
	private ArrayList<BookInformation> al = new ArrayList<BookInformation>();
	private BookDeinfoService service;
	
	private String imgPath = System.getProperty("user.dir")+"/"+ File.separator;
	private JTextField lbbokimg;

	private List<BookDeinfo> blist;
	private BookSearchDao bsd;

	private JTable table;
	private JTextField tf_bok1;
	private JTextField tf_bok2;
	private JTextField tf_bok3;
	private List<BookDeinfo> list;

	// 제작중, 이미지 받아서 띄우는법, 테이블 적용하기 남음
	
	public BookInfoSearchTablePanel() {
		initialize();
	}

	private void initialize() {
		setBorder(new TitledBorder(null, "도서 상세정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		// 위  테이블 항목 클릭 시 정보 출력하는 폼
		JPanel pbokinfo = new JPanel();
		add(pbokinfo, BorderLayout.CENTER);
		pbokinfo.setLayout(new BorderLayout(0, 0));
		
		JPanel pinfo_s = new JPanel();
		pbokinfo.add(pinfo_s, BorderLayout.CENTER);
		pinfo_s.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lbbok_no = new JLabel("도서번호");
		lbbok_no.setHorizontalAlignment(SwingConstants.CENTER);
		pinfo_s.add(lbbok_no);
		
		tf_bok1 = new JTextField();
		tf_bok1.setColumns(10);
		pinfo_s.add(tf_bok1);
		
		JLabel lbbok_nm = new JLabel("도서제목");
		lbbok_nm.setHorizontalAlignment(SwingConstants.CENTER);
		pinfo_s.add(lbbok_nm);
		
		tf_bok2 = new JTextField();
		tf_bok2.setColumns(10);
		pinfo_s.add(tf_bok2);
		
		JLabel lbbok_ct = new JLabel("도서구분");
		lbbok_ct.setHorizontalAlignment(SwingConstants.CENTER);
		pinfo_s.add(lbbok_ct);
		
		tf_bok3 = new JTextField();
		tf_bok3.setColumns(10);
		pinfo_s.add(tf_bok3);
		
		// 표지 이미지 띄우는 공간
		JPanel pbokimg = new JPanel();
		pbokimg.setBorder(new TitledBorder(null, "\uD45C\uC9C0", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pbokinfo.add(pbokimg, BorderLayout.EAST);
		pbokimg.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbboknm = new JLabel("");
		
		ImageIcon img = new ImageIcon("image.png");
		lbboknm.setIcon(new ImageIcon(imgPath)); // 액션퍼폼드에 넣기
		lbboknm.setHorizontalAlignment(SwingConstants.LEFT);
		pbokimg.add(lbboknm);
	}
	
	@Override
	public void clearTf() {
		tf_bok1.setText("");
		tf_bok2.setText("");
		tf_bok3.setText("");
		
		if (!tf_bok1.isEditable()) {
			tf_bok1.setEditable(true);
		}
	}

	@Override
	public void setItem(BookDeinfo item) {
		// 아마 텍스트 필드에 정보 받는 항목이 아닐지 
		tf_bok1.setText(String.valueOf(item.getbNo()));
		tf_bok2.setText(item.getbName());
		tf_bok3.setText(item.getbDivision());
		lbbokimg.setText(item.getbImg());
		
		tf_bok1.setEnabled(false);
	}
	
	@Override
	public BookDeinfo getItem() {
		validCheck();
		int bNo = Integer.parseInt(tf_bok1.getText().trim());
		String bName = tf_bok2.getText().trim();
		String bDivision = tf_bok3.getText().trim();
		String bImg = lbbokimg.getSelectedText().trim();
		
		return new BookDeinfo(bNo, bName, bDivision, bImg);
	}
	
	@Override
	public void validCheck() {
		if (tf_bok1.getText().equals("") || tf_bok2.getText().equals("") || tf_bok3.getText().equals("")) {
			throw new InvalidCheckException();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
/*	
	public void setList(BookDeinfo bookdeinfo) {
		tf_bok1.setText(String.valueOf(bookdeinfo.getbNo()));
		tf_bok2.setText(bookdeinfo.getbName());
		tf_bok3.setText(bookdeinfo.getbDivision());
	}
*/
	
}
