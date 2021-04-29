package pro_Library.dao;

import java.util.List;

import pro_Library.dto.BookInformation;
import pro_Library.dto.Memberp;
import pro_Library.dto.Profile;

public interface MemberpDao {
	
	List<Memberp> selectMemberpByAll();
	Memberp selectMemberpByNo(Memberp memberp);
	
	Memberp selectLoginMemberp(Memberp memberp);

	int insertMemberp(Memberp memberp);
	int updateMemberp(Memberp memberp);
	int deletMemberp(int pNo);
	
	List<Memberp> selectMemberpByProfile(Memberp memberp);
	List<Memberp> selectMemberpByBookInfomation(BookInformation bookinfo);

}
