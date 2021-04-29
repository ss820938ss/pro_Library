package pro_Library.ui.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import pro_Library.ui.exception.InvalidCheckException;
import pro_Library.dto.BookInformation;

@SuppressWarnings("serial")
public class BookInformationContentPanel extends AbstractContentPanel<BookInformation> {
	private JTextField tf_bNo;
	private JTextField tf_bName;
	private JTextField tf_bDivision;
	private JTextField tf_bRental;

	public BookInformationContentPanel() {
		initialize();
	}

	private void initialize() {
		setBorder(new TitledBorder(null, "도서정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 1, 10, 0));

		JPanel p_bNo = new JPanel();
		add(p_bNo);
		p_bNo.setLayout(new GridLayout(0, 2, 2, 0));

		JLabel lb_bNo = new JLabel("도서번호");
		lb_bNo.setHorizontalAlignment(SwingConstants.CENTER);
		p_bNo.add(lb_bNo);

		tf_bNo = new JTextField();
		p_bNo.add(tf_bNo);
		tf_bNo.setColumns(15);

		JPanel p_bName = new JPanel();
		add(p_bName);
		p_bName.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lb_bName = new JLabel("도서제목");
		lb_bName.setHorizontalAlignment(SwingConstants.CENTER);
		p_bName.add(lb_bName);

		tf_bName = new JTextField();
		p_bName.add(tf_bName);
		tf_bName.setColumns(15);

		JPanel p_bDivision = new JPanel();
		add(p_bDivision);
		p_bDivision.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lb_bDivision = new JLabel("도서구분");
		lb_bDivision.setHorizontalAlignment(SwingConstants.CENTER);
		p_bDivision.add(lb_bDivision);

		tf_bDivision = new JTextField();
		tf_bDivision.setColumns(15);
		p_bDivision.add(tf_bDivision);

		JPanel p_bRental = new JPanel();
		add(p_bRental);
		p_bRental.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lb_bRental = new JLabel("대출여부");
		lb_bRental.setHorizontalAlignment(SwingConstants.CENTER);
		p_bRental.add(lb_bRental);

		tf_bRental = new JTextField();
		tf_bRental.setColumns(15);
		p_bRental.add(tf_bRental);

	}

	@Override
	public void setItem(BookInformation item) {
		tf_bNo.setText(String.valueOf(item.getbNo()));
		tf_bName.setText(item.getbName());
		tf_bDivision.setText(item.getbDivision());
		tf_bRental.setText(item.getbRental());

		tf_bNo.setEditable(false);

	}

	@Override
	public BookInformation getItem() {
		validCheck();
		int bNo = Integer.parseInt(tf_bNo.getText().trim());
		String bName = tf_bName.getText().trim();
		String bDivision = tf_bDivision.getText().trim();
		String bRental = tf_bRental.getText().trim();
		return new BookInformation(bNo, bName, bDivision, bRental);
	}

	@Override
	public void validCheck() {
		if (tf_bNo.getText().contentEquals("") || tf_bName.getText().equals("")
			|| tf_bDivision.getText().equals("") || tf_bRental.getText().equals("")) {
			throw new InvalidCheckException();
		}

	}

	@Override
	public void clearTf() {
		tf_bNo.setText("");
		tf_bName.setText("");
		tf_bDivision.setText("");
		tf_bRental.setText("");

		if (!tf_bNo.isEditable()) {
			tf_bNo.setEditable(true);

		}
	}
}
