package pro_Library.dao;

import java.util.List;

import pro_Library.dto.BookDeinfo;

public interface BookDeinfoDao {
//	BookDeinfo
//	BookDeinfo bookbeinfo
	
	// list
	List<BookDeinfo> selectBookDeinfoByAll();
	
	List<BookDeinfo> selectBookDeinfoBybNo(BookDeinfo bookbeinfo);
	List<BookDeinfo> selectBookDeinfoBybName(BookDeinfo bookbeinfo);
	List<BookDeinfo> selectBookDeinfoBybDivision(BookDeinfo bookbeinfo);
	List<BookDeinfo> selectBookDeinfoBybImg(BookDeinfo bookbeinfo);
	
	BookDeinfo selectBookDeinfoBybbNo(int bNo);
	
	int insertBookDeinfo(BookDeinfo bookdeinfo);
	int updateBookDeinfo(BookDeinfo bookdeinfo);
	int deleteBookDeinfo(int bNo);

}
