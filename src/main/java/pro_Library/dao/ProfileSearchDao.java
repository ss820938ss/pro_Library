package pro_Library.dao;

import java.util.List;

import pro_Library.dto.BookInformation;
import pro_Library.dto.Profile;

public interface ProfileSearchDao {
	
	List<Profile> showProfileList();
	
	// 목록조회용
	List<Profile> selectProfileBypNo(Profile profile);
	List<Profile> selectProfileBypName(Profile profile);
	List<Profile> selectProfileBypBirth(Profile profile);
	List<Profile> selectProfileBypPhone(Profile profile);
	List<Profile> selectProfileByppCellphone(Profile profile);
	List<Profile> selectProfileBypAddress(Profile profile);


}
