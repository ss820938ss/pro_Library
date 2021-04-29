package pro_Library.service;

import java.util.List;

import pro_Library.dao.MemberpDao;
import pro_Library.dao.ProfileDao;
import pro_Library.dao.impl.MemberpDaoImpl;
import pro_Library.dao.impl.ProfileDaoImpl;
import pro_Library.dto.Memberp;
import pro_Library.dto.Profile;

public class ProfileService {
	private ProfileDao pDao = ProfileDaoImpl.getInstance();
	private MemberpDao mDao = MemberpDaoImpl.getInstance();

	public List<Profile> showProfiles() {
		return pDao.selectProfileByAll();
	}

	public void addProfile(Profile Profile) {
		pDao.insertProfile(Profile);
	}
	
	public void removeProfile(Profile Profile) {
		pDao.deleteProfile(Profile.getpNo());
	}
	
	public void modifyProfile(Profile Profile) {
		pDao.updateProfile(Profile);
	}
	
	public List<Memberp> showMemberpGroupByProfile(Memberp profile) {
		return mDao.selectMemberpByProfile(profile);
	}

}
