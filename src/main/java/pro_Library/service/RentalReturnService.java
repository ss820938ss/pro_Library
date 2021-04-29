package pro_Library.service;

import java.util.List;

import pro_Library.dao.RentalReturnDao;
import pro_Library.dao.impl.RentalReturnDaoImpl;
import pro_Library.dto.RentalReturn;

public class RentalReturnService {
	private RentalReturnDao rtDao = RentalReturnDaoImpl.getInstance();
	
	public List<RentalReturn> showRentalReturnList() {
		return rtDao.selectRentalReturnByAll();
	}

	public List<RentalReturn> selectRentalReturnByAll() {
		return rtDao.selectRentalReturnByAll();
	}

	public RentalReturn selectRentalReturnByNo(RentalReturn rentalreturn) {
		return rtDao.selectRentalReturnByNo(rentalreturn);
	}

	public int insetRentalReturn(RentalReturn rentalreturn) {
		return rtDao.insetRentalReturn(rentalreturn);
	}

	public int updateRentalReturn(RentalReturn rentalreturn) {
		return rtDao.updateRentalReturn(rentalreturn);
	}

	public int deleteRentalReturn(int pNo) {
		return rtDao.deleteRentalReturn(pNo);
	}
}
