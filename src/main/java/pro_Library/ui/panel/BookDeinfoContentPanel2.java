package pro_Library.ui.panel;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import pro_Library.dto.BookDeinfo;
import pro_Library.service.BookDeinfoService;
import pro_Library.ui.content.AbstractContentPanel;
import pro_Library.ui.exception.InvalidCheckException;
import pro_Library.ui.exception.NotSelectedException;

import java.awt.GridLayout;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class BookDeinfoContentPanel2 extends AbstractContentPanel<BookDeinfo> {
	//////텍스트필드
	private JTextField tf_bok1;
	private JTextField tf_bok2;
	private JTextField tf_bok3;
	
	//////이미지넣는부분
//	private String imgPath = System.getProperty("user.dir")+"/"+ File.separator;
	private JLabel lbboknm;
	private BookDeinfoService service;
	private String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
	
	public BookDeinfoContentPanel2() {
		initialize();
		
	}
	private void initialize() {
		setLayout(new BorderLayout(0, 0));
		
		// 입력폼
		JPanel pinfo_s = new JPanel();
		pinfo_s.setBorder(new TitledBorder(null, "도서 상세정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(pinfo_s, BorderLayout.CENTER);
		pinfo_s.setLayout(new GridLayout(3, 7, 0, 0));
		
		JLabel lbbok_no = new JLabel("도서번호");
		lbbok_no.setHorizontalAlignment(SwingConstants.CENTER);
		pinfo_s.add(lbbok_no);
		
		tf_bok1 = new JTextField();
		tf_bok1.setHorizontalAlignment(SwingConstants.CENTER);
		pinfo_s.add(tf_bok1);
		tf_bok1.setColumns(15);
		
		JLabel lbbok_nm = new JLabel("도서제목");
		lbbok_nm.setHorizontalAlignment(SwingConstants.CENTER);
		pinfo_s.add(lbbok_nm);
		
		tf_bok2 = new JTextField();
		tf_bok2.setHorizontalAlignment(SwingConstants.CENTER);
		pinfo_s.add(tf_bok2);
		tf_bok2.setColumns(15);
		
		JLabel lbbok_ct = new JLabel("도서구분");
		lbbok_ct.setHorizontalAlignment(SwingConstants.CENTER);
		pinfo_s.add(lbbok_ct);
		
		tf_bok3 = new JTextField();
		tf_bok3.setHorizontalAlignment(SwingConstants.CENTER);
		pinfo_s.add(tf_bok3);
		tf_bok3.setColumns(15);
		
		// 표지 이미지 띄우는 공간
		JPanel pbokimg = new JPanel();
		pbokimg.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uCC45 \uD45C\uC9C0", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(pbokimg, BorderLayout.WEST);
		
		JLabel lbboknm = new JLabel("");
//		String imgPath = System.getProperty("user.dir")+"/"+ File.separator;
		pbokimg.setLayout(new GridLayout(1, 1, 0, 0));
		// 임시이미지....
		lbboknm.setIcon(new ImageIcon(imgPath + "b1.jpg"));
//		lbboknm.setIcon(new ImageIcon(imgPath)); // 액션퍼폼드에 넣기
		lbboknm.setHorizontalAlignment(SwingConstants.LEFT);
		pbokimg.add(lbboknm);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC544\uC6C3");
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("admin \uD68C\uC6D0\uB2D8 \uC548\uB155\uD558\uC138\uC694.");
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("                                                  ");
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("              ");
		panel_2.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("\uB3C4\uC6C0\uB9D0");
		panel_2.add(btnNewButton_2);
		
		// 된건지전혀모르겠고 ... 이미지경로 따는걸 대체?? 이미지아이콘에 어떻게넣음?
//		String imgPath = System.getProperty("user.dir")+"/"+ "images/b1.jpg";
//		ImageIcon img = new ImageIcon("image.png");

	}
	
	
	// 아마 폼설정
	@Override
	public void setItem(BookDeinfo item) {
		if (item == null) {
			throw new NotSelectedException();
		}
		tf_bok1.setText(String.valueOf(item.getbNo()));
		tf_bok2.setText(item.getbName());
		tf_bok3.setText(item.getbDivision());
		lbboknm.setText(item.getbImg());
		// 이게 아마 입력x 
		tf_bok1.setEditable(false);
		tf_bok2.setEditable(false);
		tf_bok3.setEditable(false);
	}

	@Override
	public BookDeinfo getItem() {
		validCheck();
		int bNo = Integer.parseInt(tf_bok1.getText().trim());
		String bName = tf_bok2.getText().trim();
		String bDivision = tf_bok3.getText().trim();
		String bImg = lbboknm.getText().trim();
		
		return new BookDeinfo(bNo, bName, bDivision, bImg);
	}
	
	public BookDeinfo getItembNo() {
		validCheck();
		int bNo = Integer.parseInt(tf_bok1.getText().trim());
		
		return new BookDeinfo(bNo);
	}
	
	public BookDeinfo getItembName() {
		validCheck();
		int bNo = Integer.parseInt(tf_bok1.getText().trim());
		String bName = tf_bok2.getText().trim();
		String bDivision = tf_bok3.getText().trim();
		String bImg = lbboknm.getText().trim();
		
		return new BookDeinfo(bNo, bName, bDivision, bImg);
	}

	@Override
	public void validCheck() {
		if (tf_bok1.getText().equals("")) {
			throw new InvalidCheckException();
		}
		
	}

	@Override
	public void clearTf() {
		tf_bok1.setText("");
		tf_bok2.setText("");
		tf_bok3.setText("");
		
		// 이거 아마 입력불가폼이라 필요없는듯?? 
		// isEditable, setEditable 설명에 TextComponent 편집가능해야 쓸수있다고 되어있음 
//		if (!tf_bok1.isEditable()) {
//			tf_bok1.setEditable(true);
//		}
	}
	
	// get set
	public JTextField gettf_bok1() {
		return tf_bok1;
	}
	
	public JTextField gettf_bok2() {
		return tf_bok2;
	}
	
	public JTextField gettf_bok3() {
		return tf_bok3;
	}
	
	public JLabel getlbboknm() {
		return lbboknm;
	}
	
	public void settf_bok1(JTextField tf_bok1) {
		this.tf_bok1 = tf_bok1;
	}
	
	public void settf_bok2(JTextField tf_bok2) {
		this.tf_bok2 = tf_bok2;
	}
	
	public void settf_bok3(JTextField tf_bok3) {
		this.tf_bok3 = tf_bok3;
	}
	
	public void setlbboknm(JLabel lbboknm) {
		this.lbboknm = lbboknm;
	}
	
	public void setService(BookDeinfoService bdservice) {
		// TODO Auto-generated method stub
		this.service = bdservice;
	}
	
	public void loadData() {
		
	}
}
