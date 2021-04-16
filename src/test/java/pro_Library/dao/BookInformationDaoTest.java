package pro_Library.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import pro_Library.dao.impl.BookInformationDaoImpl;
import pro_Library.dto.BookInformation;

public class BookInformationDaoTest {
	private static BookInformationDao dao = BookInformationDaoImpl.GetInstance();
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void test01InsertBookInformation() {
		System.out.printf("%s()%n", "testInsertBookInformation");
		BookInformation newBookInformation = new BookInformation(40001, "The elements of statistical learning", "수학", null);
		int res = dao.insertBookInformation(newBookInformation);
		Assert.assertNotEquals(1, res);
		System.out.println(dao.selectBookInformationByNo(newBookInformation));
	}
	
	@Test
	public void test02UpdateBookInformation() {
		System.out.printf("%s()%n", "testUpdateBookInformation");
		BookInformation newBookInformation = new BookInformation(40001, "The elements of statistical learning", "수학", null);
		int res = dao.updateBookInformation(newBookInformation);
		Assert.assertNotNull(1);
		System.out.println(dao.selectBookInformationByNo(newBookInformation));
	}
	
	@Test
	public void test03DeleteBookInformation() {
		System.out.printf("%s()%n", "testDeleteBookInformation");
		int res = dao.deleteBookInformation(40011);
		Assert.assertNotNull(1);
		dao.selectBookInformationByAll().stream().forEach(System.out::println);
	}
	
	@Test
	public void test04SelectBookInformationByAll() {
		System.out.printf("%s()%n", "testSelectBookInformationByAll");
		List<BookInformation> BookInformationList = dao.selectBookInformationByAll();
		Assert.assertNotNull(BookInformationList);
		
		for (BookInformation bi : BookInformationList) {
			System.out.println(bi);
		}
	}
	
	@Test
	public void test05SelectBookInformationByNo() {
		System.out.printf("%s()%n", "testSelectBookInformationByNo");
		BookInformation bookinformation = new BookInformation(40001);
		BookInformation Bookinformation = dao.selectBookInformationByNo(bookinformation);
		Assert.assertNotEquals(1, bookinformation);
		System.out.println(Bookinformation);
		
	}
	
}