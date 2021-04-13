package pro_Library.dao;

import java.util.List;

import pro_Library.dto.RentalReturn;

public interface RentalReturnDao {
	List<RentalReturn> selectRentalReturnByAll();

	RentalReturn selectRentalReturnByNo(RentalReturn rentalreturn);

	int insetRentalReturn(RentalReturn rentalreturn);

	int updateRentalReturn(RentalReturn rentalreturn);

	int deleteRentalReturn(int pNo);

}
