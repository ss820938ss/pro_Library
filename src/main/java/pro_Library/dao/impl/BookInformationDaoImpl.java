package pro_Library.dao.impl;

import java.util.List;

import pro_Library.dao.BookInformationDao;
import pro_Library.dto.BookInformation;

public class BookInformationDaoImpl implements BookInformationDao {
	
	private static BookInformationDaoImpl instance = new BookInformationDaoImpl();

	@Override
	public List<BookInformation> selectBookInformationByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookInformation selectBookInformationByNo(BookInformation bookinformation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBookInformation(BookInformation bookinformation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBookInformation(BookInformation bookinformation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBookInformation(int bNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
