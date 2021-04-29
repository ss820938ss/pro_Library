package pro_Library.ui.list;

import java.util.List;
import javax.swing.SwingConstants;

import pro_Library.dto.BookInformation;
import pro_Library.service.BookInformationService;
import pro_Library.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class BookInformationTablePanel extends AbstractCustomTablePanel<BookInformation>{
	public BookInformationTablePanel() {
	}
	private BookInformationService service;
	
	@Override
	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3);
		// 컬럼별 너비 조정
		setTableCellWidth(100, 300, 100, 100);
	}
	
	@Override
	public Object[] toArray(BookInformation b) {
		return new Object[] { b.getbNo(), b.getbName(), b.getbDivision(), b.getbRental() };
	}
	
	@Override
	public String[] getColumnNames() {
		return new String[] { "도서번호",  "도서제목", "도서구분", "대출여부" };
	}
	
	@Override
	public void initList() {
		list = service.showBookInformationList();
	}

	public void setList(List<BookInformation> list) {
		this.list = list;
	}
	
	@Override
	public BookInformation getItem() {
		int row = table.getSelectedRow();
		int bNo = (int) table.getValueAt(row, 0);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new BookInformation(bNo)));
	}

	public void setService(BookInformationService service) {
		this.service = service;
		
	}

}
