package pro_Library.dao;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import pro_Library.dto.BookInformation;

public interface BookSearchDao {
	List<BookInformation> showBookInformationList();

	// 목록조회용
	List<BookInformation> selectBookInformationBybNo(BookInformation bookinformation);
	List<BookInformation> selectBookInformationBybName(BookInformation bookinformation);
	List<BookInformation> selectBookInformationBybDivision(BookInformation bookinformation);
	List<BookInformation> selectBookInformationBybRental(BookInformation bookinformation);
}
