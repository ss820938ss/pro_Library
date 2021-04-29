package pro_Library.ui.list;

import java.io.NotActiveException;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import pro_Library.dto.BookDeinfo;
import pro_Library.service.BookDeinfoService;
import pro_Library.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class BookDeinfoTablePanel extends AbstractCustomTablePanel<BookDeinfo> {
	private BookDeinfoService service;
	
	
	public BookDeinfoTablePanel() {}
	

	@Override
	public BookDeinfo getItem() {
		int row = table.getSelectedRow();
		int bNo = (int) table.getValueAt(row, 0);
		
		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new BookDeinfo(bNo)));
	}

	@Override
	public void initList() {
//		list = service.selectBookDeinfoByAll();
		
	}

	@Override
	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
		// 컬럼별 너비 조정
		setTableCellWidth(200, 400, 200);
		
	}

	@Override
	public Object[] toArray(BookDeinfo t) {
		return new Object[] { t.getbNo(), t.getbName(), t.getbDivision() };
	}

	@Override
	public String[] getColumnNames() {
		return new String[] { "도서번호", "도서제목", "도서구분"};
	}
	
	public void setService(BookDeinfoService service) {
		this.service = service;
	}

}
