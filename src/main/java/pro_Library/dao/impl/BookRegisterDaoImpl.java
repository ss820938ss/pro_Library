package pro_Library.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pro_Library.dao.BookRegisterDao;
import pro_Library.database.JdbcConn;
import pro_Library.dto.BookRegister;

public class BookRegisterDaoImpl implements BookRegisterDao {
	private static BookRegisterDaoImpl instance = new BookRegisterDaoImpl();
	
	public static BookRegisterDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<BookRegister> selectBookRegisterByAll() {
		String sql = "select B_NO, B_NAME, B_DIVISION from bookregister";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<BookRegister> list = new ArrayList<>();
				do {
					list.add(getBookRegister(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BookRegister getBookRegister(ResultSet rs) throws SQLException {
		int bNo = rs.getInt("B_NO");
		String bName = rs.getString("B_NAME");
		String bDivision = rs.getString("B_DIVISION");
		
		return new BookRegister(bNo, bName, bDivision);
	}

	@Override
	public BookRegister selectBookRegisterByNo(BookRegister bookregister) {
		String sql = "select B_NO, B_NAME, B_DIVISION from bookregister where B_NO = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bookregister.getbNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getBookRegister(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertBookRegister(BookRegister bookregister) {
		String sql = "insert into bookregister values (?, ?, ?)";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bookregister.getbNo());
			pstmt.setString(2, bookregister.getbName());
			pstmt.setString(3, bookregister.getbDivision());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBookRegister(BookRegister bookregister) {
		String sql = "update bookregister" + 
					 "set B_NO = ?, B_NAME = ?, B_DIVISION = ? where B_NO = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bookregister.getbNo());
			pstmt.setString(2, bookregister.getbName());
			pstmt.setString(3, bookregister.getbDivision());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBookRegister(int bNo) {
		String sql = "delete from bookregister b where B_NO = ?";
		try (Connection con = JdbcConn.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, bNo);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
