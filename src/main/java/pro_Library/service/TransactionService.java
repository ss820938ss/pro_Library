package pro_Library.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pro_Library.dto.BookInformation;
import pro_Library.dto.Profile;
import pro_Library.util.JdbcUtil;

public class TransactionService {
	
	public String transAddBookInformationAndProfile(BookInformation bookinfo, Profile profile) {
		String bookinfoSql = "insert into Book_Information values(?, ?, ?, null)";
		String profileSql = "insert into Profile values(?, ?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement bPstmt = null;
		PreparedStatement pPstmt = null;
		
		String res = null;
		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false);
			
			bPstmt = con.prepareStatement(bookinfoSql);
			bPstmt.setInt(1, bookinfo.getbNo());
			bPstmt.setString(2, bookinfo.getbName());
			bPstmt.setString(3, bookinfo.getbDivision());
			bPstmt.setString(3, bookinfo.getbRental());
			bPstmt.executeUpdate();
			
			pPstmt = con.prepareStatement(profileSql);
            pPstmt.setInt(1, profile.getpNo());
            pPstmt.setString(2, profile.getpName());
            pPstmt.setString(3, profile.getpBirth());
            pPstmt.setString(4, profile.getpPhone());
            pPstmt.setString(5, profile.getpCellphone());
            pPstmt.setString(6, profile.getpAddress());
            pPstmt.executeUpdate();

            con.commit();
            res = "commit";
		}catch (SQLException e) {
			res = "rollback";
			rollbackUtil(con);
		}finally {
			System.out.println(res);
			closeUtil(con, bPstmt, pPstmt);
		}
		return res;
	}

	public void closeUtil(Connection con, PreparedStatement bPstmt, PreparedStatement pPstmt) {
		try {
			con.setAutoCommit(true);
			if (bPstmt != null) bPstmt.close();
			if (pPstmt != null) pPstmt.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rollbackUtil(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public int transRemoveBookInformationAndProfile(BookInformation bookinfo, Profile profile) {
		String bookinfoSql = "delete from Book_Information where B_NO = ?";
		String profileSql = "delete from Profile where P_NO = ?";
		
		Connection con = null;
		PreparedStatement bPstmt = null;
		PreparedStatement pPstmt = null;
		
		int res = 0;
		try {
			con = JdbcUtil.getConnection();
			con.setAutoCommit(false);
			
			System.out.println("res > " + res);
			bPstmt = con.prepareStatement(bookinfoSql);
			bPstmt.setInt(1, bookinfo.getbNo());
			res += bPstmt.executeUpdate();
			System.out.println("res > " + res);
			
			pPstmt = con.prepareStatement(profileSql);
            pPstmt.setInt(1, profile.getpNo());
            res += pPstmt.executeUpdate();
            System.out.println("res > " + res);
            
            if (res == 2) {
            	con.commit();
                System.out.println("commit()");
            }else {
            	throw new SQLException();
            }
		}catch (SQLException e) {
			rollbackUtil(con);
		}finally {
			closeUtil(con, bPstmt, pPstmt);
		}
		return res;
	}
}
