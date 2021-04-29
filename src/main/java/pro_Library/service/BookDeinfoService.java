package pro_Library.service;

import java.util.List;

import pro_Library.dao.BookDeinfoDao;
import pro_Library.dao.impl.BookDeinfoDaoImpl;
import pro_Library.dto.BookDeinfo;

public class BookDeinfoService {
	private BookDeinfoDao bokinDao = BookDeinfoDaoImpl.getInstance();
	
	// 이게 전부 보는건가??
	List<BookDeinfo> selectBookDeinfoByAll() {
		return bokinDao.selectBookDeinfoByAll();
	}
	
	// 아마 이걸 넣어줘야 텍스트필드에 따로 넣을수 있을듯?
	List<BookDeinfo> selectBookDeinfoBybNo(BookDeinfo bookbeinfo) {
		return bokinDao.selectBookDeinfoBybNo(bookbeinfo);
	}
	
	List<BookDeinfo> selectBookDeinfoBybName(BookDeinfo bookbeinfo) {
		return bokinDao.selectBookDeinfoBybName(bookbeinfo);
	}
	
	List<BookDeinfo> selectBookDeinfoBybDivision(BookDeinfo bookbeinfo) {
		return bokinDao.selectBookDeinfoBybDivision(bookbeinfo);
	}
	
	List<BookDeinfo> selectBookDeinfoBybImg(BookDeinfo bookbeinfo) {
		return bokinDao.selectBookDeinfoBybImg(bookbeinfo);
	}
	
	// 자꾸 오류나면서 이거 고쳐져서 그냥 추가함
	BookDeinfo selectBookDeinfoBybbNo(int bNo) {
		return bokinDao.selectBookDeinfoBybbNo(bNo);
	}
	
	// 입력수정삭제
	public void insertBookDeinfo(BookDeinfo bookdeinfo) {
		bokinDao.insertBookDeinfo(bookdeinfo);
	}
	
	public void updateBookDeinfo(BookDeinfo bookdeinfo) {
		bokinDao.updateBookDeinfo(bookdeinfo);
	}
	public void deleteBookDeinfo(int bNo) {
		bokinDao.deleteBookDeinfo(bNo);
	}
	
	/// 생성은 했는데 뭔지 모르겠어서 분리
	public BookDeinfoDao getBokinDao() {
		return bokinDao;
	}

	public void setBokinDao(BookDeinfoDao bokinDao) {
		this.bokinDao = bokinDao;
	}
	
	

}
