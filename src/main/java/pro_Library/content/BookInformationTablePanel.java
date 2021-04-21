package pro_Library.content;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import pro_Library.dto.BookInformation;

@SuppressWarnings("serial")
public class BookInformationTablePanel<T> extends JPanel {
	private JTable table;
	private List<BookInformation> list;

	public BookInformationTablePanel() {
		initialize();
	}
	
	public T getItem() {
		return null;
	} 
	
	public void loadData() {
		initList();
		setList();
	}
	
	private void setList() {
	}

	public void initList() {
	}

	public void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(getModel());
		scrollPane.setViewportView(table);

	}

	private TableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	}

	public Object[][] getData() {
		return new Object[][] { { null, null, null, null }, };
	}

	public String[] getColumnNames() {
		return new String[] { "도서번호", "도서제목", "도서구분", "대출여부" };
	}

	public void setList(List<BookInformation> bookinfoList) {
		Object[][] data = new Object[bookinfoList.size()][];
		for (int i = 0; i < data.length; i++) {
			data[i] = toArray(bookinfoList.get(i));
		}

		CustomTableModel model = new CustomTableModel(data, getColumnNames());
		table.setModel(model);

		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);

		// 컬럼별 너비 조정
		setTableCellWidth(100, 300, 100, 100);
	}

	private void setTableCellWidth(int... width) {
		TableColumnModel tcm = (TableColumnModel) table.getColorModel();

		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}

	}

	private void setTableCellAlign(int align, int... idx) {
		TableColumnModel tcm = table.getColumnModel();

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}

	}

	private Object[] toArray(BookInformation bookInformation) {
		Object[] row = new Object[] { 
				bookInformation.getbNo(), 
				bookInformation.getbName(),
				bookInformation.getbDivision(), 
				bookInformation.getbRental() 
			};
		return row;
	}

	private class CustomTableModel extends DefaultTableModel {
		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	}

}
