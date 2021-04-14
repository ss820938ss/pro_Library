package pro_Library.dao;

import java.util.List;

import pro_Library.dto.BookRegister;

public interface BookRegisterDao {
	
	List<BookRegister> selectBookRegisterByAll();
	
	BookRegister selectBookRegisterByNo(BookRegister bookregister);
	
	int insertBookRegister(BookRegister bookregister);
	
	int updateBookRegister(BookRegister bookregister);
	
	int deleteBookRegister(int bNo);

}
