package pro_Library;

import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;

import pro_Library.util.JdbcUtil;

public class JdbcUtilTest {


	@Test
	public void testConnection() {
		Connection con = JdbcUtil.getConnection();
		Assert.assertNotNull(con);
		
		System.out.println("con >>" + con);
	}

}