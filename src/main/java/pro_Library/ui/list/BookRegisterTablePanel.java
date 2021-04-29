package pro_Library.ui.list;

import javax.swing.SwingConstants;

import pro_Library.dto.BookRegister;
import pro_Library.service.BookRegisterService;
import pro_Library.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class BookRegisterTablePanel extends AbstractCustomTablePanel<BookRegister> {
	private BookRegisterService service;

	public BookRegisterTablePanel() {}
	
	public void setService(BookRegisterService service) {
		this.service = service;
	}
	
	public void initList() {
		list = service.showBookRegisterList();
	}
	
	@Override
	public BookRegister getItem() {
		int row = table.getSelectedRow();
		int bNo = (int) table.getValueAt(row, 0);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new BookRegister(bNo)));
	}
	
	@Override
	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2);
		// 컬럼별 너비 조정
		setTableCellWidth(200, 200, 200);
	}
	
	@Override
	public Object[] toArray(BookRegister br) {
		return new Object[] { br.getbNo(), br.getbName(), br.getbDivision() };
	}
	
	@Override
	public String[] getColumnNames() {
		return new String[] { "도서번호",  "도서제목", "도서구분" };
	}
}
