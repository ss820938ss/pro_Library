package pro_Library.ui.content;

import pro_Library.dto.Profile;
import pro_Library.service.MemberpService;
import pro_Library.service.ProfileService;
import pro_Library.ui.exception.InvalidCheckException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

@SuppressWarnings("serial")
public class ProMasterContentPanel extends AbstractContentPanel<Profile> {
	private JTextField tf_pNo;
	private JTextField tf_pName;
	private JTextField tf_pBirth;
	private JTextField tf_pPhone;
	private JTextField tf_pCellphone;
	private JTextField tf_pAdress;
	
	public ProMasterContentPanel() {
		initialize();
	}
	
	private void initialize() {
		setBorder(new TitledBorder(null, "회원정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel p_pNo = new JPanel();
		add(p_pNo);
		
		JLabel lb_pNo = new JLabel("회원번호   ");
		lb_pNo.setHorizontalAlignment(SwingConstants.LEFT);
		p_pNo.add(lb_pNo);
		
		tf_pNo = new JTextField();
		p_pNo.add(tf_pNo);
		tf_pNo.setColumns(10);
		
		JPanel p_pAddress = new JPanel();
		add(p_pAddress);
		
		JLabel lb_pAdress = new JLabel("주소         ");
		lb_pAdress.setHorizontalAlignment(SwingConstants.LEFT);
		p_pAddress.add(lb_pAdress); 
		
		tf_pAdress = new JTextField();
		tf_pAdress.setColumns(10);
		p_pAddress.add(tf_pAdress);
		
		JPanel p_pName = new JPanel();
		add(p_pName);
		
		JLabel lb_pName = new JLabel("회원이름   ");
		lb_pName.setHorizontalAlignment(SwingConstants.LEFT);
		p_pName.add(lb_pName);
		
		tf_pName = new JTextField();
		tf_pName.setColumns(10);
		p_pName.add(tf_pName);
		
		JPanel p_pBirth = new JPanel();
		add(p_pBirth);
		
		JLabel lb_pBirth = new JLabel("생년월일   ");
		lb_pBirth.setHorizontalAlignment(SwingConstants.LEFT);
		p_pBirth.add(lb_pBirth);
		
		tf_pBirth = new JTextField();
		tf_pBirth.setColumns(10);
		p_pBirth.add(tf_pBirth);
		
		JPanel p_pPhone = new JPanel();
		add(p_pPhone);
		
		JLabel lb_pPhone = new JLabel("전화번호   ");
		lb_pPhone.setHorizontalAlignment(SwingConstants.LEFT);
		p_pPhone.add(lb_pPhone);
		
		tf_pPhone = new JTextField();
		tf_pPhone.setColumns(10);
		p_pPhone.add(tf_pPhone);
		
		JPanel p_pCellphone = new JPanel();
		add(p_pCellphone);
		
		JLabel lb_pCellphone = new JLabel("휴대전화   ");
		lb_pCellphone.setHorizontalAlignment(SwingConstants.LEFT);
		p_pCellphone.add(lb_pCellphone);
		
		tf_pCellphone = new JTextField();
		tf_pCellphone.setColumns(10);
		p_pCellphone.add(tf_pCellphone);

	}
	
	@Override
	public void clearTf() {
		tf_pNo.setText("");
		tf_pName.setText("");
		tf_pBirth.setText("");
		tf_pPhone.setText("");
		tf_pCellphone.setText("");
		tf_pAdress.setText("");
		
		if (!tf_pNo.isEditable()) {
			tf_pNo.setEditable(true);

		}	
	}


	@Override
	public void setItem(Profile item) {
		tf_pNo.setText(String.valueOf(item.getpNo()));
		tf_pName.setText(item.getpName());
		tf_pBirth.setText(item.getpBirth());
		tf_pPhone.setText(item.getpPhone());
		tf_pCellphone.setText(item.getpCellphone());
		tf_pAdress.setText(item.getpAddress());

		tf_pNo.setEditable(false);
		
	}

	@Override
	public Profile getItem() {
		validCheck();
		int pNo = Integer.parseInt(tf_pNo.getText().trim());
		String pName = tf_pName.getText().trim();
		String pBirth = tf_pBirth.getText().trim();
		String pPhone = tf_pPhone.getText().trim();
		String pCellphone = tf_pCellphone.getText().trim();
		String pAdress = tf_pAdress.getText().trim();
			
		return new Profile(pNo, pName, pBirth, pPhone, pCellphone, pAdress);
	}

	@Override
	public void validCheck() {
		if (tf_pNo.getText().contentEquals("") || tf_pName.getText().equals("") 
				|| tf_pBirth.getText().equals("") 
				|| tf_pPhone.getText().equals("") 
				|| tf_pCellphone.getText().equals("") 
				|| tf_pAdress.getText().equals("")) {
			throw new InvalidCheckException();
		}
	}

	public void setService(ProfileService servicep) {
		// TODO Auto-generated method stub
		
	}

	public void loadData() {
		// TODO Auto-generated method stub
		
	}



	
}
