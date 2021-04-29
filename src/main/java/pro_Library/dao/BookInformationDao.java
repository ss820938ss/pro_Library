package pro_Library.dao;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import pro_Library.dto.BookInformation;

public interface BookInformationDao {
	
	List<BookInformation> selectBookInformationByAll(DefaultTableModel dt);
	BookInformation selectBookInformationByNo(BookInformation bookinformation);
	
	List<BookInformation> showBookInformationList();

	
	// 목록조회용
	List<BookInformation> selectBookInformationBybNo(BookInformation bookinformation);
	List<BookInformation> selectBookInformationBybName(BookInformation bookinformation);
	List<BookInformation> selectBookInformationBybDivision(BookInformation bookinformation);
	List<BookInformation> selectBookInformationBybRental(BookInformation bookinformation);
	
	// insert, update, delete
	int insertBookInformation(BookInformation bookinformation);
	int updateBookInformation(BookInformation bookinformation);
	int deleteBookInformation(int bNo);
	void getUserSearch(DefaultTableModel dt, String fieldName, String text);
	List<BookInformation> selectBookInformationByAll();


}
