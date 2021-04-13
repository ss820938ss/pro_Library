package pro_Library.dao;

import java.util.List;

import pro_Library.dto.BookInformation;

public interface BookInformationDao {
	
	List<BookInformation> selectBookInformationByAll();

	BookInformation selectBookInformationByNo(BookInformation bookinformation);

	int insertBookInformation(BookInformation bookinformation);

	int updateBookInformation(BookInformation bookinformation);

	int deleteBookInformation(int bNo);

}
