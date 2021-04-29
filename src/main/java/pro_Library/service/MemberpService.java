package pro_Library.service;

import java.util.List;

import pro_Library.dao.MemberpDao;
import pro_Library.dao.ProfileDao;
import pro_Library.dao.impl.MemberpDaoImpl;
import pro_Library.dao.impl.ProfileDaoImpl;
import pro_Library.dto.Memberp;

public class MemberpService{
	private MemberpDao mDao = MemberpDaoImpl.getInstance();
	private ProfileDao pDao = ProfileDaoImpl.getInstance();
	
	public List<Memberp> showMemberpList() {
		return mDao.selectMemberpByAll();
	}

	public List<Memberp> selectMemberpByAll() {
		return mDao.selectMemberpByAll();
	}

	public Memberp selectLoginMemberp(Memberp memberp) {
		return mDao.selectLoginMemberp(memberp);
	}

	public int insertMemberp(Memberp memberp) {
		return mDao.insertMemberp(memberp);
	}

	public int deletMemberp(int pNo) {
		return mDao.deletMemberp(pNo);
	}

}
