package pro_Library.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pro_Library.dao.impl.ProfileDaoImpl;
import pro_Library.dto.Profile;

public class ProfileDaoTest {
	private static ProfileDao dao = ProfileDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void test04SelectProfileByAll() {
		System.out.printf("%s()%n", "testSelectProfileByAll");
		List<Profile> profileList = dao.selectProfileByAll();
		Assert.assertNotNull(ProfileList);

		for(Profile p : ProfileList) {
			System.out.println(t);
		}
	}
	
	@Test
	public void test01InsertProfile() {
		System.out.printf("%s()%n", "testInsertProfile");
		Profile newProfile = new Profile(12012, "김경우", new Date(19980204), "053-989-0495", "010-3434-2233", "서울");
		int res = dao.insertProfile(newProfile);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectProfileByNo(newProfile));
	}
	
	@Test
	public void test02UpdateProfile() {
		System.out.printf("%s()%n", "testUpdateProfile");
		Profile newProfile = new Profile(12012, "김경우", new Date(19980204), "053-989-0495", "010-3434-2233", "서울");
		int res = dao.updateProfile(newProfile);
		Assert.assertEquals(1, res);
		System.out.println(dao.selectProfileByNo(newProfile));
	}
	
	@Test
	public void test03DeleteProfile() {
		System.out.printf("%s()%n", "testDeleteProfile");
		int res = dao.deleteProfile(12012);
		Assert.assertEquals(1, res);
		dao.selectProfileByAll().stream().forEach(System.out::println);
	}
	
	
	
	

}
