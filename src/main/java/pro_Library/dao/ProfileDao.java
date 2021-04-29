package pro_Library.dao;

import java.util.List;

import pro_Library.dto.Profile;

public interface ProfileDao {
	List<Profile> selectProfileByAll();
	Profile selectProfileByNo(Profile profile);

	int insertProfile(Profile profile);
	int updateProfile(Profile profile);
	int deleteProfile(int pNo);

}
