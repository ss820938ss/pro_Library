package pro_Library.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pro_Library.dao.impl.BookRegisterDaoImpl;
import pro_Library.dto.BookRegister;

public class BookRegisterDaoTest {
	private static BookRegisterDao dao = BookRegisterDaoImpl.getInstance();

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01InsertBookRegister() {
		System.out.printf("%s()%n", "testInsertBookRegister");
		BookRegister newBookRegister = new BookRegister(40001, "The elements of statistical learning", "수학");
		int res = dao.insertBookRegister(newBookRegister);
		Assert.assertNotEquals(1, res);
		System.out.println(dao.selectBookRegisterByNo(newBookRegister));
	}

	@Test
	public void test02UpdateBookRegister() {
		System.out.printf("%s()%n", "testUpdateBookRegister");
		BookRegister newBookRegister = new BookRegister(40001, "The elements of statistical learning", "수학");
		int res = dao.updateBookRegister(newBookRegister);
		Assert.assertNotNull(1);
		System.out.println(dao.selectBookRegisterByNo(newBookRegister));
	}

	@Test
	public void test03DeleteBookRegister() {
		System.out.printf("%s()%n", "testDeleteBookRegister");
		int res = dao.deleteBookRegister(40011);
		Assert.assertNotNull(1);
		dao.selectBookRegisterByAll().stream().forEach(System.out::println);
	}
	
	@Test
	public void test04SelectBookRegisterByAll() {
		System.out.printf("%s()%n", "testSelectBookRegisterByAll");
		List<BookRegister> BookRegisterList = dao.selectBookRegisterByAll();
		Assert.assertNotNull(BookRegisterList);
		
		for (BookRegister br : BookRegisterList) {
			System.out.println(br);
		}
	}

	@Test
	public void SelectBookRegisterByNo() {
		System.out.printf("%s()%n", "testSelectBookRegisterByNo");
		BookRegister bookregister = new BookRegister(40001);
		BookRegister BookRegister = dao.selectBookRegisterByNo(bookregister);
		Assert.assertNotEquals(1, BookRegister);
		System.out.println(BookRegister);
	}

}
