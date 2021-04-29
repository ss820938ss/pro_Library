package pro_Library.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import pro_Library.dao.impl.MemberpDaoImpl;
import pro_Library.dto.Memberp;

public class MemberpDaoTest {
	private static MemberpDao dao = MemberpDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectMemberpByAll() {
		System.out.printf("%s()%n", "testSelectMemberpByAll");
		List<Memberp> MemberpList = dao.selectMemberpByAll();
		Assert.assertNotNull(MemberpList);
		
		for (Memberp mp : MemberpList) {
			System.out.println(mp);
		}

	}

	@Test
	public void test02SelectLoginMemberp() {
		System.out.printf("%s()%n", "testSelectLoginMemberp");
	}

	@Test
	public void test03InsertMemberp() {
		System.out.printf("%s()%n", "testInsertMemberp");
		Memberp newMemberp = new Memberp(12001, "member1", "1234");
		int res = dao.insertMemberp(newMemberp);
		Assert.assertNotEquals(1, res);
		System.out.println(dao.selectMemberpByAll());
	}

	@Test
	public void test04DeletMemberp() {
		System.out.printf("%s()%n", "testDeletMemberp");
		int res = dao.deletMemberp(12012);
		Assert.assertNotNull(1);
		dao.selectMemberpByAll().stream().forEach(System.out::println);
	}

}
