package pro_Library.ui.list;

import javax.swing.SwingConstants;

import pro_Library.dto.RentalReturn;
import pro_Library.service.RentalReturnService;
import pro_Library.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class RentalReturnTablePanel extends AbstractCustomTablePanel<RentalReturn> {
	private RentalReturnService service;

	public RentalReturnTablePanel() {}
	
	public void setService(RentalReturnService service) {
		this.service = service;
	}

	public void initList() {
		list = service.showRentalReturnList();
	}
	
	@Override
	public RentalReturn getItem() {
		int row = table.getSelectedRow();
		int pNo = (int) table.getValueAt(row, 0);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new RentalReturn(pNo)));
	}
	
	@Override
	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4);
		// 컬럼별 너비 조정
		setTableCellWidth(100, 100, 150, 150, 100);
	}
	
	@Override
	public Object[] toArray(RentalReturn rr) {
		return new Object[] { rr.getpNo(), rr.getbNo(), rr.getBrDate(), rr.getbReturn(), rr.getbOverdue() };
	}
	
	@Override
	public String[] getColumnNames() {
		return new String[] { "회원번호",  "도서번호", "도서대여일", "도서반납일", "도서연체일" };
	}
}
