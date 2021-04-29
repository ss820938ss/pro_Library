package pro_Library.ui.list;

import javax.swing.SwingConstants;

import pro_Library.dto.Profile;
import pro_Library.service.ProfileService;
import pro_Library.ui.exception.NotSelectedException;

@SuppressWarnings("serial")
public class ProfileTablePanel extends AbstractCustomTablePanel<Profile> {
	private ProfileService service;
	
	public ProfileTablePanel() {}
	
	public void setService(ProfileService service) {
		this.service = service;
	}
	
	public void initList() {
		list = service.showProfiles();
	}
	
	@Override
	public Profile getItem() {
		int row = table.getSelectedRow();
		int pNo = (int) table.getValueAt(row, 0);

		if (row == -1) {
			throw new NotSelectedException();
		}
		return list.get(list.indexOf(new Profile(pNo)));
	}
	
	@Override
	protected void setAlignAndWidth() {
		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5);
		// 컬럼별 너비 조정
		setTableCellWidth(100, 100, 150, 150, 150, 100);
	}
	
	@Override
	public Object[] toArray(Profile p) {
		return new Object[] { p.getpNo(), p.getpName(), p.getpBirth(), 
							  p.getpPhone(), p.getpCellphone(), p.getpAddress() };
	}
	
	@Override
	public String[] getColumnNames() {
		return new String[] { "회원번호",  "회원이름", "생년월일", "전화번호", "휴대전화", "주소" };
	}
}
