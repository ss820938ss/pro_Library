package pro_Library.panel;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.DateFormatter;

import pro_Library.dto.Profile;
import pro_Library.exception.EmptyTfException;
import pro_Library.exception.InValidationException;

import javax.swing.UIManager;
import java.awt.Color;

@SuppressWarnings("serial")
public class ProfilePanel extends JPanel {
	private JTextField protf_no;
	private JTextField protf_name;
	private JTextField protf_birth;
	private JTextField protf_phone;
	private JTextField protf_tel;
	private JTextField protf_address;

	public JTextField getprotf_no() {
		return protf_no;
	}

	public JTextField getprotf_name() {
		return protf_name;
	}

	public JTextField getprotf_birth(String string) {
		return protf_birth;
	}

	public JTextField getprotf_phone() {
		return protf_phone;
	}

	public JTextField getprotf_tel() {
		return protf_tel;
	}

	public JTextField getprotf_address() {
		return protf_address;
	}

	public ProfilePanel() {
		initialize();
	}

	private void initialize() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(0, 2, 0, 0));

		JLabel prolb_no = new JLabel("회원번호");
		prolb_no.setHorizontalAlignment(SwingConstants.CENTER);
		add(prolb_no);

		protf_no = new JTextField();
		add(protf_no);
		protf_no.setColumns(10);

		JLabel prolb_name = new JLabel("회원이름");
		prolb_name.setHorizontalAlignment(SwingConstants.CENTER);
		add(prolb_name);

		protf_name = new JTextField();
		protf_name.setColumns(10);
		add(protf_name);

		JLabel prolb_birth = new JLabel("생년월일");
		prolb_birth.setHorizontalAlignment(SwingConstants.CENTER);
		add(prolb_birth);

		protf_birth = new JTextField();
		protf_birth.setColumns(10);
		add(protf_birth);

		JLabel prolb_phone = new JLabel("휴대전화");
		prolb_phone.setHorizontalAlignment(SwingConstants.CENTER);
		add(prolb_phone);

		protf_phone = new JTextField();
		protf_phone.setColumns(10);
		add(protf_phone);

		JLabel prolb_tel = new JLabel("전화번호");
		prolb_tel.setHorizontalAlignment(SwingConstants.CENTER);
		add(prolb_tel);

		protf_tel = new JTextField();
		protf_tel.setColumns(10);
		add(protf_tel);

		JLabel prolb_address = new JLabel("주소");
		prolb_address.setHorizontalAlignment(SwingConstants.CENTER);
		add(prolb_address);

		protf_address = new JTextField();
		protf_address.setColumns(10);
		add(protf_address);

	}

	public void setItem(Profile item) {
		protf_no.setText(item.getpNo() + "");
		protf_name.setText(item.getpName() + "");
		protf_birth.setText(item.getpBirth() + "");
		protf_phone.setText(item.getpPhone() + "");
		protf_tel.setText(item.getpCellphone() + "");
		protf_address.setText(item.getpPhone() + "");

		protf_no.setEditable(false);
	}

	public Profile getItem() {
		validCheck();
		typeCheck();

		int pNo = Integer.parseInt(protf_no.getText().trim());
		if (!(pNo > 0 && pNo < 1000)) {
			throw new EmptyTfException();
		}
		String pName = protf_no.getText().trim();

		Date pBirth = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String to = transFormat.format(pBirth);

		String pPhone = protf_phone.getText().trim();
		String pCellphone = protf_tel.getText().trim();
		String pAddress = protf_address.getText().trim();

		return new Profile(pNo, pName, pBirth, pPhone, pCellphone, pAddress);
	}

	private void typeCheck() {
		if (!Pattern.matches("^[0-9]*$", protf_no.getText()) || !Pattern.matches("^[가-힣]*$", protf_name.getText())) {
			throw new EmptyTfException();
		}

	}

	private void validCheck() {
		if (protf_no.getText().contentEquals("") || protf_name.getText().contentEquals("")) {
			throw new InValidationException();
		}

	}

	public void cleartf() {
		protf_no.setText("");
		protf_name.setText("");

		if (!protf_no.isEditable()) {
			protf_no.setEditable(true);
		}

	}

}
