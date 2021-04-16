package pro_Library.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import pro_Library.dao.impl.RentalReturnDaoImpl;
import pro_Library.dto.RentalReturn;

public class RentalReturnDaoTest {
	private static RentalReturnDao dao = RentalReturnDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01InsetRentalReturn() {
		System.out.printf("%s()%n", "testInsetRentalReturn");
		RentalReturn newRentalReturn = new RentalReturn(12001, 40001, null, null, null);
		int res = dao.insetRentalReturn(newRentalReturn);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectRentalReturnByNo(newRentalReturn));
	}

	@Test
	public void test02UpdateRentalReturn() {
		System.out.printf("%s()%n", "testUpdateRentalReturn");
		RentalReturn newRentalReturn = new RentalReturn(12001, 40001, null, null, null);
		int res = dao.updateRentalReturn(newRentalReturn);
		Assert.assertNotNull(1);
		System.out.println(dao.selectRentalReturnByNo(newRentalReturn));
	}

	@Test
	public void test03DeleteRentalReturn() {
		System.out.printf("%s()%n", "testDeleteRentalReturn");
		int res = dao.deleteRentalReturn(120012);
		Assert.assertNotNull(1);
		dao.selectRentalReturnByAll().stream().forEach(System.out::println);
	}
	
	@Test
	public void test04SelectRentalReturnByAll() {
		System.out.printf("%s()%n", "testSelectRentalReturnByAll");
		List<RentalReturn> RentalReturnList = dao.selectRentalReturnByAll();
		Assert.assertNotNull(RentalReturnList);
		
		for (RentalReturn rr : RentalReturnList) {
			System.out.println(rr);
		}
	}

	@Test
	public void test05SelectRentalReturnByNo() {
		System.out.printf("%s()%n", "testSelectRentalReturnByNo");
		RentalReturn rentalreturn = new RentalReturn(12001);
		RentalReturn RentalReturn = dao.selectRentalReturnByNo(rentalreturn);
		Assert.assertNotEquals(1, rentalreturn);
		System.out.println(RentalReturn);
	}

}
