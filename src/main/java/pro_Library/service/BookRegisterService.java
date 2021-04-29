package pro_Library.service;

import java.util.List;

import pro_Library.dao.BookRegisterDao;
import pro_Library.dao.impl.BookRegisterDaoImpl;
import pro_Library.dto.BookRegister;

public class BookRegisterService {
	private BookRegisterDao brDao = BookRegisterDaoImpl.getInstance();
	
	public List<BookRegister> showBookRegisterList() {
		return brDao.selectBookRegisterByAll();
	}
			
	public List<BookRegister> selectBookRegisterByAll() {
		return brDao.selectBookRegisterByAll();
	}

	public BookRegister selectBookRegisterByNo(BookRegister bookregister) {
		return brDao.selectBookRegisterByNo(bookregister);
	}

	public int insertBookRegister(BookRegister bookregister) {
		return brDao.insertBookRegister(bookregister);
	}

	public int updateBookRegister(BookRegister bookregister) {
		return brDao.updateBookRegister(bookregister);
	}

	public int deleteBookRegister(int bNo) {
		return brDao.deleteBookRegister(bNo);
	}

}
