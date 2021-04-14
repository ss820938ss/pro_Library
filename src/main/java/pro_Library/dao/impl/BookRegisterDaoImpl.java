package pro_Library.dao.impl;

import java.util.List;

import pro_Library.dao.BookRegisterDao;
import pro_Library.dto.BookRegister;

public class BookRegisterDaoImpl implements BookRegisterDao {
	private static BookRegisterDaoImpl instance = new BookRegisterDaoImpl();
	
	
	public BookRegisterDaoImpl() {
	}

	@Override
	public List<BookRegister> selectBookRegisterByAll() {
		return null;
	}

	@Override
	public BookRegister selectBookRegisterByNo(BookRegister bookregister) {
		return null;
	}

	@Override
	public int insertBookRegister(BookRegister bookregister) {
		return 0;
	}

	@Override
	public int updateBookRegister(BookRegister bookregister) {
		return 0;
	}

	@Override
	public int deleteBookRegister(int bNo) {
		return 0;
	}

}
