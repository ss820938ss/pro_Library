package pro_Library.service;

import java.util.List;

import pro_Library.dao.BookInformationDao;
import pro_Library.dao.impl.BookInformationDaoImpl;
import pro_Library.dto.BookInformation;

public class BookInformationService {
	private BookInformationDao bookinfoDao = BookInformationDaoImpl.getInstance();
	
	public List<BookInformation> showBookInformationList() {
		return bookinfoDao.selectBookInformationByAll();
	}
	
	public List<BookInformation> selectBookInformationByAll() {
		return bookinfoDao.selectBookInformationByAll();
	}

	public List<BookInformation> selectBookInformationBybNo(BookInformation bookinformation) {
		return bookinfoDao.selectBookInformationBybNo(bookinformation);
	}
	
	public List<BookInformation> selectBookInformationBybName(BookInformation bookinformation){
		return bookinfoDao.selectBookInformationBybName(bookinformation);
	}
	
	public List<BookInformation> selectBookInformationBybDivision(BookInformation bookinformation) {
		return bookinfoDao.selectBookInformationBybDivision(bookinformation);
	}
	
	public List<BookInformation> selectBookInformationBybRental(BookInformation bookinformation) {
		return bookinfoDao.selectBookInformationBybRental(bookinformation);
	}
	
	public BookInformation showBookInformationByNo(int bookinformation, BookInformation bNo) {
		return bookinfoDao.selectBookInformationByNo(bNo);
	}
		
	public void addBookinfo(BookInformation bookinformation) {
		bookinfoDao.insertBookInformation(bookinformation);
	}
	
	public void modifyBookinfo(BookInformation bookinformation) {
		bookinfoDao.updateBookInformation(bookinformation);
	}

	public List<BookInformation> showBookInformationList(BookInformation bookInformation) {
		return bookinfoDao.selectBookInformationByAll();
	}
	
	
}
