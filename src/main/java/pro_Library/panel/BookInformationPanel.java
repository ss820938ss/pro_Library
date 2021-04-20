package pro_Library.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.FlowLayout;
import pro_Library.content.BookInformationTablePanel;

@SuppressWarnings("serial")
public class BookInformationPanel extends JPanel {
	private JTextField textField;

	public BookInformationPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\uAC80\uC0C9\uBAA9\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"도서제목", "도서번호", "도서구분", "대출여부"}));
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("검색어");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		panel.add(textField);
		
		JButton button = new JButton("검색");
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		BookInformationTablePanel panel_5 = new BookInformationTablePanel();
		panel_1.add(panel_5);

	}

}
